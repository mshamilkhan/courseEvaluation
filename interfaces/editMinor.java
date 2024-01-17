package interfaces;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import controllers.Controller;
import java.awt.*;


// import interfaces.editMinor;
import domainLayer.editMin;
public class editMinor{
    static JFrame editMinorframe;
    public static void editMinorUI(){
         editMinorframe = new JFrame();
        editMinorframe.setSize(1920, 1080);
        // editMinorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = editMinorframe.getContentPane();
       c.setLayout(null);
       editMinorframe.setTitle("Edit Minor Interfaces");              
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
       JLabel MinorName = new JLabel("Minor Weight");
       MinorName.setBounds(650, ycord+100, 500, 50);
       MinorName.setForeground(Color.BLACK);
       MinorName.setFont(lablefont);
       c.add(MinorName);

       JTextField dropdownMinor = new JTextField();
       dropdownMinor.setBounds(650, ycord+150, 500, 50);
       c.add(dropdownMinor);




    //    String[] optionsMinor = {"1010", "1011", "1012", "1013"};

    //    // Creating a JComboBox and adding options
    //    JComboBox<String> dropdownMinor = new JComboBox<>(optionsMinor);
    //    dropdownMinor.setBounds(650, ycord+150, 500, 50);
    //    c.add(dropdownMinor);

       JButton next = new JButton("edit");
       next.setBounds(650, ycord+250, 200, 50);
       Color btnclr = new Color(17, 77, 146);
       next.setBackground(btnclr);
       next.setForeground(Color.WHITE);
       c.add(next);

       JButton cancel = new JButton("cancel");
       cancel.setBounds(950, ycord+250, 200, 50);
      
       c.add(cancel);


         next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMajorText = (String) dropdown.getSelectedItem();
                String selectedMinorText =  dropdownMinor.getText();
             String[] minorEditParams=  Controller.getMinEditParam(selectedMajorText, selectedMinorText);
            editMin.minorProcEditInfo(minorEditParams[0],minorEditParams[1]);
            }
        });
         cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editMinorframe.dispose();
            }
        });



       editMinorframe.setVisible(true);
    //    fetchDataFromDatabaseMinor(dropdownMinor);
       fetchDataFromDatabase(dropdown);

    }


    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(editMinorframe, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

  
    public void showSuccessMessage(String message) {
        
        JOptionPane.showMessageDialog(editMinorframe, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    
private static void fetchDataFromDatabase(JComboBox<String> comboBox) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/courseevaluationdb";
        String username = "root";
        String password = "QwertyQwerty11,";

        String sql = "SELECT major_name FROM minor_instrument";

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
    
private static void fetchDataFromDatabaseMinor(JComboBox<String> comboBox) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/courseevaluationdb";
        String username = "root";
        String password = "QwertyQwerty11,";

        String sql = "SELECT minor_name FROM minor_instrument";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Clear existing items
            comboBox.removeAllItems();

            // Add items from the database to the JComboBox
            while (resultSet.next()) {
                String itemName = resultSet.getString("minor_name");
                comboBox.addItem(itemName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}