package br.pucrs.sisinfo.persistencia.modelo;


public class CompanhiaAerea {
    
    private int id;
    private String nome;
    private String identificador;

    public CompanhiaAerea(int id, String nome, String identificador) {
        this.id = id;
        this.nome = nome;
        this.identificador = identificador;
    }

    public CompanhiaAerea(String nome, String identificador) {
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
        return "CompanhiaAerea{" + "id=" + id + ", nome=" + nome + ", identificador=" + identificador + '}';
    }
    
}
