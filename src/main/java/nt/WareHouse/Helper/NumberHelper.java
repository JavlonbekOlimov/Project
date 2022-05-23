package nt.WareHouse.Helper;

public class NumberHelper {

    public static boolean isValidInt(Integer i) {
        return i != null && i > -1;
    }

    public static boolean isValidDouble(Double d) {
        return d != null && d > -1;
    }

    public static Integer toInt(String s) {
        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static Double toDouble(String s) {
        try {
            return Double.parseDouble(s);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
