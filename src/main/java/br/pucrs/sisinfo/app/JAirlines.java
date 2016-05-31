package br.pucrs.sisinfo.app;

import br.pucrs.sisinfo.config.guice.GuiceConfig;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.sql.Connection;


public class JAirlines {
    
    public Connection connection;
    
    @Inject
    public JAirlines(Connection connection) {
        this.connection = connection;
    }
    
    public static void main(String[] args) {
        
        Injector injector = Guice.createInjector(new GuiceConfig());
        
        JAirlines airlines = injector.getInstance(JAirlines.class);
        JAirlines airlines2 = injector.getInstance(JAirlines.class);
        
        System.out.println(airlines.connection == airlines2.connection);
        
    }

}
