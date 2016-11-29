import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static javax.swing.UIManager.get;
/*! \class Query3
 * \brief Handles the Query3 requests.
 *
 * This class handles query 3 requests
 * by using prediction mechanisms and query1 to
 * return predictions.
 */
public class Query3 {
    ArrayList<Publication> publ;
    //! Linear Regression for query 3
    /*!
     * The predict function uses parsed dblp.xml searching for author name
     * and predicts its next year's publication using linear regression.It basically
     * generates an HashSet for each author x and y
     * \param name author name
     * \param year to suggest year
     * \return int Prediction for next year
     */
    public int predict(String author,int year){
        Query1 q1=new Query1();
        q1.parse(author,1);
        q1.setYear(0,year);
        publ = q1.sortit(4);
        Collections.reverse(publ);
        ArrayList<Publication> temp=new ArrayList<Publication>();
        if(publ.size()==0){
            return 0;
        }
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

        double a,b,denominator;
        denominator=(n*sum_x2)-(sum_x*sum_x);
        b=((n*sum_xy)-(sum_x*sum_y))/denominator;
        a=((sum_y*sum_x2)-(sum_x*sum_xy))/denominator;
        int ans=(int)(a+b*(n+1));
        return ans;
    }
    //! KNN Regression for query 3
    /*!
     * The predict function uses parsed dblp.xml searching for author name
     * and predicts its next year's publication using KNN regression
     * The value of K is set to 5 but can be changed using additional parameter
     * \param name author name
     * \param year to suggest year
     * \return int Prediction for next year
     */
    public int predict1(String author,int year){
//        Query1 q1=new Query1();
//        q1.parse(author,1);
//        q1.setYear(0,year);
//        ArrayList<Publication> publ = q1.sortit(4);
//        Collections.reverse(publ);
        ArrayList<Publication> temp=new ArrayList<Publication>();
        if(publ.size()==0){
            return 0;
        }
        int min_year = publ.get(0).getYear(),max_year = publ.get(publ.size()-1).getYear();
        HashMap<Integer,Integer> xy = new HashMap<Integer, Integer>();

        for(int i=min_year;i<=max_year;i++){
            xy.put(i-(min_year-1),0);
        }
        System.out.println(xy);
        for(Publication p:publ){
            xy.put(p.getYear()-(min_year-1),xy.get(p.getYear()-(min_year-1))+1);
        }
        if(xy.keySet().size()>5){
            HashMap<Integer,Integer> temp1 = new HashMap<Integer, Integer>();
            for (int i = 4; i >=0 ; i--) {
                temp1.put(i+1,xy.get(max_year-(min_year-1)-(4-i)));
            }
            xy=temp1;
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
        double a,b,denominator;
        denominator=(n*sum_x2)-(sum_x*sum_x);
        b=((n*sum_xy)-(sum_x*sum_y))/denominator;
        a=((sum_y*sum_x2)-(sum_x*sum_xy))/denominator;
        int ans=(int)(a+b*(n+1));
        return ans;
    }
}
