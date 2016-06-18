package br.pucrs.sisinfo.negocio.services.interpretadores;

@FunctionalInterface
public interface Interpretador<T> {

    T interpretar(String padrao);
}
