package domainLayer;
import databaseLayer.dbController;
import databaseLayer.majorEditDb;
import interfaces.editMajor;



public class editMaj {
    public static void majorProcEditInfo(String majorWeight,String majSelect) {
             // Create an instance of the 'major' class to handle alerts/messages
        editMajor majoralert = new editMajor();
        System.out.println("major Name: " + majorWeight);
        if ( majorWeight.isEmpty()) {
            majoralert.showError("Error: Some fields are null.");
        } else {
            // Check if both major marks and weight are numeric
            if (!isNumeric(majorWeight)) {
                majoralert.showError("Error: major marks and weight must be numeric values.");
            } else {
                // Show a success message if all checks pass
                majoralert.showSuccessMessage("Updated Successfully!");


                dbController.getMajorEditParamDb(majorWeight,majSelect );

                
                majorEditDb.MEDb(majorWeight, majSelect);
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
