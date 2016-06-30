package br.pucrs.sisinfo.persistencia.dao;

import com.google.inject.Inject;
import java.sql.Connection;


public class MapaAssentosDaoJdbc implements MapaAssentosDao{
    
    
    private Connection conexao;

    @Inject
    public MapaAssentosDaoJdbc(Connection conexao) {
        this.conexao = conexao;
    }
    
}
