 import java.awt.*;
 import java.io.BufferedReader;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.*;

 public class Query1 {
    ArrayList<Publication> data;
    int year,year1,year2;
    int qtype;
    String name;

     public void setYear(int year){
         this.year=year;
     }

     public void setYear(int year1,int year2 2){
         this.year1=year1;
         this.year2=year2;
     }

    public ArrayList<Publication> sortit(int subtype){
        Collections.sort(data, new Comparator<Publication>() {
            public int compare(Publication o1, Publication o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.reverse(data);
        if(subtype==1){
           return data;
        }
        if(subtype==2){
            //only for type 2 query
            Collections.sort(data, new Comparator<Publication>() {
                public int compare(Publication o1, Publication o2) {
                    return (o1.getSimilarity() < o2.getSimilarity() ? -1 :
                            (o1.getYear() == o2.getSimilarity() ? 0 : 1));
                }
            });
            return data;
        }
        if(subtype==3){
            ArrayList<Publication> temp=new ArrayList<Publication>();
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        if(subtype==4){
            ArrayList<Publication> temp=new ArrayList<Publication>();
            for(int i=0;i<data.size();i++){
                if(data.get(i).getYear()>=year1 && data.get(i).getYear()<=year2){
                    temp.add(data.get(i));
                }
            }
            return temp;
        }
        return data;
    }
    public void setQtype(int a){
        qtype=a;
    }

    public void setName(String a){
        name=a;
    }
    public void createGui(){
        System.out.println("q1");
    }
    public ArrayList<Publication> parse(String name,int type){
        Parser p=new Parser();
        ArrayList<String> author;
        if(type==1){
            author=entityResolve(name);
        }
        else{
            author=new ArrayList<String>();
            author.add(name);
        }
        //an arraylist named author if search by author else an arraylist with title at index 0
        data = p.parse("dblp.xml",author,type);//author is an array
        this.setQtype(type);
        this.setName(name);//can be name or title
        return data;
    }

    public ArrayList<String> entityResolve(String name){
        ArrayList<String> arguments=new ArrayList<String>();
        String location = "www.csv";//to add location
        BufferedReader br = null;
        String line;
        String cvs_split = ",";
        try {
            br = new BufferedReader(new FileReader(location));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            HashSet<String> toreturn=new HashSet<String>();
            while ((line = br.readLine()) != null) {
                ArrayList<String> argm = new ArrayList<String>(Arrays.asList( line.split(cvs_split)));
                Boolean flag=false;
                for(String i:argm){
                    if(i.equalsIgnoreCase(name)){
                        flag=true;
                    }
                }
                if(flag){
                    for(String i:argm){
                        toreturn.add(i);
                    }
                }
            }
            for(String i:toreturn){
                arguments.add(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arguments;
    }
}