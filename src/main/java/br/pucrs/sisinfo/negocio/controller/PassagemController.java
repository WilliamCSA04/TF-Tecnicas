/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.app.config.guice.providers.ConnectionProvider;
import br.pucrs.sisinfo.persistencia.dao.PassagensDao;
import br.pucrs.sisinfo.persistencia.dao.PassagensDaoJdbc;
import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Inject;

/**
 *
 * @author Joseane Wichrowski
 */
public class PassagemController {

    private PassagensDao passagensDao;
    
    @Inject
    public PassagemController(PassagensDao passagensDao) {
        this.passagensDao = passagensDao;
    }
    
    public Passagem buscarPassagem(String id){
        return passagensDao.buscarPassagem(id);
    }
    
    
    
}
