/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.dao.MapaAssentosDao;
import com.google.inject.Inject;

/**
 *
 * @author William
 */
public class MapaAssentoController {
    
    
    MapaAssentosDao mapaAssento;
    public static int idSalvo;
    
    @Inject
    public MapaAssentoController(MapaAssentosDao mapaAssento) {
        this.mapaAssento = mapaAssento;
    }
    
    public boolean[] poltronasOcupadas(int id){
        idSalvo=id;
        return mapaAssento.poltronasOcupadas(id);
    }
    
    public void atualizarPoltronas(boolean[] poltronas){
        mapaAssento.atualizarPoltronas(poltronas, idSalvo);
    }
}
