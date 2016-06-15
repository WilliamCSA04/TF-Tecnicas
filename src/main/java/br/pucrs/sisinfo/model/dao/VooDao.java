package br.pucrs.sisinfo.model.dao;

import br.pucrs.sisinfo.model.domain.Voo;
import java.util.GregorianCalendar;
import java.util.List;

public interface VooDao extends CrudDao<Voo>{
    List<Voo> buscarPorData(GregorianCalendar data);
}
