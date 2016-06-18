package br.pucrs.sisinfo.persistencia.seeding.parsing;

import br.pucrs.sisinfo.persistencia.modelo.Aeroporto;
import br.pucrs.sisinfo.persistencia.seeding.Seeding;

public class AeroportoLineParser implements LineParser<Aeroporto> {
    
    private static final int IDENTIFICADOR_INDEX = 0;
    private static final int NOME_INDEX = 3;
    
    
    @Override
    public Aeroporto parse(String line) {
        
        String[] columns = line.split(Seeding.SEPARATOR);
        
        return new Aeroporto(columns[IDENTIFICADOR_INDEX], columns[NOME_INDEX]);
                
    }
    
}
