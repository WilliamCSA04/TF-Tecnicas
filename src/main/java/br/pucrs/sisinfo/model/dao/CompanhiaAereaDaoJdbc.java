package br.pucrs.sisinfo.model.dao;

import br.pucrs.sisinfo.model.domain.CompanhiaAerea;
import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompanhiaAereaDaoJdbc implements CompanhiaAereaDao{
    
    private static final String INSERT = "INSERT INTO companhias_aereas (nome, identificador) VALUES(?, ?)";
    
    private Connection conexao;

    @Inject
    public CompanhiaAereaDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void inserir(CompanhiaAerea companhia) {
        try {
            
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            
            statement.setString(1, companhia.getNome());
            statement.setString(2, companhia.getIdentificador());
            
            statement.execute();
            statement.close();
            
            Logger.getLogger(getClass().getName() + " -> INSERT : ").log(Level.INFO, companhia.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
