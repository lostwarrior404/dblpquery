import java.util.ArrayList;

import static javax.swing.UIManager.get;

public class Query3 {

    ArrayList<String> names;
    public void setNames(ArrayList<String> temp){
        names=temp;
    }
    public ArrayList<Integer> predict(ArrayList<String> temp,int year){
        this.setNames(temp);
        //use 5 threads
        Query1 use=new Query1();
        for(String i:names){
            ArrayList<Publication> data=use.parse(i,1);
            use.setYear(0,year);
            data=use.sortit(4);//if year not there
            ArrayList<Integer> cummulative=new ArrayList<Integer>();

            for(Publication j:data){

            }
            for(int k=1;k<year+2;k++){
                cummulative[k]+=cummulative[k-1];
            }
            Prediction.predict(cummulative,year);

        }

    }
}
