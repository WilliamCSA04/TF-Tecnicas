package br.pucrs.sisinfo.model.seeding.insertions;

import br.pucrs.sisinfo.model.dao.AeroportoDao;
import br.pucrs.sisinfo.model.dao.Inserter;
import br.pucrs.sisinfo.model.domain.Aeroporto;
import br.pucrs.sisinfo.model.seeding.parsing.AeroportoLineParser;
import br.pucrs.sisinfo.model.seeding.parsing.LineParser;
import com.google.inject.Inject;

public class AeroportoFileSeed implements FileSeed<Aeroporto>{
    
    private static final String FILE_PATH = "src/main/java/resources/seed/airports.dat";
    private final LineParser<Aeroporto> parser; 
    private final AeroportoDao dao;
    
    @Inject
    public AeroportoFileSeed(AeroportoLineParser parser, AeroportoDao dao) {
        this.parser = parser;
        this.dao = dao;
    }
    
    @Override
    public String filePath() {
        return FILE_PATH;
    }

    @Override
    public LineParser<Aeroporto> parser() {
        return parser;
    }

    @Override
    public Inserter inserter() {
        return dao;
    }
    
}
