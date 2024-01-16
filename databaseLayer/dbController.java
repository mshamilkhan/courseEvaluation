package databaseLayer;



// public class dbController {

//     public static String[] getMinorParamDb(String minorNameText, String minorMarksText, String minorWeightText) {
//     String[] minorParams = {minorNameText, minorMarksText, minorWeightText};
//     System.out.println("DBController: -->  " + minorNameText);
//     minorDb.minorDB(minorNameText, minorMarksText, minorWeightText);
//     return minorParams;

//     }
// }
// dbController.java
public class dbController {
    public static String[] getMinorParamDb(String minorNameText, String minorMarksText, String minorWeightText) {
        String[] minorParams = {minorNameText, minorMarksText, minorWeightText};
        System.out.println("DBController: -->  " + minorNameText);
        return minorParams;
    }
}
