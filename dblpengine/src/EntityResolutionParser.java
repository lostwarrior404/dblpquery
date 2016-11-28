/**
 * Created by Tushar Kataria on 26-Nov-16.
 */
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedWriter;
import java.io.*;


import java.util.ArrayList;
import java.util.HashSet;

public class EntityResolutionParser {
    void parse(String file_path) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean publication = false;
                boolean author_present = false;
                String data_acc = "";
                String k="";
                String alias = "";

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("www")) {

                            if(attributes.getLength()>0 && (k=attributes.getValue("key"))!=null){
                                if(k.substring(0,9).equalsIgnoreCase("homepages")){
                                   // System.out.println(attributes.getValue("key"));
                                    publication=true;
                                }
                            }
                    }
                    if (qName.equalsIgnoreCase("author")|qName.equalsIgnoreCase("editor")) {
                        author_present = true;
                    }
                }
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (author_present && publication) {
                        data_acc += new String(ch, start, length);
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (publication) {
                    if (qName.equalsIgnoreCase("www")){
                        publication = false;
                        try {
                            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("wwww.csv", true), "utf-8"));
                            if(alias!=""){writer.write(alias.substring(0,alias.length()-1));
                            alias="";
                            writer.write(System.lineSeparator());}
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                        if (qName.equalsIgnoreCase("author")|qName.equalsIgnoreCase("editor")) {
                            author_present = false;
                            alias+=data_acc+",";
                        }
                    }

                    data_acc = "";
                }

            };
            saxParser.parse(file_path, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
