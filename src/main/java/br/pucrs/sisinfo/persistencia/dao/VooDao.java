package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Voo;
import java.util.GregorianCalendar;
import java.util.List;


public interface VooDao extends Inserter<Voo>{
    List<Voo> buscarPorData(GregorianCalendar data);
}
