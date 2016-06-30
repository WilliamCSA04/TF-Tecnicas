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

public class VooDaoJdbc implements VooDao {

    private Connection conexao;
    public static final String SELECT = "SELECT * FROM voos";

    @Inject
    public VooDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }

    //TESTAR
    public List<Voo> todos() {
        List<Voo> v = new ArrayList<>();
        try {
            PreparedStatement statement = conexao.prepareStatement(SELECT);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Calendar partida = Calendar.getInstance();
                partida.setTimeInMillis(result.getTime("partida").getTime());
                partida.set(result.getDate("data_partida").getHours(), result.getDate("data_partida").getMinutes(), result.getDate("data_partida").getDate());
                Calendar chegada = Calendar.getInstance();
                chegada.setTimeInMillis(result.getTime("chegada").getTime());

                v.add(new Voo((GregorianCalendar) partida, (GregorianCalendar) chegada, result.getInt("id_rota")));
            }
            return v;

        } catch (SQLException ex) {
            Logger.getLogger(VooDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Calendar buscarDataPorID(int id) {
        try {
            PreparedStatement statement = conexao.prepareStatement("select data_partida from voos where id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Calendar c = Calendar.getInstance();
            result.next();
            c.setTime(result.getDate("data_partida"));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(VooDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int buscarRota(int id) {
        try {
            PreparedStatement statement = conexao.prepareStatement("select id_rota from voos where id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt("id_rota");
        } catch (SQLException ex) {
            Logger.getLogger(VooDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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

    @Override
    public int buscarMapaPorID(int id) {
        try {
            PreparedStatement statement = conexao.prepareStatement("select id_mapa_assentos from voos where id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt("id_mapa_assentos");
        } catch (SQLException ex) {
            Logger.getLogger(VooDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
   

}
