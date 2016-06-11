package br.pucrs.sisinfo.seeding.parsing;

import br.pucrs.sisinfo.model.Aeroporto;

public class AeroportoLineParser implements LineParser<Aeroporto> {
    
    private static final String TAB = "\\t";
    private static final int IDENTIFICADOR_INDEX = 0;
    private static final int NOME_INDEX = 3;
    
    
    @Override
    public Aeroporto parse(String line) {
        
        String[] columns = line.split(TAB);
        
        return new Aeroporto(columns[NOME_INDEX], columns[IDENTIFICADOR_INDEX]);
                
    }
    
}
