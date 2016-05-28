package br.pucrs.sisinfo.interpretadores;

@FunctionalInterface
public interface Interpretador<T> {

    T interpretar(String padrao);
}
