package domainLayer;
import databaseLayer.dbController;
import databaseLayer.majorDelDb;
import interfaces.deleteMajor;

public class delMaj {

    public static void majorProcDelInfo(String major) {
             
        deleteMajor majoralert = new deleteMajor();
        System.out.println("major Deleted: " + major);
                majoralert.showSuccessMessage("Deleted Successfully!");
                dbController.getMajorDelParamDb(major);                
                majorDelDb.MDDb(major);
            
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
