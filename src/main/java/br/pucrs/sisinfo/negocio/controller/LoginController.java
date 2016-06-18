/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.domain.Login;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joseane Wichrowski
 */
public class LoginController {
    
    private final static String emailRegularExpression = "^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,}$";
    private Login model;

    public LoginController() {
        model = new Login();
    }
    
    
    
    public int buscaUsuario(String email, String senha){
        if(!validadorEmail(email.toUpperCase())){
            return 0;
        }
        //Tirar primeiro operador do || após a finalização do metodo de chegarLogin e seus dependencias.
        if(email.equalsIgnoreCase("mel@caomenor.com") && senha.equals("melzinha") || model.checarLogin(email)){
            return 1;
        }
        return -1;
    }
    
    private boolean validadorEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegularExpression);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    
    
}
