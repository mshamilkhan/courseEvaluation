package domainLayer;
import databaseLayer.dbController;
import databaseLayer.minorEditDb;
import interfaces.editMinor;



public class editMin {
    public static void minorProcEditInfo(String majorWeight,String majSelect) {
        editMinor majoralert = new editMinor();
        System.out.println("major Name: " + majorWeight);
        if ( majorWeight.isEmpty()) {
            majoralert.showError("Error: Some fields are null.");
        } else {
            // Check if both major marks and weight are numeric
            if (!isNumeric(majSelect)) {
                majoralert.showError("Error: major marks and weight must be numeric values.");
            } else {
                // Show a success message if all checks pass
                majoralert.showSuccessMessage("Updated Successfully!");
                dbController.getMajorEditParamDb(majorWeight,majSelect );     
                minorEditDb.MinEDb(majorWeight, majSelect);
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
