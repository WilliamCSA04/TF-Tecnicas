package br.pucrs.sisinfo.config.guice;

import br.pucrs.sisinfo.interpretadores.Interpretador;
import br.pucrs.sisinfo.interpretadores.InterpretadorDeDataBrasileira;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.Optional;
import br.pucrs.sisinfo.config.providers.ConnectionProvider;
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
                
    }
    
   
}