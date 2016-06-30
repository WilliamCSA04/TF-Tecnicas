package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passagem;

public interface PassagensDao {
    public Passagem buscarPassagem(String id);

    public int buscarVoo(String id);
}
