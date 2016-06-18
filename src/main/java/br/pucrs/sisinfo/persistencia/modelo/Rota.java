package br.pucrs.sisinfo.persistencia.modelo;

public class Rota {

    private String destino;
    private String origem;

    public Rota(String origem, String destino) {
        this.destino = destino;
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    @Override
    public String toString() {
        return "Rota{" + "destino=" + destino + ", origem=" + origem + '}';
    }
    
}
