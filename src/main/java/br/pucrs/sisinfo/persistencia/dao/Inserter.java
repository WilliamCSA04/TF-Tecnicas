package br.pucrs.sisinfo.persistencia.dao;

public interface Inserter<T> {
    
    void insert(T t);
    
}
