package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import java.util.List;

public interface AeroportoDao extends Inserter<Aeroporto>{
    
    List<Aeroporto> todos();
    List<Aeroporto> buscarPorNome(String nome);
    String buscarPorID(String id);
}
