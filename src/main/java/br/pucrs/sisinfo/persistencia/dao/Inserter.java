package br.pucrs.sisinfo.persistencia.dao;

public interface Inserter<T> {
    
    void inserir(T t);
    
}
