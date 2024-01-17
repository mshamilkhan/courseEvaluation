package databaseLayer;

public class dbController {
    public static String[] getMinorParamDb(String minorNameText, String minorMarksText, String minorWeightText, String selectedMajorText) {
        String[] minorParams = {minorNameText, minorMarksText, minorWeightText,selectedMajorText};
        System.out.println("DBController: -->  " + minorNameText);
        return minorParams;
    }
    public static String[] getMajorParamDb(String majorNameText, String majorWeightText, String courseCode) {
        String[] majorParams = {majorNameText, majorWeightText, courseCode};
        System.out.println("DBController: -->  " + majorNameText);
        return majorParams;
    }
    public static String[] getMajorEditParamDb(String majorWeight, String majSelect) {
        String[] edited = {majorWeight, majSelect};
        System.out.println("DBController: -->  " + majorWeight);
       return edited;
    }
    public static String[] getMinorEditParamDb(String minSelect, String majSelect) {
        String[] edited = {minSelect, majSelect};
        // System.out.println("DBController: -->  " + majorWeight);
       return edited;
    }
    public static String getMajorDelParamDb(String major) {
      return major;
    }
}
