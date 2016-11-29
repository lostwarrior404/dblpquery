import javax.swing.*;
import java.awt.*;

/**
 * Created by Saksham on 11/28/2016.
 */
public class GuiQuery1 {

    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JComboBox list2;
    JLabel nametitle=new JLabel("Name/Title Tags");
    JTextField nametitleinput=new JTextField(10);//increase field length
    JTextField sinceyearinput=new JTextField(4);
    JTextField year1input=new JTextField(4);
    JTextField year2input=new JTextField(4);
    JPanel p5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JRadioButton sortbydate;
    JRadioButton sortbyrelevance;
    JRadioButton sincegivenyear;
    JRadioButton bwtwoyears;
    JTable table;
    int pos=0;
    public void makegroup(){
        sortbydate = new JRadioButton("Sort by date");
        sortbyrelevance = new JRadioButton("Sort by relevance");
        sincegivenyear = new JRadioButton("Since given year");
        bwtwoyears = new JRadioButton("Between given years");
        ButtonGroup group = new ButtonGroup();
        group.add(sortbydate);
        group.add(sortbyrelevance);
        group.add(sincegivenyear);
        group.add(bwtwoyears);
    }
    public JTable createTable() {
        String data[][] = {{"101", "Amit", "670000","","",""},
                {"102", "Jai", "780000","","",""},
                {"101", "Sachin", "700000","","",""}};
        String column[] = {"ID", "NAME", "SALARY","Word","Norm","Cool"};
        JTable jt = new JTable(data, column);
        return jt;
    }


    public void query1gui(JPanel westbottom,JPanel centre){//set a flag for which type of query is happening
        westbottom.removeAll();
        centre.removeAll();
        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        list2=createList2();
        list2.setPreferredSize(new Dimension(100,25));
        westbottom.add(list2);
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(nametitle);
        nametitleinput.setEditable(true);
        p1.add(nametitleinput);
        westbottom.add(p1);
        JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("Since Year"));
        sinceyearinput.setEditable(true);
        p2.add(sinceyearinput);
        westbottom.add(p2);
        JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("Range of Years"));
        year1input.setEditable(true);
        year2input.setEditable(true);
        p3.add(year2input);
        p3.add(new JLabel("-"));
        p3.add(year2input);
        westbottom.add(p3);
        this.makegroup();
        JPanel p4=new JPanel();
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        JPanel a=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel b=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel c=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel d=new JPanel(new FlowLayout(FlowLayout.LEFT));
        a.add(sortbydate);
        b.add(sortbyrelevance);
        c.add(sincegivenyear);
        d.add(bwtwoyears);
        p4.add(a);
        p4.add(b);
        p4.add(c);
        p4.add(d);
        westbottom.add(p4);
        p5.add(search);
        p5.add(reset);
        table=createTable();
        JPanel p6=new JPanel();
        p6.add(table);
        westbottom.add(p5);
        centre.add(p6);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }
    public JComboBox createList2(){
        JComboBox comboBox=new JComboBox();
        comboBox.setEditable(true);
        comboBox.addItem("Search By");
        comboBox.addItem("Author");
        comboBox.addItem("Title");
        comboBox.setEditable(false);
        return comboBox;
    }

}
