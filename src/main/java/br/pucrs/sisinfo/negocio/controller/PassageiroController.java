/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.negocio.controller;
import br.pucrs.sisinfo.persistencia.dao.PassageirosDaoJdbc;
import br.pucrs.sisinfo.persistencia.modelo.Passageiro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PassageiroController {
    
    private final static String emailRegularExpression = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private Passageiro model;

    public PassageiroController() {

    }
    
    public int buscaUsuario(String email, String senha){
        if(!validadorEmail(email)){
            return 0;
        }
        
        if(email.equalsIgnoreCase("mel@caomenor.com") && senha.equals("melzinha")){ //TODO substituir esse if pelo metodo checarLogin da classe PassageirosDaoJdbc.
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
