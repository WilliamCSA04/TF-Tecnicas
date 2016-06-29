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
private int rota;
private String dataEmbarque;
private String passageiro_id;
private String status;

    public Passagem(String id, int rota, String dataEmbarque, String passageiro_id, String status) {
        this.id = id;
        this.rota = rota;
        this.dataEmbarque = dataEmbarque;
        this.passageiro_id = passageiro_id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public int getRota() {
        return rota;
    }

    public String getDataEmbarque() {
        return dataEmbarque;
    }

    public String getPassageiro_id() {
        return passageiro_id;
    }

    public String getStatus() {
        return status;
    }

    


    
    
}
