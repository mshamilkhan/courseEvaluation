package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dashboard {
    static JFrame dashboard;
    public static void dashboardUI(){
        dashboard = new JFrame();
        dashboard.setSize(1920,1080);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = dashboard.getContentPane();
        c.setLayout(null);
        dashboard.setTitle("Define dashboard");

int ycord = 200;
int x = 600;
int w = 300;
int h = 50;
JButton Login = new JButton("Login Instructor");
Login.setBounds(x, ycord, w*2+100, h);
Color btnclr = new Color(17, 77, 146);
Color btnAdvance = new Color(0, 138, 0);
         Login.setBackground(btnAdvance);
         Login.setForeground(Color.WHITE);
         c.add(Login);

        JButton defineMajor = new JButton("Define Major");
         defineMajor.setBounds(x, ycord+100, w, h);
         defineMajor.setBackground(btnclr);
         defineMajor.setForeground(Color.WHITE);
         c.add(defineMajor);

        JButton defineMinor = new JButton("Define Minor");
         defineMinor.setBounds(x, ycord+200, w, h);
         defineMinor.setBackground(btnclr);
         defineMinor.setForeground(Color.WHITE);
         c.add(defineMinor);

      

        JButton editMajors = new JButton("Edit Major");
         editMajors.setBounds(x, ycord+150, w-150, h-20);
         editMajors.setBackground(btnAdvance);
         editMajors.setForeground(Color.WHITE);
         c.add(editMajors);
        JButton deleteMajors = new JButton("delete Major");
         deleteMajors.setBounds(x+150, ycord+150, w-150, h-20);
         Color btnRed = new Color(204, 0, 0);
         deleteMajors.setBackground(btnRed);
         deleteMajors.setForeground(Color.WHITE);
         c.add(deleteMajors);
         
         JButton editMinors = new JButton("Edit Minor");
          editMinors.setBounds(x, ycord+250, w-150, h-20);
          editMinors.setBackground(btnAdvance);
          editMinors.setForeground(Color.WHITE);
          c.add(editMinors);
         JButton deleteMinors = new JButton("delete Minor");
          deleteMinors.setBounds(x+150, ycord+250, w-150, h-20);        
          deleteMinors.setBackground(btnRed);
          deleteMinors.setForeground(Color.WHITE);
          c.add(deleteMinors);


JButton enterMarks = new JButton("Enter Marks");
         enterMarks.setBounds(x, ycord+330, w, h);
         enterMarks.setBackground(btnclr);
         enterMarks.setForeground(Color.WHITE);
         c.add(enterMarks);
JButton viewMajors = new JButton("View Major Instrument");
         viewMajors.setBounds(x+w+100, ycord+100, w, h);
         viewMajors.setBackground(btnclr);
         viewMajors.setForeground(Color.WHITE);
         c.add(viewMajors);
JButton viewMinors = new JButton("View Minor Instrument");
         viewMinors.setBounds(x+w+100, ycord+200, w, h);
         viewMinors.setBackground(btnclr);
         viewMinors.setForeground(Color.WHITE);
         c.add(viewMinors);
JButton viewResult = new JButton("View Results");
         viewResult.setBounds(x+w+100, ycord+330, w, h);
         viewResult.setBackground(btnclr);
         viewResult.setForeground(Color.WHITE);
         c.add(viewResult);


         
         //Event Listeners
         defineMajor.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
        MajWeightUI.createUI();
    }
});
         defineMinor.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                minor.minorinterface();
    }
});

         editMinors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                editMinor.editMinorUI();
    }
});
         deleteMinors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                deleteMinor.deleteMinorUI();
    }
});
         deleteMajors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                deleteMajor.deleteMajorUI();
    }
});
         editMajors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                editMajor.editMajorUI();
    }
});
         viewMajors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                viewMajor.viewMajorUI();
    }
});
         viewMinors.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                viewMinor.viewMinorUI();
    }
});













         dashboard.setVisible(true);
    }
}
