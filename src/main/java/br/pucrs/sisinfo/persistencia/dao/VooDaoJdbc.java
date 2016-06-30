package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VooDaoJdbc implements VooDao{
    
    private Connection conexao;
    public static final String SELECT = "SELECT * FROM voos";
    
    @Inject
    public VooDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    //TESTAR
    public List<Voo> todos(){
        List<Voo> v = new ArrayList<>();
        try {
            PreparedStatement statement = conexao.prepareStatement(SELECT);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Calendar partida = Calendar.getInstance();               
                partida.setTimeInMillis(result.getTime("partida").getTime());
                partida.set(result.getDate("data_partida").getHours(),result.getDate("data_partida").getMinutes(),result.getDate("data_partida").getDate());
                Calendar chegada = Calendar.getInstance();
                chegada.setTimeInMillis(result.getTime("chegada").getTime());
                
                v.add(new Voo((GregorianCalendar)partida,(GregorianCalendar)chegada,result.getInt("id_rota")));
            }
            return v;
            
        } catch (SQLException ex) {
            Logger.getLogger(VooDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
