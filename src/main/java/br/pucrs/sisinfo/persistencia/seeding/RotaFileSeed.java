package br.pucrs.sisinfo.persistencia.seeding;

import br.pucrs.sisinfo.persistencia.dao.Inserter;
import br.pucrs.sisinfo.persistencia.dao.RotaDao;
import br.pucrs.sisinfo.persistencia.dao.VooDao;
import br.pucrs.sisinfo.persistencia.modelo.Rota;
import br.pucrs.sisinfo.persistencia.seeding.insertions.FileSeed;
import br.pucrs.sisinfo.persistencia.seeding.parsing.LineParser;
import br.pucrs.sisinfo.persistencia.seeding.parsing.RotaLineParser;
import com.google.inject.Inject;

public class RotaFileSeed implements FileSeed<Rota>{
    
    RotaDao dao;
    LineParser<Rota> parser;
    
    @Inject
    public RotaFileSeed(RotaDao dao, RotaLineParser parser) {
        this.dao = dao;
        this.parser = parser;
    }
   
    @Override
    public String filePath() {
        return Seeding.seedingPathFor("routes");
    }

    @Override
    public LineParser<Rota> parser() {
        return new RotaLineParser();
    }

    @Override
    public Inserter inserter() {
        return dao;
    }
    
}
