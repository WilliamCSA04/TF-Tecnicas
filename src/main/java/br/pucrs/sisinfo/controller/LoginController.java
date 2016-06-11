/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.controller;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joseane Wichrowski
 */
public class LoginController {
    
    private final static String emailRegularExpression = "^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,}$";
    
    
    public int buscaUsuario(String email, String senha){
        if(!validadorEmail(email.toUpperCase())){
            return 0;
        }
        if(email.equalsIgnoreCase("mel@caomenor.com") && senha.equals("melzinha")){
            return 1;
        }
        return -1;
    }
    
    private boolean validadorEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegularExpression);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public String encodeString(String s) throws UnsupportedEncodingException{
        return new String(s.getBytes(), "UTF-8");
    }
    
}
