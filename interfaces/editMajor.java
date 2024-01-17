package interfaces;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import controllers.Controller;
import domainLayer.editMaj;

import java.awt.*;
public class editMajor{
static JFrame editMajorframe;
    public static void editMajorUI(){
     editMajorframe = new JFrame();
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

       JButton back = new JButton("back");
       back.setBounds(950, ycord+250, 200, 50);
      
       c.add(back);

next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String majorWeightText = weightinput.getText();
                String majorDd = (String) dropdown.getSelectedItem();
             
                Controller.getEditMajorParam(majorWeightText);
                
                editMaj.majorProcEditInfo(majorWeightText, majorDd);

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editMajorframe.dispose();
            }
        });



        fetchDataFromDatabase(dropdown);
       editMajorframe.setVisible(true);


    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(editMajorframe, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

  
    public void showSuccessMessage(String message) {
        
        JOptionPane.showMessageDialog(editMajorframe, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

private static void fetchDataFromDatabase(JComboBox<String> comboBox) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/courseevaluationdb";
        String username = "root";
        String password = "QwertyQwerty11,";

        String sql = "SELECT major_name FROM major_instrument";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Clear existing items
            comboBox.removeAllItems();

            // Add items from the database to the JComboBox
            while (resultSet.next()) {
                String itemName = resultSet.getString("major_name");
                comboBox.addItem(itemName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    
}