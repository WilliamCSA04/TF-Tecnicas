package br.pucrs.sisinfo.persistencia.modelo;

import java.util.GregorianCalendar;

public class Voo {
    
    private String id;
    private Rota rota;
    private GregorianCalendar data;
    private String nome;

    public Voo(String nome) {
        this.nome = nome;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    

}
