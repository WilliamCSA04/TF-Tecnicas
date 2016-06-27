package br.pucrs.sisinfo.negocio.services;

import br.pucrs.sisinfo.persistencia.dao.AeroportoDao;
import br.pucrs.sisinfo.persistencia.dao.RotaDao;
import br.pucrs.sisinfo.persistencia.dao.VooDao;
import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 
 * A implementacao deste service e feita em formato facade
 * 
 * Nesta implementacao, se faz o uso do dao de voos para encontrar
 * voos por data e origem
 * 
 * Como complemento, se utilizam o rota dao e aeroporto para buscar as demais 
 * informacoes sobre a rota
 * 
 * Ou seja, o facade ajuda a agregar todas estas informacoes de diversas fontes
 * (diversos daos), retornando uma lista de voos consistente.
 */
public class VooServiceFacade implements VooService{
    
    private final RotaDao rotaDao;
    private final VooDao vooDao;
    private final AeroportoDao aeroportoDao;

    @Inject
    public VooServiceFacade(RotaDao rotaDao, VooDao vooDao, AeroportoDao aeroportoDao) {
        this.rotaDao = rotaDao;
        this.vooDao = vooDao;
        this.aeroportoDao = aeroportoDao;
    }
    
    @Override
    public List<Voo> buscaPorData(Aeroporto origem, GregorianCalendar data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Voo> buscaVoos(GregorianCalendar calendar, Aeroporto origem) {
        return Arrays.asList(null);
    }
    
}
