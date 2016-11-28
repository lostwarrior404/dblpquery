import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
/**
 * Created by Saksham on 11/27/2016.
 */
public class Gui {
    JFrame mainframe=new JFrame();
    JPanel top=new JPanel();
    JPanel centrebig=new JPanel();
    JPanel west=new JPanel();
    JPanel centre=new JPanel();
    JPanel westtop=new JPanel();
    JPanel westbottom=new JPanel();
    JPanel q1=new JPanel();//to be added to west bottom and setvisibility
    JPanel q2=new JPanel();
    JPanel q3=new JPanel();
    JLabel nametitle=new JLabel("Name/Title Tags");
    JTextField nametitleinput=new JTextField(10);//increase field length
    JTextField sinceyearinput=new JTextField(4);
    JTextField year1input=new JTextField(4);
    JTextField year2input=new JTextField(4);
    JTextField q3input=new JTextField(4);

    JTextField inputk=new JTextField(10);
    JComboBox list2;
    //reset clears all fields for that query
    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JRadioButton sortbydate;
    JRadioButton sortbyrelevance;
    JRadioButton sincegivenyear;
    JRadioButton bwtwoyears;
    ButtonGroup grp;
    JPanel p5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTable table;


    public Gui(){
        createGui();
    }
    public void createGui(){
        reset.setBackground(Color.RED);
        p5.add(search);
        p5.add(reset);
        JLabel jlabel = new JLabel("DBLP Query Engine");
        jlabel.setFont(new Font("Verdana",1,40));
        top.add(jlabel);
        mainframe.setSize(new Dimension(800,650));//600
        top.setBorder(new EmptyBorder(16, 16, 16, 16));
        mainframe.add(top,BorderLayout.NORTH);
        centrebig.setLayout(new BorderLayout());
        centrebig.setBorder(new EmptyBorder(16, 16, 16, 16));
        mainframe.add(centrebig,BorderLayout.CENTER);
        centrebig.add(west,BorderLayout.WEST);
        centrebig.add(centre,BorderLayout.CENTER);
        west.setPreferredSize(new Dimension(250,400));
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        JComboBox qtype=createList1();
        qtype.setBorder(new EmptyBorder(16, 16, 16, 16));
        westtop.add(qtype);
        west.setBorder(BorderFactory.createLineBorder(Color.blue));
        centre.setBorder(BorderFactory.createLineBorder(Color.blue));
        west.add(westtop);
        west.add(westbottom);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);

    }

    public JComboBox createList1(){
        JComboBox comboBox=new JComboBox();
        comboBox.setEditable(true);
        comboBox.addActionListener(new listQuerytype());
        comboBox.addItem("Choose any 1");
        comboBox.addItem("Query 1");
        comboBox.addItem("Query 2");
        comboBox.addItem("Query 3");
        comboBox.setEditable(false);
        return comboBox;
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

    public void query1gui(){//set a flag for which type of query is happening
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

        westbottom.add(p5);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
        mainframe.setVisible(true);
    }

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

    public void query2gui(){
        westbottom.removeAll();
        centre.removeAll();
        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("Enter value of K"));
        inputk.setEditable(true);
        p1.add(inputk);
        westbottom.add(p1);
        westbottom.add(p5);
        table=createTable();
        JPanel p6=new JPanel();
        p6.add(table);
        centre.add(p6);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }

    public void query3gui(){
        centre.removeAll();
        westbottom.removeAll();
        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("  Year "));
        q3input.setEditable(true);
        p1.add(q3input);
        westbottom.add(p1);
        westbottom.add(p5);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }

    public static void main(String[] args){
        Gui lol=new Gui();
    }

    class listQuerytype implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JComboBox temp = (JComboBox) e.getSource();
            Object selected = temp.getSelectedItem();
            if(selected.toString().equals("Choose any 1")){
                //lol
            }
            else if(selected.toString().equals("Query 1")){
                Gui.this.query1gui();
            }
            else if(selected.toString().equals("Query 2")){
                //Query2 q2=new Query2();
                Gui.this.query2gui();
            }
            else if(selected.toString().equals("Query 3")){
                //Query3 q3=new Query3();
                Gui.this.query3gui();
            }
        }
    }


    public JTable createTable() {
        String data[][] = {{"101", "Amit", "670000","","",""},
                {"102", "Jai", "780000","","",""},
                {"101", "Sachin", "700000","","",""}};
        String column[] = {"ID", "NAME", "SALARY","Word","Norm","Cool"};

        JTable jt = new JTable(data, column);
        return jt;
    }
}