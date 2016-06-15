package br.pucrs.sisinfo.services;

import br.pucrs.sisinfo.model.domain.Voo;

import java.util.GregorianCalendar;
import java.util.List;

public interface VooService {

    List<Voo> buscaPorData(GregorianCalendar data);

}
