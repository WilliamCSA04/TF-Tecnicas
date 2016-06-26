/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.controllerTest;

import br.pucrs.sisinfo.negocio.controller.PesquisaController;
import br.pucrs.sisinfo.negocio.services.interpretadores.Interpretador;
import java.util.GregorianCalendar;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Jader Cunha
 */
public class PesquisaControllerTest {
    private PesquisaController pesquisa;
    private Interpretador<Optional<GregorianCalendar>> interpretador;
        
    @BeforeClass
    public static void setUpClass() {
        PesquisaController pesquisa = new PesquisaController();
    }    
}
