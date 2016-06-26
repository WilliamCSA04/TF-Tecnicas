package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passageiro;
import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassageirosDaoJdbc {

    private static final String SELECT = "SELECT id, nome, sobrenome, genero, data_nascimento, endereco, email, rg, cpf, passaporte, senha FROM passageiros";
    private static final String INSERT = "INSERT INTO Passageiros (nome, sobrenome, genero, data_nascimento, endereco, email, rg, cpf, passaporte, senha) values(?,?,?,?,?,?,?,?,?,?,?)";
    
    private Connection conexao;

    @Inject
    public PassageirosDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }

    public PassageirosDaoJdbc() {
        
    }

    public List<Passageiro> todos() {
        List<Passageiro> aeroportos = new ArrayList<>();

        try {

            PreparedStatement statement = conexao.prepareStatement(SELECT);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                GregorianCalendar dataNascimento = new GregorianCalendar();
                dataNascimento.setTime(result.getTime("data_nascimento"));
                Passageiro passageiro = new Passageiro(result.getInt("id"), result.getString("nome"), result.getString("sobrenome"), result.getString("genero"), dataNascimento, result.getString("endereco"), result.getString("email"), result.getString("rg"), result.getString("cpf"), result.getString("passaporte"), result.getString("senha"));
                aeroportos.add(passageiro);
            }

            statement.close();

            return aeroportos;

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aeroportos;
    }
    
    public void insert(Passageiro passageiros){
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement(INSERT);
            
            statement.setString(1, passageiros.getNome());
            statement.setString(2, passageiros.getSobrenome());
            statement.setString(3, passageiros.getGenero());
            statement.setDate(4, (Date) passageiros.getDataNascimento().getTime());
            statement.setString(5, passageiros.getEndereco());
            statement.setString(6, passageiros.getEmail());
            statement.setString(7, passageiros.getRg());
            statement.setString(8, passageiros.getCpf());
            statement.setString(9, passageiros.getPassaporte());
            statement.setString(10, passageiros.getSenha());
            
            
            statement.execute();
            statement.close();
            
            Logger.getLogger(getClass().getName() + " -> INSERT : ").log(Level.INFO, passageiros.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(PassageirosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checarLogin(String email, String senha){
        
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT senha FROM passageiros WHERE email = " + email);
            ResultSet result = statement.executeQuery();
            if(result.getString("senha").equals(senha)) return true;
        } catch (SQLException ex) {
            Logger.getLogger(PassageirosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

}
