import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Saksham on 11/13/2016.
 */
public class Main {
    public static void main(String[] args){
        Parser p=new Parser();
        Scanner in =new Scanner(System.in);
        String name=in.nextLine();
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        ArrayList<Publication> res = p.parse("dblp.xml",name);
        for(Publication pu: res){
            System.out.println(p);
        }
//        Query1 hey=new Query1();
    }
}
