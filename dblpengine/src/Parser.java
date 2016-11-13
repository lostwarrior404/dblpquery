import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Parser{
    void parse(String file_path){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
            boolean author_present = false;
            boolean title_present = false;
            boolean pages_present = false;
            boolean year_present = false;
            boolean volume_present = false;
            boolean journal_present = false;
            boolean booktitle_present = false;
            boolean url_present = false;
            String k;//String to store key
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if(     qName.equalsIgnoreCase("article")|
                        qName.equalsIgnoreCase("inproceedings")|
                        qName.equalsIgnoreCase("proceedings")|
                        qName.equalsIgnoreCase("book")|
                        qName.equalsIgnoreCase("incollection")|
                        qName.equalsIgnoreCase("phdthesis")|
                        qName.equalsIgnoreCase("mastersthesis")|
                        qName.equalsIgnoreCase("www")){
                    System.out.println(qName+" started:");
                    if(attributes.getLength()>0 && (k=attributes.getValue("key"))!=null){
                        System.out.println("key = "+k);
                    }
                }
                if(qName.equalsIgnoreCase("author")){
                    author_present = true;
                }
                if(qName.equalsIgnoreCase("title")){
                    title_present = true;
                }
                if(qName.equalsIgnoreCase("pages")){
                    pages_present = true;
                }
                if(qName.equalsIgnoreCase("year")){
                    year_present = true;
                }
                if(qName.equalsIgnoreCase("volume")){
                    volume_present = true;
                }
                if(qName.equalsIgnoreCase("journal")){
                    journal_present = true;
                }
                if(qName.equalsIgnoreCase("booktitle")){
                    booktitle_present = true;
                }
                if(qName.equalsIgnoreCase("url")){
                    url_present = true;
                }
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                if(author_present){
                    System.out.println("Author :"+new String(ch,start,length));
                    author_present=false;
                }
                if(title_present){
                    System.out.println("Title :"+new String(ch,start,length));
                    title_present=false;
                }
                if(pages_present){
                    System.out.println("Pages :"+new String(ch,start,length));
                    pages_present=false;
                }
                if(year_present){
                    System.out.println("Year :"+new String(ch,start,length));
                    year_present=false;
                }
                if(volume_present){
                    System.out.println("Volume :"+new String(ch,start,length));
                    volume_present = false;
                }
                if(journal_present){
                    System.out.println("Journal :"+new String(ch,start,length));
                    journal_present = false;
                }
                if(booktitle_present){
                    System.out.println("Book Title :"+new String(ch,start,length));
                    booktitle_present = false;
                }
                if(url_present){
                    System.out.println("URL :"+new String(ch,start,length));
                    url_present = false;
                }

            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                if(     qName.equalsIgnoreCase("article")|
                        qName.equalsIgnoreCase("inproceedings")|
                        qName.equalsIgnoreCase("proceedings")|
                        qName.equalsIgnoreCase("book")|
                        qName.equalsIgnoreCase("incollection")|
                        qName.equalsIgnoreCase("phdthesis")|
                        qName.equalsIgnoreCase("mastersthesis")|
                        qName.equalsIgnoreCase("www")){
                    System.out.println(qName+" ended.");
                }
                //Make object here;
            }
        };
        saxParser.parse(file_path, handler);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
