package br.pucrs.sisinfo.model.domain;

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
