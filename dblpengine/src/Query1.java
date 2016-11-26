import java.util.ArrayList;
import java.util.Collections;

public class Query1 {
    ArrayList<Publication> data;
    public ArrayList<Publication> sort(int type){
        if(type==1){
            Collections.sort(data);
        }
        return data;
    }

    public void createGui(){
        System.out.println("q1");
    }
    public ArrayList<Publication> parse(String author){
        Parser p=new Parser();
        ArrayList<Publication> data = p.parse("dblp.xml",author);
        return data;
    }
}
