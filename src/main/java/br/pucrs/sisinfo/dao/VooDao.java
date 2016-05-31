package br.pucrs.sisinfo.dao;

import br.pucrs.sisinfo.model.Voo;
import java.util.GregorianCalendar;
import java.util.List;

public interface VooDao extends CrudDao<Voo>{
    List<Voo> buscarPorData(GregorianCalendar data);
}
