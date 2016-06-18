package br.pucrs.sisinfo.persistencia.modelo;

public class Aeroporto {
    private String id;
    private String nome;

    public Aeroporto(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "id=" + id + ", nome=" + nome + '}';
    }
}
