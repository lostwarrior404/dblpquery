import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tushar Kataria on 29-Nov-16.
 */
public class Dataconverter {
    private Dataconverter(){}
    static String [][]  convert(ArrayList<Publication> auth){
        String [][] res = new String[auth.size()][8];
        for (int i = 0; i <auth.size() ; i++) {
            String [] temp=new String[8];
            System.arraycopy(auth.get(i).toArray(),0,temp,1,7);
            temp[0]=Integer.toString(i+1);
            res[i]=temp;
        }
        return res;
    }
}
