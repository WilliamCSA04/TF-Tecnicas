package br.pucrs.sisinfo.persistencia.modelo;


import java.util.GregorianCalendar;

public class Voo {
    
    private GregorianCalendar dataPartida;
    private GregorianCalendar dataChegada;
    private int rotaID;

    public Voo(GregorianCalendar dataPartida, GregorianCalendar dataChegada, int rotaID) {
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.rotaID = rotaID;
    }

    public GregorianCalendar getDataPartida() {
        return dataPartida;
    }

    public GregorianCalendar getDataChegada() {
        return dataChegada;
    }

    public int getRotaID() {
        return rotaID;
    }

   

    
    
    
    

}
