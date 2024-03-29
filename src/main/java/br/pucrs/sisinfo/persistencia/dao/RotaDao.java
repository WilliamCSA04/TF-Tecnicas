package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Rota;

public interface RotaDao extends Inserter<Rota>{
    
    Rota buscarPorOrigem(String idOrigem);
    String[] buscarOrigemDestino(int idRota);
    
}
