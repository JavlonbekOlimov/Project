package nt.WareHouse.Helper;

public class StringHelper {

    public static boolean isValid(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidInt(String s){
        try {
            return NumberHelper.isValidInt(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isValidDouble(String s){
        try {
            if(s == null) return false;
            return NumberHelper.isValidDouble(Double.parseDouble(s));
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isValidField(String fieldName){
        return fieldName == null || fieldName.trim().length() < 1;
    }
}
