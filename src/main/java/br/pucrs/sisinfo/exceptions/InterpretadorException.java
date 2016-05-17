package br.pucrs.sisinfo.exceptions;

public class InterpretadorException extends Exception {

    public InterpretadorException() {
        super("Não foi possível interpretar o padrão recebido");
    }

    public InterpretadorException(String message) {
        super(message);
    }
}
