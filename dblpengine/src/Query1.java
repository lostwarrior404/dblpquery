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
        if(subtype==1){
           return data;
        }
        if(subtype==2){
            //substring or word i need first author name to be the searched one
            ArrayList<Publication> temp=new ArrayList<Publication>();
            if(qtype==1){
                for(int i=0;i<data.size();i++){

                    if(work.cosineSimilarity(data.get(i).getAuthor().get(0),name)>0.6){
                        temp.add(data.get(i));
                    }
                }
                //now sort by relevance and return it
            }



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
    public ArrayList<Publication> parse(String author,int type){
        Parser p=new Parser();
        data = p.parse("dblp.xml",author,type);
        this.setQtype(type);
        this.setName(author);
        return data;
    }
}
