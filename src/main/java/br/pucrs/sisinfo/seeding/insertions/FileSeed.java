package br.pucrs.sisinfo.seeding.insertions;

import br.pucrs.sisinfo.dao.Inserter;
import br.pucrs.sisinfo.seeding.parsing.LineParser;

public interface FileSeed<T> {
    
    String filePath();
    LineParser<T> parser();
    Inserter inserter();
    
}
