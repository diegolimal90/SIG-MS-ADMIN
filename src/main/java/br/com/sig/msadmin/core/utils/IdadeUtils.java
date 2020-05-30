package br.com.sig.msadmin.core.utils;

import java.time.LocalDate;
import java.time.Period;

public class IdadeUtils {
    private static int calcularIdade(LocalDate dataNascimento, LocalDate dataAtual) {
        if ((dataNascimento != null) && (dataAtual != null)) {
            return Period.between(dataNascimento, dataAtual).getYears();
        } else {
            return 0;
        }
    }
    
    public static boolean isMaior(LocalDate dataNascimento){
        if( !( calcularIdade(dataNascimento, LocalDate.now()) >= 18 ) ){
			return true;
        }
        
        return false;
    }
}