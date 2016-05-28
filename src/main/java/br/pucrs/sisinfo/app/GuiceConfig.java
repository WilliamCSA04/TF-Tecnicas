package br.pucrs.sisinfo.app;

import br.pucrs.sisinfo.interpretadores.Interpretador;
import br.pucrs.sisinfo.interpretadores.InterpretadorDeDataBrasileira;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import java.util.GregorianCalendar;
import java.util.Optional;


public class GuiceConfig extends AbstractModule{

    @Override
    protected void configure() {
        
        bind(new TypeLiteral<Interpretador<Optional<GregorianCalendar>>>() {})
                .annotatedWith(Names.named("interpretadorData"))
                .to(InterpretadorDeDataBrasileira.class);
        
    }
    
   
}
