import javax.swing.*;

public class GUI {
    public JFrame myframe;
    public JLabel titletop;
    public JPanel leftpane;
    public JPanel rightpane;
    
    
    public GUI(){
        myframe=new JFrame();
        createGui();
    }
    public void createGui(){//gets all the panels and panes and sets them accordingly
        titletop=createTitletop();
        leftpane=createLeftpane();
        rightpane=createRightpane();
        myframe.setLayout(new FlowLayout());
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
