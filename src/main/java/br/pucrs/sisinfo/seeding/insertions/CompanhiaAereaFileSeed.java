package br.pucrs.sisinfo.seeding.insertions;

import br.pucrs.sisinfo.dao.CompanhiaAereaDao;
import br.pucrs.sisinfo.dao.Inserter;
import br.pucrs.sisinfo.model.CompanhiaAerea;
import br.pucrs.sisinfo.seeding.parsing.CompanhiaAereaLineParser;
import br.pucrs.sisinfo.seeding.parsing.LineParser;
import com.google.inject.Inject;

public class CompanhiaAereaFileSeed implements FileSeed<CompanhiaAerea> {
    
    private static final String FILE_PATH = "src/main/java/resources/seed/airlines.dat";
    
    private CompanhiaAereaLineParser parser;
    private CompanhiaAereaDao dao;

    @Inject
    public CompanhiaAereaFileSeed(CompanhiaAereaLineParser parser, CompanhiaAereaDao dao) {
        this.parser = parser;
        this.dao = dao;
    }
    
    @Override
    public String filePath() {
        return FILE_PATH;
    }

    @Override
    public LineParser<CompanhiaAerea> parser() {
        return parser;
    }

    @Override
    public Inserter inserter() {
        return dao;
    }
    
}
