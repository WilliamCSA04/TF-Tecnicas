package br.pucrs.sisinfo.persistencia.modelo;

public class Voo {
    
    private String nome;

    public Voo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
