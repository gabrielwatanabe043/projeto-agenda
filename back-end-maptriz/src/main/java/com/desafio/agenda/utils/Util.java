package com.desafio.agenda.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean validatorCpf(String cpf){
        String regex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cpf);

        return matcher.matches();
    }

    public static boolean validatorCnpj(String cnpj){
        String regex = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cnpj);

        return matcher.matches();
    }

    public static boolean validatorCep(String cep){
        String regex = "^\\d{5}\\-\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cep);

        return matcher.matches();
    }
}
