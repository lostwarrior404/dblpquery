//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.geom.*;
//
///**
// * Created by Saksham on 11/8/2016.
// */
//public class GUI {
//    public JFrame myframe;
//    public JLabel titletop;
//    public JPanel leftpane;
//    public JPanel rightpane;
//    public JComboBox qtype;
//    public JPanel mainpanel;
//    public GUI(){
//        myframe=new JFrame();
//        mainpanel=new JPanel();
//    }
//    public void createGui(){//gets all the panels and panes and sets them accordingly
//        titletop=createTitletop();
//        leftpane=createLeftpane();
//        rightpane=createRightpane();
//        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myframe.setLayout(new BoxLayout(myframe.getContentPane(), BoxLayout.Y_AXIS));
//        myframe.add(titletop);
//        titletop.setAlignmentX(Component.CENTER_ALIGNMENT);
//        myframe.getContentPane().add(Box.createRigidArea(new Dimension(100,100)));
//        mainpanel.setLayout(new FlowLayout());
//        leftpane.setPreferredSize(new Dimension(150,200));
//        mainpanel.add(leftpane);
//        rightpane.setPreferredSize(new Dimension(800,500));
//        mainpanel.add(rightpane);
//        myframe.add(mainpanel);
//        myframe.setVisible(true);
//    }
//    public JPanel createLeftpane(){
//        JPanel temp=new JPanel();
//        qtype = createList1();
//        temp.add(qtype);
//        return temp;
//    }
//
//    public JComboBox createList1(){
//        JComboBox comboBox=new JComboBox();
//        comboBox.setEditable(true);
//        comboBox.addActionListener(new listQuerytype());
//        comboBox.addItem("Choose any 1");
//        comboBox.addItem("Query 1");
//        comboBox.addItem("Query 2");
//        comboBox.addItem("Query 3");
//        comboBox.setEditable(false);
//        return comboBox;
//    }
//    public JPanel createRightpane(){
//    	JPanel temp=new JPanel();
//        temp.add(new JTextArea("Result will be displayed here"));
//        temp.setBorder(BorderFactory.createLineBorder(Color.black));
//        return temp;
//    }
//    public JLabel createTitletop(){
//        JLabel temp=new JLabel();
//        temp.setText("DBLP Query Engine");
//        temp.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
//        return temp;
//    }
//    public static void main(String[] args){
//        GUI kk=new GUI();
//        kk.createGui();
//    }
//}
//
//class listQuerytype implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            JComboBox temp = (JComboBox) e.getSource();
//            Object selected = temp.getSelectedItem();
//            if(selected.toString().equals("Choose any 1")){
//             //lol
//            }
//            else if(selected.toString().equals("Query 1")){
//                Query1 q1=new Query1();
//                q1.createGui();
//            }
//            else if(selected.toString().equals("Query 2")){
//                Query2 q2=new Query2();
//                q2.createGui();
//            }
//            else if(selected.toString().equals("Query 3")){
//                Query3 q3=new Query3();
//                q3.createGui();
//            }
//        }
//}
