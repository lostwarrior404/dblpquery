import javax.swing.*;

public class GUI {
    public JFrame myframe;
    public JLabel titletop;
    public JPanel leftpane;
    public JPanel rightpane;
    
    
    public GUI(){
        myframe=new JFrame();
    }
    public void createGui(){//gets all the panels and panes and sets them accordingly
        titletop=createTitletop();
        leftpane=createLeftpane();
        rightpane=createRightpane();
    }
    public JPanel createLeftpane(){

    }
    public JPanel createRightpane(){

    }
    public JLabel createTitletop(){

    }

}
