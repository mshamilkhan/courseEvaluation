package domainLayer;
import javax.swing.*;

import interfaces.minor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class validation{
    public static void minorinfoprocess(String minorNameText,String minorMarksText,String minorWeightText, String selectedMajorText ){
        minor minoralert = new minor();
        System.out.println("Minor marks: " + minorMarksText);
        System.out.println("Minor Name: " + minorNameText);
                if(minorMarksText.isEmpty() || selectedMajorText.isEmpty() || minorNameText.isEmpty() || minorWeightText.isEmpty()){
                      minoralert.showError("Error: Some fields are null.");
                
                }
                else{
                    
                    minoralert.showSuccessMessage("This is a success message!");
                }
                // else if(!minorMarksText.isEmpty() && !selectedMajorText.isEmpty() && !minorNameText.isEmpty() && !minorWeightText.isEmpty()){
                //     System.out.println("Success Message should be created");
                // }

    }


    
}