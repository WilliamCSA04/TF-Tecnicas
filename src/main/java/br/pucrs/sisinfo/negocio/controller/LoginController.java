package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.modelo.Login;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginController {
    
    private final static String emailRegularExpression = "^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,}$";
    private Login model;

    public LoginController() {

    }
    
    
    
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
    
    
    
}
