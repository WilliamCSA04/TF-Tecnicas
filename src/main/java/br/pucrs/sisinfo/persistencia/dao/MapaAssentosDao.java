package br.pucrs.sisinfo.persistencia.dao;

public interface MapaAssentosDao {
    
    boolean[] poltronasOcupadas(int id);

   void atualizarPoltronas(boolean[] poltronas, int id);
    
}
