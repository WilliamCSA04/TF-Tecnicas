package br.pucrs.sisinfo.negocio.controller;


import br.pucrs.sisinfo.persistencia.dao.PassagensDao;
import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Inject;


public class PassagemController {

    private PassagensDao passagensDao;
    
    @Inject
    public PassagemController(PassagensDao passagensDao) {
        this.passagensDao = passagensDao;
    }
    
    public Passagem buscarPassagem(String id){
        return passagensDao.buscarPassagem(id);
    }
    
    public int buscarVooPorPassagem(String id){
        return passagensDao.buscarVoo(id);
    }
    
    
    
}
