package interfaces;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class viewMajor {
    public static void viewMajorUI(){
        JTable table;
        JFrame editMajorframe = new JFrame();
        editMajorframe.setSize(1920, 1080);
        // editMajorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = editMajorframe.getContentPane();
    //    c.setLayout(null);
      
       


Object[][] data = {
    {101, "Assignment" , 10} ,
    {102, "Quiz" , 15},
    {103, "Mid Term" , 25},
    {104, "Final" , 50}
};
String[] columnNames = {"Major id", "Major Name" , "Major Percentage"};

DefaultTableModel model = new DefaultTableModel(data, columnNames);
   table = new JTable(model);


    c.add(new JScrollPane(table));
    c.revalidate();
    c.repaint();
    
       editMajorframe.setVisible(true);
    }

   
}
