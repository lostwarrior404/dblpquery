import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Query1 {
    ArrayList<Publication> data;
    int year,year1,year2;
    int qtype;
    String name;
    public ArrayList<Publication> sort(int subtype){
        Collections.sort(data, new Comparator<Publication>() {
            public int compare(Publication o1, Publication o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.reverse(data);
        if(subtype==1){
           return data;
        }
        if(subtype==2){
            //only for type 2 query
            Collections.sort(data, new Comparator<Publication>() {
                public int compare(Publication o1, Publication o2) {
                    return (o1.getSimilarity() < o2.getSimilarity() ? -1 :
                            (o1.getYear() == o2.getSimilarity() ? 0 : 1));
                }
            });
            return data;
        }
        if(subtype==3){
            ArrayList<Publication> temp=new ArrayList<Publication>();
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        if(subtype==4){
            ArrayList<Publication> temp=new ArrayList<Publication>();
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year1 && data.get(i).getYear()<=year2){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        return data;
    }
    public void setQtype(int a){
        qtype=a;
    }

    public void setName(String a){
        name=a;
    }
    public void createGui(){
        System.out.println("q1");
    }
    public ArrayList<Publication> parse(String name,int type){//give arraylist of string
        Parser p=new Parser();
        ArrayList<String> author;
        //an arraylist named author if search by author else an arraylist with title at index 0
        data = p.parse("dblp.xml",author,type);//author is an array
        this.setQtype(type);
        this.setName(name);//can be name or title
        return data;
    }
}
