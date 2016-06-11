package br.pucrs.sisinfo.seeding.parsing;

import br.pucrs.sisinfo.model.CompanhiaAerea;

public class CompanhiaAereaLineParser implements LineParser<CompanhiaAerea>{
    
    private static final String TAB = "\\t";
    
    private static final int IDENTIFICADOR_INDEX = 0;
    private static final int NOME_INDEX = 1;

    @Override
    public CompanhiaAerea parse(String line) {
        String[] columns = line.split(TAB);
        
        return new CompanhiaAerea(columns[NOME_INDEX], columns[IDENTIFICADOR_INDEX]);
    }
    
}
