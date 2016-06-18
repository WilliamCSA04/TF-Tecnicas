package br.pucrs.sisinfo.persistencia.modelo;

public class Voo {
    
    private int id;
    private String nome;
    
    public Voo(int id) {
        this.id = id;
    }

    public Voo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Voo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }

}
