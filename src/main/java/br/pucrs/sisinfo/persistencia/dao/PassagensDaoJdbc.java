/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Inject;
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
    private static final String INSERT = "INSERT INTO passagens (voo_id, passageiro_id, status) values (?,?,?)";
    
    @Inject
    public PassagensDaoJdbc(Connection connection) {
        this.conexao=connection;
    }
    
    public List<Passagem> todos(){
        List<Passagem> passagens = new ArrayList<>();

        try {

            PreparedStatement statement = conexao.prepareStatement(SELECT);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Passagem passagem = new Passagem(result.getInt("id"), result.getInt("voo_id"), result.getString("passageiro_id"), result.getString("status"));
                passagens.add(passagem);
            }

            statement.close();

            return passagens;

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return passagens;
    }
    
    @Override
    public Passagem buscarPassagem(String id){
        
        try {
            Passagem p;
            PreparedStatement statement = conexao.prepareStatement(SELECT + " where id = ?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet result = statement.executeQuery();
            result.next();
            p = new Passagem(result.getInt("id"), result.getInt("voo_id"), result.getString("passageiro_id"), result.getString("status"));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PassagensDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void registrarCompra(Passagem passagem){
        try {
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            statement.setInt(1, passagem.getVooID());
            statement.setString(2, passagem.getPassageiroID());
            statement.setString(3, passagem.getStatus());
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PassagensDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int buscarVoo(String id) {
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT voo_id FROM passagens WHERE id = ?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt("voo_id");
        } catch (SQLException ex) {
            Logger.getLogger(PassagensDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    @Override
    public void atualizarStatus(int id){
        try {
            PreparedStatement statement = conexao.prepareStatement("update passagens set status='Check-in ok' WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PassagensDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
