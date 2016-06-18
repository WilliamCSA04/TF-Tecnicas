package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passageiro;
import com.google.inject.Inject;
import java.sql.Connection;
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

    private Connection conexao;

    @Inject
    public PassageirosDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Passageiro> todos() {
        List<Passageiro> aeroportos = new ArrayList<>();

        try {

            PreparedStatement statement = conexao.prepareStatement(SELECT);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                GregorianCalendar dataNascimento = new GregorianCalendar();
                dataNascimento.setTime(result.getTime("data_nascimento"));
                Passageiro passageiro = new Passageiro(result.getInt("id"), result.getString("nome"), result.getString("sobrenome"), result.getString("genero"), dataNascimento, result.getString("email"), result.getString("rg"), result.getString("cpf"), result.getString("passaporte"), result.getString("senha"));
                aeroportos.add(passageiro);
            }

            statement.close();

            return aeroportos;

        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aeroportos;
    }
    
    public boolean checarEmail(String email, String senha){
        
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
