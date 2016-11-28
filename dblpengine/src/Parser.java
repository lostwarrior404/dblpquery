import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Parser{
    ArrayList<String> www;
    ArrayList<Publication> parse(String file_path, final ArrayList<String> author,final int type){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            SAXParser saxParser = factory.newSAXParser();
            final ArrayList<Publication> result = new ArrayList<Publication>();
            DefaultHandler handler = new DefaultHandler(){
                boolean publication = false;
                boolean names = false;
                boolean author_present = false;
                boolean title_present = false;
                boolean pages_present = false;
                boolean year_present = false;
                boolean volume_present = false;
                boolean journal_present = false;
                boolean booktitle_present = false;
                boolean url_present = false;
                boolean author_match = false;
                boolean title_match =false;
                String data_acc="";
                Publication paper;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if(     qName.equalsIgnoreCase("article")|
                            qName.equalsIgnoreCase("inproceedings")|
                            qName.equalsIgnoreCase("proceedings")|
                            qName.equalsIgnoreCase("book")|
                            qName.equalsIgnoreCase("incollection")|
                            qName.equalsIgnoreCase("phdthesis")|
                            qName.equalsIgnoreCase("mastersthesis")|(qName.equalsIgnoreCase("www")&& !attributes.getValue("key").matches("homepages/(.*)"))){
                        publication = true;
                        paper = new Publication();

                        //                    System.out.println(qName+" started:");
                        //                    if(attributes.getLength()>0 && (k=attributes.getValue("key"))!=null){
                        //                        System.out.println("key = "+k);
                        //                    }
                    }
                    if(qName.equalsIgnoreCase("author") | qName.equalsIgnoreCase("editor")){
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
                    if(publication){
                        if(     qName.equalsIgnoreCase("article")|
                            qName.equalsIgnoreCase("inproceedings")|
                            qName.equalsIgnoreCase("proceedings")|
                            qName.equalsIgnoreCase("book")|
                            qName.equalsIgnoreCase("incollection")|
                            qName.equalsIgnoreCase("phdthesis")|
                            qName.equalsIgnoreCase("mastersthesis")|qName.equalsIgnoreCase("www")
                            ){
                        publication = false;
                        if(type==1){
                            if(author_match){
                                result.add(paper);
                                author_match = false;
                            }
                        }
                        if(type==2){
                            if(title_match){
                                result.add(paper);
                                title_match = false;
                            }
                        }
                        paper = null;
                    }
                        if (qName.equalsIgnoreCase("author") | qName.equalsIgnoreCase("editor")) {
                            author_present = false;
                            paper.setAuthor(data_acc);
                            if(type==1){
                                for(String i:author){
                                    if(i.equalsIgnoreCase(data_acc)){
                                        author_match=true;
                                    }
                                }
                            }
                        }
                        if (qName.equalsIgnoreCase("title")) {
                            title_present = false;
                            paper.setTitle(data_acc);
                            if(type==2){
                                if(work.cosineSimilarity(author.get(0),data_acc)>0.47){
                                    paper.setSimilarity(work.cosineSimilarity(author.get(0),data_acc));
                                    title_match = true;
                                }
                            }
                        }
                            //System.out.println("title: "+data_acc);

                        if (qName.equalsIgnoreCase("pages")) {
                            pages_present = false;
                            paper.setPages(data_acc);
                            //System.out.println("pages: "+data_acc);
                        }
                        if (qName.equalsIgnoreCase("year")) {
                            year_present = false;
                            paper.setYear(data_acc);
                            //System.out.println("year: "+data_acc);
                        }
                        if (qName.equalsIgnoreCase("volume")) {
                            volume_present = false;
                            paper.setVolume(data_acc);
                            //System.out.println("volume: "+data_acc);
                        }
                        if (qName.equalsIgnoreCase("journal")) {
                            journal_present = false;
                            paper.setJournal(data_acc);
                            //System.out.println("journal: "+data_acc);
                        }
                        if (qName.equalsIgnoreCase("booktitle")) {
                            booktitle_present = false;
                            paper.setBooktitle(data_acc);
                            //System.out.println("booktitle: "+data_acc);
                        }
                        if (qName.equalsIgnoreCase("url")) {
                            url_present = false;
                            paper.setUrl(data_acc);
                            //System.out.println("url: "+data_acc);
                        }
                    }
                    data_acc = "";
                    //Make object here;
                }
            };
            saxParser.parse(file_path, handler);
            return result;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}