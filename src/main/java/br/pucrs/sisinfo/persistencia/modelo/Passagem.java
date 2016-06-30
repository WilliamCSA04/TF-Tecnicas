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
private int vooID;
private String passageiroID;
private String status;

    public Passagem(String id, int vooID, String passageiroID, String status) {
        this.id = id;
        this.vooID = vooID;
        this.passageiroID = passageiroID;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public int getVooID() {
        return vooID;
    }

    public String getPassageiroID() {
        return passageiroID;
    }

    public String getStatus() {
        return status;
    }

    

    


    
    
}
