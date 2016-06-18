package br.pucrs.sisinfo.negocio.services;

import br.pucrs.sisinfo.persistencia.domain.Voo;

import java.util.GregorianCalendar;
import java.util.List;

public interface VooService {

    List<Voo> buscaPorData(GregorianCalendar data);

}
