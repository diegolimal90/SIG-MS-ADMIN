package br.com.sig.msadmin.core.utils;

public class TelefoneUtils {
    public static boolean isValid(String numero){
        return numero.equals("") ? false : numero.matches("^(\\+[1-9][0-9]*(\\([0-9]*\\)|-[0-9]*-))?[0]?[1-9][0-9\\- ]*$");
    }
}