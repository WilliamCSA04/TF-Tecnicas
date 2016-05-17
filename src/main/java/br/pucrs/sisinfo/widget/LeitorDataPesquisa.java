package br.pucrs.sisinfo.widget;

import br.pucrs.sisinfo.exceptions.InterpretadorException;
import br.pucrs.sisinfo.interpretadores.Interpretador;
import br.pucrs.sisinfo.interpretadores.InterpretadorDeDataBrasileira;

import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Scanner;

public class LeitorDataPesquisa implements LeitorEntrada<Optional<GregorianCalendar>> {

    private Scanner leitorEntrada;
    private Interpretador<GregorianCalendar> interpretador;
    private String entradaUsuario;

    public LeitorDataPesquisa(Scanner leitorEntrada, Interpretador<GregorianCalendar> interpretador) {
        this.leitorEntrada = leitorEntrada;
        this.interpretador = interpretador;
    }

    @Override
    public void exibir() {

        System.out.println("Digite uma data para pesquisar voos: ");

        entradaUsuario = leitorEntrada.nextLine();
    }

    @Override
    public Optional<GregorianCalendar> ler() {

        try {

            return Optional.of(interpretador.interpretar(entradaUsuario));

        } catch(InterpretadorException ex) {

            return Optional.empty();

        }

    }

}
