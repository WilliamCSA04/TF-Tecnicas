/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.controllerTest;

import br.pucrs.sisinfo.negocio.controller.PesquisaController;
import br.pucrs.sisinfo.negocio.services.interpretadores.Interpretador;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    public void buscaVooPorData(){    
        
        GregorianCalendar dataEsperada = new GregorianCalendar(2016,4,17);

        Optional<GregorianCalendar> dataInterpretada = interpretador.interpretar("17/05/2016");

        assertEquals("Uma lista de acordo com a data ", pesquisa.buscaVoosPorData(dataInterpretada));
    }
}
