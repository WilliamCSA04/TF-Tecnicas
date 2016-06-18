package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeroportoDaoJdbc implements AeroportoDao{
    
    private static final String SELECT = "SELECT id, nome, identificador FROM aeroportos";
    private static final String INSERT = "INSERT INTO aeroportos (nome, identificador) VALUES(?, ?)";
    
    private Connection conexao;
    
    
    @Inject
    public AeroportoDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public List<Aeroporto> todos() {
        
        List<Aeroporto> aeroportos = new ArrayList<>();
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(SELECT);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                Aeroporto aeroporto = new Aeroporto(result.getInt("id"), result.getString("nome"), result.getString("identificador"));
                aeroportos.add(aeroporto);
            }
            
            statement.close();
            
            return aeroportos;
            
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aeroportos;
    }

    @Override
    public List<Aeroporto> buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Aeroporto aeroporto) {
        try {
            
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            
            statement.setString(1, aeroporto.getNome());
            statement.setString(2, aeroporto.getIdentificador());
            
            statement.execute();
            statement.close();
            
            Logger.getLogger(AeroportoDaoJdbc.class.getName() + " -> INSERT : ").log(Level.INFO, aeroporto.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
