package br.pucrs.sisinfo.app.config.guice;

import br.pucrs.sisinfo.negocio.services.interpretadores.Interpretador;
import br.pucrs.sisinfo.negocio.services.interpretadores.InterpretadorDeDataBrasileira;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.Optional;
import br.pucrs.sisinfo.app.config.guice.providers.ConnectionProvider;
import br.pucrs.sisinfo.negocio.services.VooService;
import br.pucrs.sisinfo.negocio.services.VooServiceFacade;
import br.pucrs.sisinfo.persistencia.dao.AeroportoDao;
import br.pucrs.sisinfo.persistencia.dao.AeroportoDaoJdbc;
import br.pucrs.sisinfo.persistencia.dao.PassageirosDao;
import br.pucrs.sisinfo.persistencia.dao.PassageirosDaoJdbc;
import br.pucrs.sisinfo.persistencia.dao.RotaDao;
import br.pucrs.sisinfo.persistencia.dao.RotaDaoJdbc;
import br.pucrs.sisinfo.persistencia.dao.VooDao;
import br.pucrs.sisinfo.persistencia.dao.VooDaoJdbc;
import com.google.inject.Scopes;

public class GuiceConfig extends AbstractModule{
   
    @Override
    protected void configure() {
        
        bind(new TypeLiteral<Interpretador<Optional<GregorianCalendar>>>() {})
                .annotatedWith(Names.named("interpretadorData"))
                .to(InterpretadorDeDataBrasileira.class);
        
        bind(Connection.class)
                .toProvider(ConnectionProvider.class)
                .in(Scopes.SINGLETON);
        
        bind(VooService.class)
                .to(VooServiceFacade.class);
        
        bind(PassageirosDao.class)
                .to(PassageirosDaoJdbc.class);
        
        bind(AeroportoDao.class)
                .to(AeroportoDaoJdbc.class);
        
        bind(VooDao.class)
                .to(VooDaoJdbc.class);
        
        bind(RotaDao.class)
                .to(RotaDaoJdbc.class);
                
    }
    
   
}
