package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Rota;
import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RotaDaoJdbc implements RotaDao{
    
    private static final String INSERT = "INSERT INTO rotas (origem, destino) VALUES (?, ?)";
    
    private final Connection conexao;
    
    @Inject
    public RotaDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void insert(Rota rota) {
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            
            statement.setString(1, rota.getOrigem());
            statement.setString(2, rota.getDestino());
            
            statement.execute();
            statement.close();
            
            Logger.getLogger(RotaDaoJdbc.class.getName() + " -> INSERT : ").log(Level.INFO, rota.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(RotaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
