package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.dao.AeroportoDao;
import com.google.inject.Inject;

public class AeroportoController {
    
    AeroportoDao aeroportoDao;

    @Inject
    public AeroportoController(AeroportoDao aeroportoDao) {
        this.aeroportoDao = aeroportoDao;
    }
    
    public String buscarPorID(String id){
        return aeroportoDao.buscarPorID(id);
    }
    
}
