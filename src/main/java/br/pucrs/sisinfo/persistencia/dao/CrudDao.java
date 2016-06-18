package br.pucrs.sisinfo.persistencia.dao;

import java.util.List;

public interface CrudDao<T> {
    
    int inserir(T objeto);
    boolean atualizar(T objeto);
    boolean deletar(T objeto);
    List<T> todos();
    T buscarPorId(int id);
    
}
