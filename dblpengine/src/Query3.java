import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static javax.swing.UIManager.get;

public class Query3 {

    public int predict(String author,int year){
        Query1 q1=new Query1();
        q1.parse(author,1);
        q1.setYear(0,year);
        ArrayList<Publication> publ = q1.sortit(4);
        Collections.reverse(publ);
        ArrayList<Publication> temp=new ArrayList<Publication>();

        int min_year = publ.get(0).getYear(),max_year = publ.get(publ.size()-1).getYear();
        HashMap<Integer,Integer> xy = new HashMap<Integer, Integer>();

        for(int i=min_year;i<=max_year;i++){
            xy.put(i-(min_year-1),0);
        }
        System.out.println(xy);
        for(Publication p:publ){
            xy.put(p.getYear()-(min_year-1),xy.get(p.getYear()-(min_year-1))+1);
        }
        double sum_y=0,sum_x=0,sum_x2=0,sum_y2=0,sum_xy=0;
        int n=0;
        for(Integer x : xy.keySet()){
            ++n;
            sum_x+=x;
            sum_x2+=(x*x);
            sum_xy+=(x*xy.get(x));
            sum_y+=xy.get(x);
            sum_y2+=(xy.get(x)*xy.get(x));
        }
        System.out.println(xy);
//        for(Integer y:xy.values()){
//            sum_y+=y;
//            sum_y2+=(y*y);
//        }
        double a,b,denominator;
        denominator=(n*sum_x2)-(sum_x*sum_x);
        b=((n*sum_xy)-(sum_x*sum_y))/denominator;
        a=((sum_y*sum_x2)-(sum_x*sum_xy))/denominator;
        int ans=(int)(a+b*(n+1));
        return ans;
    }
}
