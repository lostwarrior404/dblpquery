import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Saksham on 11/13/2016.
 */
public class Main {
    public static void main(String[] args){
        //Parser p=new Parser();
//        Scanner in =new Scanner(System.in);
//        String name=in.nextLine();
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
//        Query1 q = new Query1();
//        ArrayList<Publication> res=q.parse(name,1);
//        for(Publication pu: res){
//            System.out.println(pu);
//        }
//        res = q.sort(1);
//        for(Publication pu: res){
//            System.out.println(pu);
//        }
//        EntityResolutionParser e = new EntityResolutionParser();
//        HashSet<String> res = e.parse("dblp.xml",name);
//        for(String pr:res){
//            System.out.println(pr);
//        }

//      Query1 hey=new Query1();
        Query2 mainhoonpro=new Query2();
        ArrayList<String> a=mainhoonpro.parse("dblp.xml",1000);
        for(String i:a){
            System.out.println(i);
        }
    }
}