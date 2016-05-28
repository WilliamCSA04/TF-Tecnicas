package br.pucrs.sisinfo.services;

import br.pucrs.sisinfo.model.Voo;

import java.util.Collection;
import java.util.GregorianCalendar;

public interface VooService {

    Collection<Voo> buscaTodosPorData(GregorianCalendar data);

}
