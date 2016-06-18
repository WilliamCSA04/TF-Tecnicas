/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.persistencia.modelo;

import br.pucrs.sisinfo.persistencia.dao.LoginDao;

/**
 *
 * @author Joseane Wichrowski
 */
public class Login {

    private String email;
    private String senha;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Login{" + "email=" + email + ", senha=" + senha + '}';
    }
    
    
    
    
    
   
    
}
