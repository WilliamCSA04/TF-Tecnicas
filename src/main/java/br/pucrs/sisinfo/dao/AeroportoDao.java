package br.pucrs.sisinfo.dao;

import br.pucrs.sisinfo.model.Aeroporto;
import java.util.List;

public interface AeroportoDao extends Inserter<Aeroporto>{
    
    List<Aeroporto> todos();
    List<Aeroporto> buscarPorNome(String nome);
    
}
