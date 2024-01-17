package domainLayer;
import databaseLayer.dbController;
import databaseLayer.majorDb;
import interfaces.MajWeightUI;



public class major {
    public static void majorinfoprocess(String majorNameText, String majorWeightText, String courseCode) {
        // Create an instance of the 'major' class to handle alerts/messages
        MajWeightUI majoralert = new MajWeightUI();
        System.out.println("major Name: " + majorNameText);
        if (courseCode.isEmpty() || majorNameText.isEmpty() || majorWeightText.isEmpty()) {
            majoralert.showError("Error: Some fields are null.");
        } else {
            // Check if both major marks and weight are numeric
            if (!isNumeric(majorWeightText)) {
                majoralert.showError("Error: major marks and weight must be numeric values.");
            } else {
                // Show a success message if all checks pass
                majoralert.showSuccessMessage("This is a success message!");

               
                dbController.getMajorParamDb(majorNameText, majorWeightText, courseCode);

                
                majorDb.majorDB(majorNameText, majorWeightText, courseCode);
            }
        }
    }

    


    // Utility method to check if a string is numeric
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
}
 