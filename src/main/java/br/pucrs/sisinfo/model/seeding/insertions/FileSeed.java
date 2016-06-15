package br.pucrs.sisinfo.model.seeding.insertions;

import br.pucrs.sisinfo.model.dao.Inserter;
import br.pucrs.sisinfo.model.seeding.parsing.LineParser;

public interface FileSeed<T> {
    
    String filePath();
    LineParser<T> parser();
    Inserter inserter();
    
}
