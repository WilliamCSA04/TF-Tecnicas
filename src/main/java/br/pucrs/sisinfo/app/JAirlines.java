package br.pucrs.sisinfo.app;

import br.pucrs.sisinfo.config.guice.GuiceConfig;
import br.pucrs.sisinfo.seeding.insertions.AeroportoFileSeed;
import br.pucrs.sisinfo.seeding.insertions.CompanhiaAereaFileSeed;
import br.pucrs.sisinfo.seeding.insertions.Seeding;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;


public class JAirlines {
    
    public Connection connection;
    
    @Inject
    public JAirlines(Connection connection) {
        this.connection = connection;
    }
    
    public static void main(String[] args) throws IOException {
        
        Injector injector = Guice.createInjector(new GuiceConfig());
        
        AeroportoFileSeed aeroSeed = injector.getInstance(AeroportoFileSeed.class);
        CompanhiaAereaFileSeed companhiaSeed = injector.getInstance(CompanhiaAereaFileSeed.class);
        
        Seeding seeding = injector.getInstance(Seeding.class);
        
        seeding.setSeeds(Arrays.asList(aeroSeed, companhiaSeed));
        
        seeding.seed();        
    }

}
