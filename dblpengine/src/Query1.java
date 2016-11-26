import java.util.ArrayList;

public class Query1 {
    ArrayList<Publication> data;
    int type;
    public Query1(ArrayList<Publication> a,int k){
        this.data=a;
        type=k;
        sort();
    }
    public void sort(){
        if(type==1){
            sortreverseDate();
        }
    }
    public void sortreverseDate(){
        int i, key, j;
        Publication temp;
        for (i = 1; i < data.size(); i++)
        {
            key = Integer.parseInt(data.get(i).getYear());
            temp=data.get(i);
            j = i-1;
            while (j >= 0 && Integer.parseInt(data.get(j).getYear()) > key)
            {
                data.add(j+1,data.get(j));
               j = j-1;
            }
            data.add(j+1,temp);
        }
    }
    public void createGui(){
        System.out.println("q1");
    }

}
