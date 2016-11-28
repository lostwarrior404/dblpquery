import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Query2 {
    ArrayList<String> parse(int k){
        HashMap<String,Integer> hash= new Kparser().parse("dblp.xml");
        ArrayList<String> result = new ArrayList<String>();
        String location = "wwww.csv";//to add location
        BufferedReader br = null;
        String line;
        String cvs_split = ",";
        try {
            br = new BufferedReader(new FileReader(location));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((line = br.readLine()) != null) {
                ArrayList<String> argm = new ArrayList<String>(Arrays.asList(line.split(cvs_split)));
                int sum=0;
                for(String s:argm){
                    if(hash.containsKey(s)){
                        sum+=hash.remove(s);
                    }
                }
                if(sum>=k){
                    result.add(argm.get(0));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
