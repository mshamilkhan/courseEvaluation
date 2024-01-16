package domainLayer;
import databaseLayer.dbController;
import databaseLayer.minorDb;
import interfaces.minor;



public class minorValidation{
    public static void minorinfoprocess(String minorNameText,String minorMarksText,String minorWeightText, String selectedMajorText )
    {
        minor minoralert = new minor();
        System.out.println("Minor marks: " + minorMarksText);
        System.out.println("Minor Name: " + minorNameText);
                if(minorMarksText.isEmpty() || selectedMajorText.isEmpty() || minorNameText.isEmpty() || minorWeightText.isEmpty()){
                      minoralert.showError("Error: Some fields are null.");
                }
                else{
                    
                    minoralert.showSuccessMessage("This is a success message!");
                    dbController.getMinorParamDb(minorNameText, minorMarksText, minorWeightText);
                    minorDb.minorDB(minorNameText, minorMarksText, minorWeightText);
                }


    }
}