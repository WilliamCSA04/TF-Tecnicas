package br.pucrs.sisinfo.persistencia.dao;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MapaAssentosDaoJdbc implements MapaAssentosDao{
    
    
    private Connection conexao;
    private static final String SELECT = "select * from Mapa_assentos";

    @Inject
    public MapaAssentosDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    public boolean[] poltronasOcupadas(int id){
        try {
            PreparedStatement statement = conexao.prepareStatement(SELECT + " where id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            boolean[] poltronas = {result.getBoolean("poltrona1"),result.getBoolean("poltrona2"),result.getBoolean("poltrona3"),result.getBoolean("poltrona4"),result.getBoolean("poltrona5"),result.getBoolean("poltrona6"),result.getBoolean("poltrona7"),result.getBoolean("poltrona8"),result.getBoolean("poltrona9"),result.getBoolean("poltrona10")};
            return poltronas;
        } catch (SQLException ex) {
            Logger.getLogger(MapaAssentosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void atualizarPoltronas(boolean[] poltronas, int id){
        try {
            PreparedStatement statement = conexao.prepareStatement("update mapa_assentos set poltrona1 = ?, poltrona2 = ?, poltrona3 = ?, poltrona4 = ?, poltrona5 = ?, poltrona6 = ?, poltrona7 = ?, poltrona8 = ?, poltrona9 = ?, poltrona10 = ? where id = ?");
            for(int i=0;i<10;i++){
                statement.setBoolean(i+1, poltronas[i]);
            }
            statement.setInt(11, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MapaAssentosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
