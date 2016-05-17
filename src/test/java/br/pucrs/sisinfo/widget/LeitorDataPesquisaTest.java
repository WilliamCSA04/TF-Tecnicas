package br.pucrs.sisinfo.widget;

import br.pucrs.sisinfo.exceptions.InterpretadorException;
import br.pucrs.sisinfo.interpretadores.Interpretador;
import br.pucrs.sisinfo.interpretadores.InterpretadorDeDataBrasileira;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeitorDataPesquisaTest {

    private final OutputStream saidaSimulada = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(saidaSimulada));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void exibeDeveEscreverMensagemEsperadaNaSaidaDoTerminal() throws Exception {
        Scanner leitorTerminal = new Scanner(simularEntradaDoUsuario("\n"));
        LeitorEntrada leitorData = new LeitorDataPesquisa(leitorTerminal, new Interpretador<GregorianCalendar>() {

            @Override
            public GregorianCalendar interpretar(String padrao) throws InterpretadorException {
                return null;
            }
        });

        String mensagemEsperada = "Digite uma data para pesquisar voos:";

        leitorData.exibir();
        String mensagemExibida = saidaSimulada.toString().trim();


        assertEquals(mensagemEsperada, mensagemExibida);
    }

    @Test
    public void lerDeveRetornarDataCorreta() throws Exception {
        GregorianCalendar dataEsperada = new GregorianCalendar(2016, 4, 17);
        Scanner leitorTerminal = new Scanner(simularEntradaDoUsuario("17/05/2016"));
        LeitorDataPesquisa leitorData = new LeitorDataPesquisa(leitorTerminal, new Interpretador<GregorianCalendar>() {
            @Override
            public GregorianCalendar interpretar(String padrao) throws InterpretadorException {
                return new GregorianCalendar(2016, 4, 17);
            }
        });

        Optional<GregorianCalendar> dataLida = leitorData.ler();

        assertTrue(dataLida.isPresent());

        assertEquals(dataEsperada, dataLida.get());

    }

    private InputStream simularEntradaDoUsuario(String entradaParaSimular) {
        return new ByteArrayInputStream(entradaParaSimular.getBytes());
    }
}
