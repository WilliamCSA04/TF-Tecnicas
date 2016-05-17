package br.pucrs.sisinfo.widget;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

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
        Scanner leitorTerminal = new Scanner(simularEntradaDoUsuario(""));
        LeitorEntrada leitorData = new LeitorDataPesquisa(leitorTerminal);
        String mensagemEsperada = "Digite uma data para pesquisar voos:";

        leitorData.exibir();
        String mensagemExibida = saidaSimulada.toString().trim();


        assertEquals(mensagemEsperada, mensagemExibida);
    }

    @Test
    public void lerDeveRetornarDataCorreta() throws Exception {
        GregorianCalendar dataEsperada = new GregorianCalendar(2016, 4, 17);
        Scanner leitorTerminal = new Scanner(simularEntradaDoUsuario("17/05/2016"));
        LeitorDataPesquisa leitorData = new LeitorDataPesquisa(leitorTerminal);

        GregorianCalendar dataLida = leitorData.ler();

        assertEquals(dataEsperada, dataLida);

    }

    private InputStream simularEntradaDoUsuario(String entradaParaSimular) {
        return new ByteArrayInputStream(entradaParaSimular.getBytes());
    }
}
