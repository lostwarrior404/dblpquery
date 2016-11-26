/**
 * Created by Tushar Kataria on 26-Nov-16.
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
public class EntityResolutionParser {
    ArrayList<String> parse(String file_path, final String author) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            final ArrayList<String> result = new ArrayList<String>();
            DefaultHandler handler = new DefaultHandler() {
                boolean publication = false;
                boolean author_present = false;
                boolean author_match = false;
                String data_acc = "";
                String alias;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("www")) {
                        publication = true;
                        alias = "";

                        //                    System.out.println(qName+" started:");
                        //                    if(attributes.getLength()>0 && (k=attributes.getValue("key"))!=null){
                        //                        System.out.println("key = "+k);
                        //                    }
                    }
                    if (qName.equalsIgnoreCase("author")) {
                        author_present = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (author_present) {
                        data_acc += new String(ch, start, length);
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("www")){
                        publication = false;
                        if (author_match) {
                            result.add(alias);
                            author_match = false;
                        }
                        alias = null;
                    }


                    if (publication) {
                        if (qName.equalsIgnoreCase("author")) {
                            author_present = false;
                            alias = data_acc;
                            if (author.equalsIgnoreCase(data_acc)) {
                                author_match = true;
                            }
                        }
                    data_acc = "";
                    //Make object here;
                }
            };
            saxParser.parse(file_path, handler);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
