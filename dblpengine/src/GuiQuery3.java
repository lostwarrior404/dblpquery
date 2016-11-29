import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saksham on 11/29/2016.
 */
public class GuiQuery3 {
    JTextField year=new JTextField(4);
    JTextField person1=new JTextField(15);
    JTextField person2=new JTextField(15);
    JTextField person3=new JTextField(15);
    JTextField person4=new JTextField(15);
    JTextField person5=new JTextField(15);

    JPanel base=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JTable table;
    JLabel hey;
    JPanel centre;
    public void query3gui(JPanel westbottom,JPanel centr){
        westbottom.removeAll();
        this.centre=centr;
        centre.removeAll();

        westbottom.setLayout(new BoxLayout(westbottom, BoxLayout.Y_AXIS));
        JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("  Year "));
        p1.add(year);
        JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("  Name1 "));
        p2.add(person1);
        JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("  Name2 "));
        p3.add(person2);
        JPanel p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(new JLabel("  Name3 "));
        p4.add(person3);
        JPanel p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(new JLabel("  Name4 "));
        p5.add(person4);
        JPanel p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6.add(new JLabel("  name5 "));
        p6.add(person5);
        westbottom.add(p2);
        westbottom.add(p3);
        westbottom.add(p4);
        westbottom.add(p5);
        westbottom.add(p6);
        westbottom.add(p1);
        search.addActionListener(new submit());
        reset.addActionListener(new reset());
        base.add(search);
        base.add(reset);
        westbottom.add(base);
        centre.repaint();
        centre.revalidate();
        westbottom.revalidate();
        westbottom.repaint();
    }
    //seteditable
    public void reset(){
        year.setText("");
        hey.setText("");
        person1.setText("");
        person2.setText("");
        person3.setText("");
        person4.setText("");
        person5.setText("");
        for (int i = 0; i < table.getRowCount(); i++)
            for(int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
    }
    public void runQuery(){
        if(!GuiQuery1.isNumeric(year.getText()) | year.getText().length()!=4){
            return;
        }
        centre.removeAll();
        Query3 q3=new Query3();
        int y=Integer.parseInt(year.getText());
        String data[][] = {{person1.getText(),Integer.toString(q3.predict(person1.getText(),y)),Integer.toString(q3.predict1(person1.getText(),y))},
                {person2.getText(),Integer.toString(q3.predict(person2.getText(),y)),Integer.toString(q3.predict1(person2.getText(),y))},
                {person3.getText(),Integer.toString(q3.predict(person3.getText(),y)),Integer.toString(q3.predict1(person3.getText(),y))},
                {person4.getText(),Integer.toString(q3.predict(person4.getText(),y)),Integer.toString(q3.predict1(person4.getText(),y))},
                {person5.getText(),Integer.toString(q3.predict(person5.getText(),y)),Integer.toString(q3.predict1(person5.getText(),y))}};
        String column[] = {"Author Name","Prediction Linear Regression","Prediction KNN"};
        table = new JTable(data, column);
        centre.setLayout(new BorderLayout());
        centre.add( new JScrollPane( table ), BorderLayout.CENTER );
        centre.revalidate();
        centre.revalidate();
    }
    class reset implements ActionListener{
        public void actionPerformed(ActionEvent e){
            GuiQuery3.this.reset();
        }
    }
    class submit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            GuiQuery3.this.runQuery();
        }
    }
}
