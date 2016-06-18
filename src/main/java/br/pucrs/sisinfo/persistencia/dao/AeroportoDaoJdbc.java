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
    
    private static final String LIKE_FILTER = "%__text__%";
    private static final String SELECT = "SELECT id, nome FROM aeroportos";
    private static final String FIND_BY_NOME = "SELECT id, nome FROM aeroportos where LOWER(nome) LIKE ? OR LOWER(id) LIKE ?";
    private static final String INSERT = "INSERT INTO aeroportos (id, nome) VALUES(?, ?)";
    
    private Connection conexao;
    
    
    @Inject
    public AeroportoDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public List<Aeroporto> todos() {
        return buscar(SELECT);
    }

    @Override
    public List<Aeroporto> buscarPorNome(String nome) {
        return buscar(
                FIND_BY_NOME, 
                LIKE_FILTER.replace("__text__", nome).toLowerCase(),
                LIKE_FILTER.replace("__text__", nome).toLowerCase());
    }
    
    
    private List<Aeroporto> buscar(String query, Object ... params) {
        
        List<Aeroporto> aeroportos = new ArrayList<>();
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(query);
            
            if (params != null) {
                
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                Aeroporto aeroporto = new Aeroporto(result.getString("id"), result.getString("nome"));
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
    public void insert(Aeroporto aeroporto) {
        try {
            
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            
            statement.setString(1, aeroporto.getId());
            statement.setString(2, aeroporto.getNome());
            
            statement.execute();
            statement.close();
            
            Logger.getLogger(AeroportoDaoJdbc.class.getName() + " -> INSERT : ").log(Level.INFO, aeroporto.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
