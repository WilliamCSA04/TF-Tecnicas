package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.domain.Voo;
import java.util.GregorianCalendar;
import java.util.List;

public interface VooDao extends CrudDao<Voo>{
    List<Voo> buscarPorData(GregorianCalendar data);
}
