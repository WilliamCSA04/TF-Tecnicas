/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseane Wichrowski
 */
public class PassagensDaoJdbc implements PassagensDao {

    private Connection conexao;
    private static final String SELECT = "SELECT * FROM passagens";
    
    public PassagensDaoJdbc(Connection connection) {
        this.conexao=connection;
    }
    
    public List<Passagem> todos(){
        List<Passagem> passagens = new ArrayList<>();

        try {

            PreparedStatement statement = conexao.prepareStatement(SELECT);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Passagem passagem = new Passagem(result.getString("id"), result.getString("origem"), result.getString("destino"), result.getString("data_embarque"), result.getString("passageiro_id"), result.getString("localizador"));
                passagens.add(passagem);
            }

            statement.close();

            return passagens;

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return passagens;
    }
    
    //Testar
    @Override
    public Passagem buscarPassagem(String id){
        
        try {
            Passagem p;
            PreparedStatement statement = conexao.prepareStatement(SELECT + " where id = ?");
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            p = new Passagem(result.getString("id"), result.getString("origem"), result.getString("destino"), result.getString("data_embarque"), result.getString("passageiro_id"), result.getString("localizador"));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PassagensDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
