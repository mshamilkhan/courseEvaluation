package interfaces;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class viewMinor {
    public static void viewMinorUI(){
        JTable table;
        JFrame editMinorframe = new JFrame();
        editMinorframe.setSize(1920, 1080);
        // editMinorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = editMinorframe.getContentPane();
    //    c.setLayout(null);
      
       


Object[][] data = {
    {1001, "A1" , 30, "Assignment" , 101 } ,
    {1002, "A2" , 30, "Assignment" , 101},
    {1005, "A3" , 40, "Assignment" , 101},
    {1003, "MT1" , 50, "Mid Term" , 103},
    {1006, "MT2" , 50, "Mid Term" , 103},
    {1007, "Q1" , 30, "Quiz" , 102},
    {1008, "Q2" , 30, "Quiz" , 102},
    {1009, "Q3" , 30, "Quiz" , 102},
    {1004, "Final" , 100, "Final", 104}
};
String[] columnNames = {"Minor id", "Minor Name" , "Minor Percentage", "Major Name" , "Major id"};

DefaultTableModel model = new DefaultTableModel(data, columnNames);
   table = new JTable(model);


    c.add(new JScrollPane(table));
    c.revalidate();
    c.repaint();
    
       editMinorframe.setVisible(true);
    }

   
}
