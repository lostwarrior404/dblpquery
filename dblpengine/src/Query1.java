import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Query1 {
    ArrayList<Publication> data;
    public ArrayList<Publication> sort(int type){
        if(type==1){
            Collections.sort(data, new Comparator<Publication>() {
                public int compare(Publication o1, Publication o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        return data;
    }

    public void createGui(){
        System.out.println("q1");
    }
    public ArrayList<Publication> parse(String author){
        Parser p=new Parser();
        data = p.parse("dblp.xml",author);
        return data;
    }
}
