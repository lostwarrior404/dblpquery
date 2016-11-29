import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saksham on 11/28/2016.
 */
public class GuiQuery1 {
    String[][] all;
    JButton reset=new JButton("Reset");
    JButton search=new JButton("Submit");
    JComboBox list2;
    int position=0;
    Boolean flag;
    JButton next=new JButton("Next");
    JLabel nametitle=new JLabel("Name/Title Tags");
    JTextField nametitleinput=new JTextField(10);//increase field length
    JTextField sinceyearinput=new JTextField(4);
    JLabel hey;
    JTextField year1input=new JTextField(4);
    JTextField year2input=new JTextField(4);
    JPanel p5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JRadioButton sortbydate,sortbyrelevance,sincegivenyear,bwtwoyears;
    JTable table;
    int pos=0,qtype;
    JPanel centre,lol;
    ArrayList<Publication> data;
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
    public void rese(){
        nametitleinput.setText("");
        hey.setText("");
        year1input.setText("");
        year2input.setText("");
        sinceyearinput.setText("");
        for (int i = 0; i < table.getRowCount(); i++)
            for(int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
    }

    public void query1gui(JPanel westbottom,JPanel centr){//set a flag for which type of query is happening
        westbottom.removeAll();
        centre=centr;
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
        p3.add(year1input);
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
    public JComboBox createList2(){
        JComboBox comboBox=new JComboBox();
        comboBox.setEditable(true);
        comboBox.addItem("Search By");
        comboBox.addItem("Author");
        comboBox.addItem("Title");
        comboBox.setEditable(false);
        comboBox.addActionListener(new listype2());
        return comboBox;
    }
    public void setQtype(int a){
        qtype=a;
        if(a==1){
            sortbyrelevance.setEnabled(false);
        }
    }
    class listype2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JComboBox temp = (JComboBox) e.getSource();
            Object selected = temp.getSelectedItem();
            if(selected.toString().equals("Author")){
                GuiQuery1.this.setQtype(1);
            }
            else if(selected.toString().equals("Title")){
                //Query2 q2=new Query2();
                GuiQuery1.this.setQtype(2);
            }
        }
    }
    public void sub(){
        flag=false;
        Query1 q1=new Query1();
        q1.parse(nametitle.getText(),qtype);
        data=new ArrayList<Publication>();
        if(sortbydate.isSelected()){
            data=q1.sortit(1);
        }
        else if(sortbyrelevance.isSelected()&& qtype!=1){
            data=q1.sortit(2);
        }
        else if(sincegivenyear.isSelected()){
            q1.setYear(Integer.parseInt(sinceyearinput.getText()));
            data=q1.sortit(3);
        }
        else if(bwtwoyears.isSelected()){
            q1.setYear(Integer.parseInt(year1input.getText()),Integer.parseInt(year2input.getText()));
            data=q1.sortit(4);
        }
        hey=new JLabel("No of results:"+Integer.toString(data.size())+"         ");
        lol=new JPanel();
        lol.add(hey);
        next.addActionListener(new nex());
        lol.add(next);
        centre.setLayout(new BorderLayout());
        centre.add(lol,BorderLayout.NORTH);
        all=Dataconverter.convert(data);
        String[][] dataArray=new String[20][8];
        int temp=data.size()>20?20:data.size();
        if(data.size()>20){
            flag=true;
            position=20;
        }
        for(int i=0;i<temp;i++){
            dataArray[i]=all[i];//check this
        }
        String[] column={"S no.","Authors","Title","Pages","Year","Volume","Journal/Booktitle","URL"};//check
        table = new JTable(dataArray,column);
        centre.add( new JScrollPane( table ), BorderLayout.CENTER );
        centre.revalidate();
        centre.repaint();
    }
    public void donext(){
        if(flag){
            String[] dataArray=new String[20];
            int start=position;
            int temp;
            if(position+19>=data.size()-1){
                flag=false;
                temp=data.size();
            }
            else{
                flag=true;
                position=position+20;
                temp=position;
            }
            int y=0;
            for(int i=start;i<temp;i++){
                //dataArray[y]=data.get(i);
                ++y;
            }
            DefaultTableModel model1 = new DefaultTableModel();
            model1.addColumn("Author Name",dataArray);
            centre.removeAll();
            centre.add(lol,BorderLayout.NORTH);
            //centre.add(Box.createRigidArea(new Dimension(122,123)));
            table = new JTable(model1);
            centre.add( new JScrollPane( table ), BorderLayout.CENTER );
            model1.fireTableDataChanged();
            centre.revalidate();
            centre.repaint();
            centre.setVisible(true);
        }
    }
    class reset implements ActionListener{
        public void actionPerformed(ActionEvent e){GuiQuery1.this.rese();}}
    class submit implements ActionListener{
        public void actionPerformed(ActionEvent e){GuiQuery1.this.sub();}}
    class nex implements ActionListener{
        public void actionPerformed(ActionEvent e){GuiQuery1.this.donext();}}
}
