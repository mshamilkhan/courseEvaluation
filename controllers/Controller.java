package controllers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
    private JLabel weight;
    private JLabel name;
    private JLabel course;
    private JTextField weightinput;
    private JTextField nameinput;
    private JTextField courseinput;

    public Controller(JLabel weight, JLabel name, JLabel course, JTextField weightinput, JTextField nameinput, JTextField courseinput) {
        this.weight = weight;
        this.name = name;
        this.course = course;
        this.weightinput = weightinput;
        this.nameinput = nameinput;
        this.courseinput = courseinput;

    }

    public ActionListener getConfirmButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weightText = weightinput.getText();
                String nameText = nameinput.getText();
                String courseText = courseinput.getText();
                Font empty = new Font("Arial", Font.PLAIN, 20);

                if (weightText.isEmpty()) {
                    weight.setFont(empty);
                    weight.setForeground(Color.RED);
                } else if (nameText.isEmpty()) {
                    name.setFont(empty);
                    name.setForeground(Color.RED);
                } else if (courseText.isEmpty()) {
                    course.setFont(empty);
                    course.setForeground(Color.RED);
                }
                // Do something with the retrieved text
                System.out.println("Weight: " + weightText);
                System.out.println("Name: " + nameText);
                System.out.println("Course: " + courseText);
            }
        };
    }

    public static String[] getMinorParam(String minorNameText,String  minorMarksText,String  minorWeightText, String selectedMajorText){
    String[] minorParams = {minorNameText, minorMarksText, minorWeightText, selectedMajorText};
        return minorParams;
    }
        
    public static String[] getMajorParam(String majorNameText,String majorWeightText,String selectedMajorText){
    String[] majorParams = {majorNameText, majorWeightText, selectedMajorText};
        return majorParams;
    }


    


}
