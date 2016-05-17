package br.pucrs.sisinfo.interpretadores;

import br.pucrs.sisinfo.exceptions.InterpretadorException;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class InterpretadorDataBrasileiraTest {

    private Interpretador<GregorianCalendar> interpretador;

    @Before
    public void setUp() throws Exception {
        interpretador = new InterpretadorDeDataBrasileira();
    }

    @Test
    public void interpretarDeveRetornarDataCorreta() throws Exception {

        GregorianCalendar dataEsperada = new GregorianCalendar(2016,4,17);

        GregorianCalendar dataInterpretada = interpretador.interpretar("17/05/2016");

        assertEquals(dataEsperada, dataInterpretada);
    }

    @Test(expected = InterpretadorException.class)
    public void interpretarDeveCausarUmaExcecaoPorPadraoInvalido() throws Exception {
        interpretador.interpretar("adasd");
    }

    @Test(expected = InterpretadorException.class)
    public void interpretarDeveCausarUmaExcecaoPorValorDeDataInvalido() throws Exception {
        interpretador.interpretar("50/02/2019");
    }
}
