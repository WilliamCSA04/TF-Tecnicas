package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.domain.Voo;
import java.util.GregorianCalendar;
import java.util.List;

public interface VooDao{
    List<Voo> buscarPorData(GregorianCalendar data);
}
