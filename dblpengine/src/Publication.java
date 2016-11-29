import java.util.ArrayList;

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
    private double similarity=0.0;
    public ArrayList<String> getAuthor(){
        return author;
    }
    public double getSimilarity(){
        return this.similarity;
    }
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

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
        return Integer.parseInt(year);
    }
    public Publication(){

    }
    public String toString(){
        if(author.size()==0){
            return "Author :none "+" Year "+year+" Title "+title+" Pages "+pages+" Url "+url+" Volume "+volume;
        }
        if( author.get(0)==null){
            return "Author :none "+" Year "+year+" Title "+title+" Pages "+pages+" Url "+url+" Volume "+volume;
        }
        return "Author "+author.get(0)+" Year "+year+" Title "+title+" Pages "+pages+" Url "+url+" Volume "+volume+"Similarity"+similarity;
    }
    public String [] toArray(){
        //sno//authors//title//pages//year // volume // journal booktitle url
        String [] a = new String[7];
        if(author.size()==0){a[0]="";}
        else if(author.get(0)==null){
            a[0]="";
        }
        else{
            String temp = "";
            for (String aa : author) {
                temp += aa + ",";
            }
            temp = temp.substring(0, temp.length() - 1);
            a[0]=temp;
        }

            a[1]=title;
            a[2]=pages;
            a[3]=year;
            a[4]=volume;
            if(booktitle==""){
                a[5]=journal;
            }
            if(journal==""){
                a[5]=booktitle;
            }
            a[6]=url;

        return a;
    }

    public int compareTo(Publication o) {
        return (this.getYear() < o.getYear() ? -1 :
                (this.getYear() == o.getYear() ? 0 : 1));
    }
}
