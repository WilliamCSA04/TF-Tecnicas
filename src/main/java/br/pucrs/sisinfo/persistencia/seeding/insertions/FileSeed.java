package br.pucrs.sisinfo.persistencia.seeding.insertions;

import br.pucrs.sisinfo.persistencia.dao.Inserter;
import br.pucrs.sisinfo.persistencia.seeding.parsing.LineParser;

public interface FileSeed<T> {
    
    String filePath();
    LineParser<T> parser();
    Inserter inserter();
    
}
