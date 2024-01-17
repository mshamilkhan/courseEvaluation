package interfaces;
import javax.swing.*;

import controllers.Controller;
import domainLayer.major;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MajWeightUI {
    static JFrame frame;
    public static void createUI() {
         frame = new JFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Define Instruments");
        frame.setBackground(Color.BLACK);
        frame.setSize(1920, 1080);
        Container c = frame.getContentPane();
        frame.setTitle("Define Major Instrument");

        c.setLayout(null);
        // Managing the panels
       
        JLabel weight = new JLabel("Major Weight");
        weight.setBounds(650, 350, 500, 50);
        Font font = new Font("Arial", Font.PLAIN, 20);
        weight.setFont(font);
        c.add(weight);

        JTextField majorWeight = new JTextField();
        majorWeight.setBounds(650, 400, 500, 50);
        c.add(majorWeight);

        JLabel majorName = new JLabel("Major Name");
        majorName.setBounds(650, 450, 500, 50);
        majorName.setFont(font);
        c.add(majorName);

        JTextField nameinput = new JTextField();
        nameinput.setBounds(650, 500, 500, 50);
        c.add(nameinput);

        JLabel course = new JLabel("Course Code");
        course.setBounds(650, 550, 500, 50);
        course.setFont(font);
        c.add(course);

        // Creating a String array for dropdown options
        String[] options = {"101", "102", "103", "104"};

        // Creating a JComboBox and adding options
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(650, 600, 500, 50);
        c.add(dropdown);

       

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(650, 700, 200, 50);
        c.add(confirm);
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(950, 700, 200, 50);
        c.add(cancel);


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve text from JTextField components
                String majorWeightText = majorWeight.getText();
                String majorNameText = nameinput.getText();
                // String majorWeightText = majorWeight.getText();
                String selectedMajorText = (String) dropdown.getSelectedItem();
                String[] majorParams=  Controller.getMajorParam(majorNameText, majorWeightText, selectedMajorText);
                System.out.println(selectedMajorText);
                major.majorinfoprocess(majorParams[0],majorParams[1],majorParams[2]);

            }
        });
         cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        //------------------------------------------------------------------------------------



        //------------------------------------------------------------------------------------
        frame.setVisible(true);
    }

    
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

  
    public void showSuccessMessage(String message) {
        
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
