import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saksham on 11/29/2016.
 */
public class GuiQuery2 {
    JPanel base=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JPanel centre;
    JTextField inputk=new JTextField(10);
    JPanel p5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTable table;
    Boolean flag=false;
    int position=0;
    JButton next=new JButton("Next");
    JPanel lol;
    ArrayList<String> auth;
    public void query2gui(JPanel westbottom,JPanel centr ){
        position=0;
        flag=false;
        next.addActionListener(new next());
        westbottom.removeAll();
        centre=centr;
        centre.removeAll();
        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("Enter value of K"));
        inputk.setEditable(true);
        p1.add(inputk);
        westbottom.add(p1);
        search.addActionListener(new submit());
        reset.addActionListener(new reset());
        p5.add(search);
        p5.add(reset);
        westbottom.add(p5);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }
    public void reset(){
        inputk.setText("");
        for (int i = 0; i < table.getRowCount(); i++)
            for(int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
    }
    public void runQuery(){
        Query2 q2=new Query2();
        int k=Integer.parseInt(inputk.getText());
        System.out.println(k+" "+inputk.getText());
        auth=q2.parse(k);
        System.out.println(auth);
        JLabel hey=new JLabel("No of results:"+Integer.toString(auth.size())+"         ");
        lol=new JPanel();
        lol.add(hey);
        lol.add(next);
        centre.setLayout(new BorderLayout());
        centre.add(lol,BorderLayout.NORTH);
        DefaultTableModel model = new DefaultTableModel();
        String[] dataArray=new String[20];
        int temp=auth.size()>20?20:auth.size();
        if(auth.size()>20){
            flag=true;
            position=20;
        }
        System.out.println(auth.size());
        for(int i=0;i<temp;i++){
            dataArray[i]=auth.get(i);
        }
        model.addColumn("Author Name",dataArray);
        table = new JTable(model);
        centre.add( new JScrollPane( table ), BorderLayout.CENTER );
        centre.revalidate();
        centre.repaint();
    }
    public void donext(){
        if(flag){
            String[] dataArray=new String[20];
            int start=position;
            int temp;
            if(position+19>=auth.size()-1){
                flag=false;
                temp=auth.size();
            }
            else{
                flag=true;
                position=position+20;
                temp=position;
            }
            int y=0;
            for(int i=start;i<temp;i++){
                dataArray[y]=auth.get(i);
                ++y;
            }
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Author Name",dataArray);
            centre.removeAll();
            centre.revalidate();
            centre.repaint();
            centre.add(lol);
            table = new JTable(model);
            centre.add( new JScrollPane( table ), BorderLayout.CENTER );
            centre.revalidate();
            centre.repaint();
        }
    }
    class reset implements ActionListener {
        public void actionPerformed(ActionEvent e){
            GuiQuery2.this.reset();
        }
    }
    class submit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            GuiQuery2.this.runQuery();
        }
    }

    class next implements ActionListener{
        public void actionPerformed(ActionEvent e){
            GuiQuery2.this.donext();
        }
    }



}
