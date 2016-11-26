/**
 * Created by Tushar Kataria on 26-Nov-16.
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashSet;

public class EntityResolutionParser {
    HashSet<String> parse(String file_path, final String author) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            final HashSet<String> result = new HashSet<String>();
            DefaultHandler handler = new DefaultHandler() {
                boolean publication = false;
                boolean author_present = false;
                boolean author_match = false;
                String data_acc = "";
                ArrayList<String> alias=new ArrayList<String>();
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("www")) {
                        //System.out.println(qName + "Started");
                        publication = true;

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
                    if (author_present && publication) {
                        data_acc += new String(ch, start, length);
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("www")){
                        publication = false;
                        if(!author_match){
                            alias.clear();
                        }
                        if (author_match) {
                            for(String i:alias){
                                result.add(i);
                            }
                            author_match=false;
                        }

                    }
                    if (publication) {
                        if (qName.equalsIgnoreCase("author")) {
                            author_present = false;
                            alias.add(data_acc);
                            //System.out.println("Author: "+data_acc);
                            if (author.equalsIgnoreCase(data_acc)) {
//                                int c=5555;
//                                while(c--!=0){System.out.println("Mil gya!!");}
                                author_match = true;
                            }
                        }
                        data_acc = "";
                    }//Make object here;
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
