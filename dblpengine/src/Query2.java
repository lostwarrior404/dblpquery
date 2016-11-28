import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.HashMap;

public class Query2 {
    HashMap<String,Integer> parse(String file_path,final int k){
          SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            final ArrayList<String> result = new ArrayList<String>();
            final HashMap<String,Integer> maps = new HashMap<String,Integer>();
            DefaultHandler handler = new DefaultHandler(){
                boolean publication = false;
                boolean author_present = false;
                String data_acc="";
                ArrayList<String> temp = new ArrayList<String>();
                boolean www_present = false;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if(     qName.equalsIgnoreCase("article")|
                            qName.equalsIgnoreCase("inproceedings")|
                            qName.equalsIgnoreCase("proceedings")|
                            qName.equalsIgnoreCase("book")|
                            qName.equalsIgnoreCase("incollection")|
                            qName.equalsIgnoreCase("phdthesis")|
                            qName.equalsIgnoreCase("mastersthesis") |(qName.equalsIgnoreCase("www")&& !attributes.getValue("key").matches("homepages/(.*)")) ){
                        publication = true;

                        //                    System.out.println(qName+" started:");
                        //                    if(attributes.getLength()>0 && (k=attributes.getValue("key"))!=null){
                        //                        System.out.println("key = "+k);
                        //                    }
                    }
                    if(qName.equalsIgnoreCase("author")){
                        author_present = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if(author_present){
                        data_acc+=new String(ch,start,length);
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if(publication){
                    if(     qName.equalsIgnoreCase("article")|
                            qName.equalsIgnoreCase("inproceedings")|
                            qName.equalsIgnoreCase("proceedings")|
                            qName.equalsIgnoreCase("book")|
                            qName.equalsIgnoreCase("incollection")|
                            qName.equalsIgnoreCase("phdthesis")|
                            qName.equalsIgnoreCase("mastersthesis")
                            |qName.equalsIgnoreCase("www")){
                        publication = false;
                    }

                        if (qName.equalsIgnoreCase("author")|qName.equalsIgnoreCase("editor")) {
                            author_present = false;
                            if(maps.containsKey(data_acc)){
                                maps.put(data_acc,maps.get(data_acc)+1);
                            }
                            else{
                                maps.put(data_acc,1);
                            }
                        }
                    }
                    data_acc = "";
                    //Make object here;
                }
            };
            saxParser.parse(file_path, handler);
            return maps;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
