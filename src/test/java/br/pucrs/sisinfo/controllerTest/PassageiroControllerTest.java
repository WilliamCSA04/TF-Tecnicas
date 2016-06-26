/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.controllerTest;

import br.pucrs.sisinfo.negocio.controller.PassageiroController;
import br.pucrs.sisinfo.persistencia.modelo.Passageiro;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell Inc
 */
public class PassageiroControllerTest {
    
    private PassageiroController _passageiroController;
    
    public PassageiroControllerTest() {
    }
    
    @BeforeClass
    public static void setUp() {
        PassageiroController _passageiroController = new PassageiroController();
    }
    
    @Test
    public void buscarUsuario(){
        String _email = "mel@caomenor.com";
        String _senha = "melzinha";
        
        int _test = _passageiroController.buscaUsuario(_email, _senha);
        assertTrue("O usuário deve ser o número 1 = ",_passageiroController.equals(_test));
    }
    
}
