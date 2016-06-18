package br.pucrs.sisinfo.persistencia.seeding.parsing;

import br.pucrs.sisinfo.persistencia.modelo.Rota;
import br.pucrs.sisinfo.persistencia.seeding.Seeding;
import java.util.Arrays;

public class RotaLineParser implements LineParser<Rota>{
    
    private static final int ORIGEM_INDEX = 1;
    private static final int DESTINO_INDEX = 2;

    @Override
    public Rota parse(String line) {
        
        String colunas [] = line.split(Seeding.SEPARATOR);
        
        System.out.println(Arrays.toString(colunas));
        
        return new Rota(colunas[ORIGEM_INDEX], colunas[DESTINO_INDEX]);
    }
    
}
