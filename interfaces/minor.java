package interfaces;
import javax.swing.*;

import controllers.Controller;
import domainLayer.validation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class minor{
    static JFrame minor;
    public static void minorinterface(){
        
        
        minor = new JFrame();
        minor.setSize(1920,1080);
        // minor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = minor.getContentPane();
        c.setLayout(null);
        minor.setTitle("Define Minor");


        int ycord = 200;
        JLabel MinorName = new JLabel("Minor Name");
        MinorName.setBounds(650, ycord, 500, 50);
        Font lablefont = new Font("Arial", Font.PLAIN, 20);
        MinorName.setForeground(Color.BLACK);
        MinorName.setFont(lablefont);
        c.add(MinorName);

        JTextField MinorNameInput = new JTextField();
        MinorNameInput.setBounds(650, ycord+50, 500, 50);
        c.add(MinorNameInput);
        
        JLabel MinorMarks = new JLabel("Minor Marks");
        MinorMarks.setBounds(650, ycord+100, 500, 50);
        MinorName.setForeground(Color.BLACK);
        MinorMarks.setFont(lablefont);
        c.add(MinorMarks);

        JTextField MinorMarksInput = new JTextField();
        MinorMarksInput.setBounds(650, ycord+150, 500, 50);
        c.add(MinorMarksInput);
        JLabel MinorWeight = new JLabel("Minor Weightage");
        MinorWeight.setBounds(650, ycord+200, 500, 50);
        MinorWeight.setForeground(Color.BLACK);
        MinorWeight.setFont(lablefont);
        c.add(MinorWeight);

        JTextField MinorWeightInput = new JTextField();
        MinorWeightInput.setBounds(650, ycord+250, 500, 50);
        c.add(MinorWeightInput);
        
        JLabel SelectMajor = new JLabel("Select Major Instrument");
        SelectMajor.setBounds(650, ycord+300, 500, 50);
    SelectMajor.setForeground(Color.BLACK);
        SelectMajor.setFont(lablefont);
        c.add(SelectMajor);


         // Creating a String array for dropdown options
         String[] options = {"Quizzes", "Assignments", "Mid Terms", "Finals"};

         // Creating a JComboBox and adding options
         JComboBox<String> dropdown = new JComboBox<>(options);
         dropdown.setBounds(650, ycord+350, 500, 50);
         c.add(dropdown);
       
         JButton saveminor = new JButton("save");
         saveminor.setBounds(650, ycord+450, 200, 50);
         Color btnclr = new Color(17, 77, 146);
         saveminor.setBackground(btnclr);
         saveminor.setForeground(Color.WHITE);
         c.add(saveminor);

         JButton backminor = new JButton("back");
         backminor.setBounds(950, ycord+450, 200, 50);
        
         c.add(backminor);
        

         saveminor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve text from JTextField components
                String minorNameText = MinorNameInput.getText();
                String minorMarksText = MinorMarksInput.getText();
                String minorWeightText = MinorWeightInput.getText();
                String selectedMajorText = (String) dropdown.getSelectedItem();
                //  validation.minorinfoprocess(minorNameText, minorMarksText, minorWeightText, selectedMajorText);
             String[] minorParams=  Controller.getMinorParam(minorNameText, minorMarksText, minorWeightText, selectedMajorText);
                validation.minorinfoprocess(minorParams[0],minorParams[1],minorParams[2],minorParams[3]);
            }
        });
        //  backminor.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
                
        // });

        minor.setVisible(true);
    }
    
    public static void emptyalertUI(){
        JFrame alertframe = new JFrame();
        alertframe.setBounds(750, 350, 300, 150);
        Container c = alertframe.getContentPane();
        JPanel panel = new JPanel(new GridBagLayout());

        c.add(panel); 
        JLabel alert = new JLabel("All fields must be filled");

        GridBagLayout g = new GridBagLayout();
        c.setLayout(g);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(alert,gbc);



        alertframe.setVisible(true);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(minor, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

  
    public void showSuccessMessage(String message) {
        
        JOptionPane.showMessageDialog(minor, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    
}
