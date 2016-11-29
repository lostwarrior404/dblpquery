import javax.swing.*;
import java.awt.*;

/**
 * Created by Saksham on 11/29/2016.
 */
public class GuiQuery2 {

    JTextField inputk=new JTextField(10);
    JPanel p5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JTable table;
    public void query2gui(JPanel westbottom,JPanel centre ){
        westbottom.removeAll();
        centre.removeAll();
        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("Enter value of K"));
        inputk.setEditable(true);
        p1.add(inputk);
        westbottom.add(p1);
        p5.add(search);
        p5.add(reset);
        westbottom.add(p5);
//        JPanel p6=new JPanel();
//        p6.add(table);
       // centre.add(p6);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }
}
