package br.pucrs.sisinfo.interpretadores;

import br.pucrs.sisinfo.exceptions.InterpretadorException;

public interface Interpretador<T> {

    T interpretar(String padrao) throws InterpretadorException;
}
