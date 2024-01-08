package interfaces;
import javax.swing.*;
import java.awt.*;
public class deleteMinor{
    public static void deleteMinorUI(){
        JFrame deleteMinorframe = new JFrame();
        deleteMinorframe.setSize(1920, 1080);
        // deleteMinorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = deleteMinorframe.getContentPane();
       c.setLayout(null);
       deleteMinorframe.setTitle("Delete Minor");


       //Inserting the Jlabel for selecting the major
              
       int ycord = 200;
       JLabel SelectMajor = new JLabel("Select Major");
       SelectMajor.setBounds(650, ycord, 500, 50);
       Font lablefont = new Font("Arial", Font.PLAIN, 20);
       SelectMajor.setForeground(Color.BLACK);
       SelectMajor.setFont(lablefont);
       c.add(SelectMajor);


       // Creating a String array for dropdown options
       String[] options = {"Quizzes", "Assignments", "Mid Terms", "Finals"};

       // Creating a JComboBox and adding options
       JComboBox<String> dropdown = new JComboBox<>(options);
       dropdown.setBounds(650, ycord+50, 500, 50);
       c.add(dropdown);

       JLabel MinorName = new JLabel("Select Minor");
       MinorName.setBounds(650, ycord+100, 500, 50);
       MinorName.setForeground(Color.BLACK);
       MinorName.setFont(lablefont);
       c.add(MinorName);
       String[] optionsMinor = {"1010", "1011", "1012", "1013"};

       // Creating a JComboBox and adding options
       JComboBox<String> dropdownMinor = new JComboBox<>(optionsMinor);
       dropdownMinor.setBounds(650, ycord+150, 500, 50);
       c.add(dropdownMinor);

       JButton next = new JButton("delete");
       next.setBounds(650, ycord+250, 200, 50);
       Color btnclr = new Color(17, 77, 146);
       next.setBackground(btnclr);
       next.setForeground(Color.WHITE);
       c.add(next);

       JButton cancel = new JButton("cancel");
       cancel.setBounds(950, ycord+250, 200, 50);
      
       c.add(cancel);
       deleteMinorframe.setVisible(true);
    }
}