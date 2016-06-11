/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.controller;

/**
 *
 * @author Joseane Wichrowski
 */
public class LoginController {
    
    public boolean buscaUsuario(String usuario, String senha){
        if(usuario.equalsIgnoreCase("mel@caomenor.com") && senha.equals("melzinha")){
            return true;
        }
        return false;
    }
    
}
