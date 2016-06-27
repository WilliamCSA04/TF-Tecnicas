package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.negocio.services.VooService;
import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.modelo.Voo;

import java.util.*;

public class PesquisaController {
    
    private final VooService vooService;

    public PesquisaController(VooService vooService) {
        this.vooService = vooService;
    }
    
    
    public List<Voo> buscaVoosPorData(Aeroporto origem, GregorianCalendar data) {
        
       return vooService.buscaPorData(origem, data);
       
    }

}
