package br.pucrs.sisinfo.widget;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class LeitorDataPesquisa implements LeitorEntrada<GregorianCalendar> {

    private Scanner leitorEntrada;

    public LeitorDataPesquisa(Scanner leitorEntrada) {
        this.leitorEntrada = leitorEntrada;
    }

    @Override
    public void exibir() {
        System.out.println("Digite uma data para pesquisar voos: ");
    }

    @Override
    public GregorianCalendar ler() {
        return new GregorianCalendar(2016, 4, 17);
    }

}
