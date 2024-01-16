package domainLayer;
import databaseLayer.dbController;
import databaseLayer.minorDb;
import interfaces.minor;



public class minorValidation {
    public static void minorinfoprocess(String minorNameText, String minorMarksText, String minorWeightText, String selectedMajorText) {
        // Create an instance of the 'minor' class to handle alerts/messages
        minor minoralert = new minor();

        // Print the values of minor marks and minor name to the console
        System.out.println("Minor marks: " + minorMarksText);
        System.out.println("Minor Name: " + minorNameText);

        // Check if any of the required fields is empty
        if (minorMarksText.isEmpty() || selectedMajorText.isEmpty() || minorNameText.isEmpty() || minorWeightText.isEmpty()) {
            // Show an error message if any of the required fields is empty
            minoralert.showError("Error: Some fields are null.");
        } else {
            // Check if both minor marks and weight are numeric
            if (!isNumeric(minorMarksText) || !isNumeric(minorWeightText)) {
                // Show an error message if either minor marks or weight is not numeric
                minoralert.showError("Error: Minor marks and weight must be numeric values.");
            } else {
                // Show a success message if all checks pass
                minoralert.showSuccessMessage("This is a success message!");

                // Call the 'getMinorParamDb' method from the 'dbController' class
                dbController.getMinorParamDb(minorNameText, minorMarksText, minorWeightText);
                // Call the 'minorDB' method from the 'minorDb' class
                minorDb.minorDB(minorNameText, minorMarksText, minorWeightText);
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
 