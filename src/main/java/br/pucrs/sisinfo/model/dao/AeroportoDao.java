package br.pucrs.sisinfo.model.dao;

import br.pucrs.sisinfo.model.domain.Aeroporto;
import java.util.List;

public interface AeroportoDao extends Inserter<Aeroporto>{
    
    List<Aeroporto> todos();
    List<Aeroporto> buscarPorNome(String nome);
    
}
