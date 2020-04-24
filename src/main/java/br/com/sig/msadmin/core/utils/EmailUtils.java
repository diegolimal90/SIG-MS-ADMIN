package br.com.sig.msadmin.core.utils;

public class EmailUtils {
    public static boolean isValid(String email){
        return email.equals("") ? false : email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}