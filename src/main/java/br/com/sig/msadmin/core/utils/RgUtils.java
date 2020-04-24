package br.com.sig.msadmin.core.utils;

public class RgUtils {
    public static boolean isValid(String rg){
        rg.trim().replace(".", "").replace("-", "");
        return rg.equals("") ? false : rg.matches("^[0-9]{9}");
    }
}