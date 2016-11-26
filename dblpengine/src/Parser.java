
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
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
            String data_acc;
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
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("title")){
                    title_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("pages")){
                    pages_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("year")){
                    year_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("volume")){
                    volume_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("journal")){
                    journal_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("booktitle")){
                    booktitle_present = true;
                    data_acc = new String();
                }
                if(qName.equalsIgnoreCase("url")){
                    url_present = true;
                    data_acc = new String();
                }
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                if(author_present | title_present | pages_present | year_present | volume_present | journal_present
                        | booktitle_present | url_present){
                    data_acc+=new String(ch,start,length);
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
                if(qName.equalsIgnoreCase("author")){
                    author_present = false;
                    System.out.println("author: "+data_acc);
                }
                if(qName.equalsIgnoreCase("title")){
                    title_present = false;
                    System.out.println("title: "+data_acc);
                }
                if(qName.equalsIgnoreCase("pages")){
                    pages_present = false;
                    System.out.println("pages: "+data_acc);
                }
                if(qName.equalsIgnoreCase("year")){
                    year_present = false;
                    System.out.println("year: "+data_acc);
                }
                if(qName.equalsIgnoreCase("volume")){
                    volume_present = false;
                    System.out.println("volume: "+data_acc);
                }
                if(qName.equalsIgnoreCase("journal")){
                    journal_present = false;
                    System.out.println("journal: "+data_acc);
                }
                if(qName.equalsIgnoreCase("booktitle")){
                    booktitle_present = false;
                    System.out.println("booktitle: "+data_acc);
                }
                if(qName.equalsIgnoreCase("url")){
                    url_present = false;
                    System.out.println("url: "+data_acc);
                }
                data_acc = null;
                //Make object here;
            }
        };
        saxParser.parse(file_path, handler);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
