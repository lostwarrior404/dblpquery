import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;



//type is for 1,2,3,4 type not by title and author
public class Query1 {
    ArrayList<Publication> data;
    int year1,year2;

    public ArrayList<Publication> sort(int type){
        Collections.sort(data);
        ArrayList<Publication> temp=new ArrayList<Publication>();
        if(type==1){
            return data;
        }
        else if(type==2){
            //us entity resolution
        }
        else if(type==3){
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year1){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        else if(type==4){
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year1 && data.get(i).getYear()<=year2){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        return temp;
    }

    //    public void createGui(){
//        System.out.println("q1");
//    }
    public ArrayList<Publication> parse(String author){
        Parser p=new Parser();
        data = p.parse("dblp.xml",author);
        return data;
    }


    //public int sortbyrelevance
}
