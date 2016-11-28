import java.util.ArrayList;

/**
 * Created by Saksham on 11/28/2016.
 */
public class Prediction {

    public static int predict(ArrayList<Integer> cummulatives){


        double sumx, sumxsq, sumy, sumxy,a,b,denom;
        sumx = 0;
        sumxsq = 0;
        sumy = 0;
        sumxy = 0;
        int count=0;
        int n=cummulatives.size();
        for(Integer i : cummulatives)
        {
            sumx += count+1;
            sumxsq += (count+1)*(count+1);
            sumy += i;
            sumxy += i*(count+1);
            count++;
        }
        denom = n*sumxsq-(sumx*sumx);
        a = ((sumy*sumxsq)-(sumx*sumxy))/denom;
        b = (n*sumxy-sumx*sumy)/denom;
        return (int)((cummulatives.size()+1)*a+b-cummulatives.get(cummulatives.size()-1));//or ula see
    }

}
