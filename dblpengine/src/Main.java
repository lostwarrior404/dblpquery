

/**
 * Created by Saksham on 11/13/2016.
 */
public class Main {
    public static void main(String[] args){
        Parser p=new Parser();
        System.setProperty("jdk.xml.entityExpansionLimit", "0");
        p.parse("dblp.xml");
    }
}
