package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.modelo.Voo;

import java.util.*;

public class PesquisaController {

    public List<Voo> buscaVoosPorData(Optional<GregorianCalendar> data) {
        
        Random randomGenerator = new Random();
        
        Integer totalFlights = randomGenerator.nextInt(150);
        
        List<Voo> voos = new ArrayList<>();
        
        for (int i = 0; i < totalFlights; i++) {
            voos.add(new Voo("Voo " + i));
        }
        
        return voos;

    }

}
