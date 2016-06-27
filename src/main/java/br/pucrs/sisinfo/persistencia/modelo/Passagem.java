/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.persistencia.modelo;

/**
 *
 * @author 14201805
 */
public class Passagem {

private String id;
private String origem;
private String destino;
private String dataEmbarque;
private String passageiro_id;
private String status;

    public Passagem(String id, String origem, String destino, String dataEmbarque, String passageiro_id, String status) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataEmbarque = dataEmbarque;
        this.passageiro_id = passageiro_id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDataEmbarque() {
        return dataEmbarque;
    }

    public String getDestino() {
        return destino;
    }

    public String getStatus() {
        return status;
    }

    public String getPassageiro_id() {
        return passageiro_id;
    }



    
    
}
