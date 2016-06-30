package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import com.google.inject.Inject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


public class VooDaoJdbc implements VooDao{
    
    private Connection conexao;
    
    
    @Inject
    public VooDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    

    
    
    @Override
    public List<Voo> buscarPorData(GregorianCalendar data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voo> buscarPorData(Aeroporto origem, GregorianCalendar data) {
        
        Random randomGenerator = new Random();
        
        Integer totalFlights = randomGenerator.nextInt(150);
        
        List<Voo> voos = new ArrayList<>();
        
        for (int i = 0; i < totalFlights; i++) {
//            voos.add(new Voo("Voo " + i));
        }
        
        return voos;
    }

    @Override
    public void insert(Voo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
