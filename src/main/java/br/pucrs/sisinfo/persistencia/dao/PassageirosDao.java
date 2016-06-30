package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Passageiro;

public interface PassageirosDao extends Inserter<Passageiro>{

    public boolean checarLogin(String email, String senha);
    public Passageiro passageiroLogado(String email);
}
