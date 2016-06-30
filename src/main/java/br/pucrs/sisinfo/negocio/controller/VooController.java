package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.dao.VooDao;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import com.google.inject.Inject;
import java.util.Calendar;

public class VooController {
    
    private VooDao vooDao;
    
    @Inject
    public VooController(VooDao vooDao) {
        this.vooDao = vooDao;
    }
    
    public Calendar dataEmbarque(int id){
        return vooDao.buscarDataPorID(id);
    }
    
    public int buscarRota(int id){
        return vooDao.buscarRota(id);
    }

    
}
