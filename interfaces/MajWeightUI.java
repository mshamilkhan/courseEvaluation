package interfaces;
import javax.swing.*;

import controllers.Controller;

import java.awt.*;

public class MajWeightUI {
    public static void createUI() {
        JFrame frame = new JFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Define Instruments");
        frame.setBackground(Color.BLACK);
        frame.setSize(1920, 1080);
        Container c = frame.getContentPane();
        frame.setTitle("Define Major Instrument");

        c.setLayout(null);
        // Managing the panels
       
        JLabel weight = new JLabel("Instrument Weight");
        weight.setBounds(650, 350, 500, 50);
        Font font = new Font("Arial", Font.PLAIN, 20);
        weight.setFont(font);
        c.add(weight);

        JTextField weightinput = new JTextField();
        weightinput.setBounds(650, 400, 500, 50);
        c.add(weightinput);

        JLabel name = new JLabel("Instrument Name");
        name.setBounds(650, 450, 500, 50);
        name.setFont(font);
        c.add(name);

        JTextField nameinput = new JTextField();
        nameinput.setBounds(650, 500, 500, 50);
        c.add(nameinput);

        JLabel course = new JLabel("Course Code");
        course.setBounds(650, 550, 500, 50);
        course.setFont(font);
        c.add(course);

        JTextField courseinput = new JTextField();
        courseinput.setBounds(650, 600, 500, 50);
        c.add(courseinput);

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(650, 700, 200, 50);
        c.add(confirm);
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(950, 700, 200, 50);
        c.add(cancel);
//------------------------------------------------------------------------------------

// Create an instance of the controller and pass components to handle interactions
Controller controller = new Controller(weight, name, course, weightinput, nameinput, courseinput);
confirm.addActionListener(controller.getConfirmButtonListener());

//------------------------------------------------------------------------------------
        frame.setVisible(true);
    }
}
