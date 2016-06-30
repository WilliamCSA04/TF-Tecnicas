package br.pucrs.sisinfo.persistencia.dao;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.modelo.Voo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public interface VooDao extends Inserter<Voo>{
    List<Voo> buscarPorData(GregorianCalendar data);
    List<Voo> buscarPorData(Aeroporto origem, GregorianCalendar data);
    Calendar buscarDataPorID(int id);
    int buscarRota(int id);
    int buscarMapaPorID(int id);

    
}
