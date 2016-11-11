import javax.swing.*;

public class GUI {
    public JFrame myframe;
    public JLabel titletop;
    public JPanel leftpane;
    public JPanel rightpane;
    Line2D horizontalLine; // Declare your variables here, but don't initialize them
    Line2D verticalLine;
    
    
    public GUI(){
        myframe=new JFrame();
        createGui();
    }
    public void createGui(){//gets all the panels and panes and sets them accordingly
        titletop=createTitletop();
        leftpane=createLeftpane();
        rightpane=createRightpane();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(1000,1000);
        myframe.setLayout(new FlowLayout());
        //myframe.add(Box.createRigidArea(new Dimension(285,100)));
        titletop.setAlignmentX(Component.CENTER_ALIGNMENT);
        myframe.add(titletop);
        myframe.add(Box.createRigidArea(new Dimension(100,100)));
        myframe.add(leftpane);
        myframe.add(rightpane);
        myframe.setVisible(true);
    }
    public JPanel createLeftpane(){
         
    }
    public JPanel createRightpane(){

    }
    public JLabel createTitletop(){
        JLabel temp=new JLabel;
        temp.setText("DBLP Query Engine");
        temp.setFont(new Font("Arial", Font.PLAIN, 14));
        return temp;
    }

}
