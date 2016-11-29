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
    public void createGui(){
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

    class listQuerytype implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JComboBox temp = (JComboBox) e.getSource();
            Object selected = temp.getSelectedItem();
            if(selected.toString().equals("Query 1")){
                GuiQuery1 q1=new GuiQuery1();
                q1.query1gui(westbottom,centre);
            }
            else if(selected.toString().equals("Query 2")){
                GuiQuery2 q2=new GuiQuery2();
                q2.query2gui(westbottom,centre);
            }
            else if(selected.toString().equals("Query 3")){
                GuiQuery3 q3=new GuiQuery3();
                q3.query3gui(westbottom,centre);
            }
        }
    }
    public static void main(String[] args){
        Gui hello=new Gui();
        hello.createGui();
    }
}





