package br.pucrs.sisinfo.interpretadores;

import br.pucrs.sisinfo.negocio.services.interpretadores.Interpretador;
import br.pucrs.sisinfo.negocio.services.interpretadores.InterpretadorDeDataBrasileira;
import br.pucrs.sisinfo.app.exceptions.InterpretadorException;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterpretadorDataBrasileiraTest {

    private Interpretador<Optional<GregorianCalendar>> interpretador;

    @Before
    public void setUp() throws Exception {
        interpretador = new InterpretadorDeDataBrasileira();
    }

    @Test
    public void interpretarDeveRetornarDataCorreta() throws Exception {
        
        GregorianCalendar dataEsperada = new GregorianCalendar(2016,4,17);

        Optional<GregorianCalendar> dataInterpretada = interpretador.interpretar("17/05/2016");
        
        assertTrue(dataInterpretada.isPresent());
        assertEquals(dataEsperada, dataInterpretada.get());
    }

    @Test
    public void interpretarDeveRetornarOptionalVazioSeOPadraoEstaErrado() throws Exception {
        Optional data = interpretador.interpretar("adasd");
        
        assertFalse(data.isPresent());
    }

    @Test
    public void interpretarDeveRetornarOptionalVazioSeADataForInvalida() throws Exception {
        Optional data = interpretador.interpretar("50/02/2019");
        
        assertFalse(data.isPresent());
    }
}
