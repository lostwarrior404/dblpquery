import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Saksham on 11/26/2016.
 */
public class Publication implements Comparable<Publication>{

    private ArrayList<String> author=new ArrayList<String>();
    private String year="";
    private String title="";
    private String pages="";
    private String url="";
    private String volume="";
    private String journal="";
    private String booktitle="";
    public void setAuthor(String a) {
        author.add(a);
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    public void setYear(String a){
        year=a;
    }
    public int getYear(){
        return Integer.parseInt(this.year);
    }
    public Publication(){

    }
    public String toString(){
        if(author.get(0)==null){
            return "Author :none "+" Year "+year+" Title "+title+" Pages "+pages+" Url "+url+" Volume "+volume;

        }
        return "Author "+author.get(0)+" Year "+year+" Title "+title+" Pages "+pages+" Url "+url+" Volume "+volume;
    }

    public int compareTo(Publication o) {
        return (this.getYear() < o.getYear() ? -1 :
                (this.getYear() < o.getYear() ? 0 : 1));
    }
}
