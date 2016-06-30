package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.dao.RotaDao;
import com.google.inject.Inject;


public class RotaController {
    
    RotaDao rotaDao;
    
    @Inject
    public RotaController(RotaDao rotaDao) {
        this.rotaDao = rotaDao;
    }
    
    public String[] buscarOrigemDestino(int idRota){
        return rotaDao.buscarOrigemDestino(idRota);
    }
    
}
