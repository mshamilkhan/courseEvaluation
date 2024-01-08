package interfaces;
import javax.swing.*;
import java.awt.*;
public class editMajor{
    public static void editMajorUI(){
        JFrame editMajorframe = new JFrame();
        editMajorframe.setSize(1920, 1080);
        // editMajorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = editMajorframe.getContentPane();
       c.setLayout(null);
       editMajorframe.setTitle("Edit Major Instrument");


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

       JLabel weight = new JLabel("Instrument Weight");
        weight.setBounds(650, ycord+100, 500, 50);
        Font font = new Font("Arial", Font.PLAIN, 20);
        weight.setFont(font);
        c.add(weight);

        JTextField weightinput = new JTextField();
        weightinput.setBounds(650, ycord+150, 500, 50);
        c.add(weightinput);

       JButton next = new JButton("edit");
       next.setBounds(650, ycord+250, 200, 50);
       Color btnclr = new Color(17, 77, 146);
       next.setBackground(btnclr);
       next.setForeground(Color.WHITE);
       c.add(next);

       JButton cancel = new JButton("cancel");
       cancel.setBounds(950, ycord+250, 200, 50);
      
       c.add(cancel);


       editMajorframe.setVisible(true);


    }
}