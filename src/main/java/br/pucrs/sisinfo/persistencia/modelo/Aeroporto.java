package br.pucrs.sisinfo.persistencia.domain;

public class Aeroporto {
    private int id;
    private String nome;
    private String identificador;

    public Aeroporto(int id, String nome, String identificador) {
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
    }

    public Aeroporto(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "id=" + id + ", nome=" + nome + ", identificador=" + identificador + '}';
    }
    
    
    
    
    
    
    
}
