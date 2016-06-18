package br.pucrs.sisinfo.app;

import br.pucrs.sisinfo.app.config.guice.GuiceConfig;
import br.pucrs.sisinfo.persistencia.modelo.Rota;
import br.pucrs.sisinfo.persistencia.seeding.AeroportoFileSeed;
import br.pucrs.sisinfo.persistencia.seeding.Seeding;
import br.pucrs.sisinfo.persistencia.seeding.RotaFileSeed;
import br.pucrs.sisinfo.persistencia.seeding.parsing.RotaLineParser;
import br.pucrs.sisinfo.persistencia.seeding.parsing.SimpleFileReader;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Collectors;


public class JAirlines {
    
    public Connection connection;
    
    @Inject
    public JAirlines(Connection connection) {
        this.connection = connection;
    }
    
    public static void main(String[] args) throws IOException {
        
        Injector injector = Guice.createInjector(new GuiceConfig());
        
        AeroportoFileSeed aeroSeed = injector.getInstance(AeroportoFileSeed.class);
        RotaFileSeed rotaSeed = injector.getInstance(RotaFileSeed.class);
        
        Seeding seeding = injector.getInstance(Seeding.class);
                
        
//        SELECT o.nome, d.nome
//        FROM rotas 
//                
//        INNER JOIN aeroportos as o
//        ON o.id = rotas.origem
//        
//        INNER JOIN aeroportos as d
//        ON d.id = rotas.destino;
        
        
        Runnable background = new Runnable() {
            @Override
            public void run() {
                seeding.setSeeds(Arrays.asList(aeroSeed, rotaSeed));
        
                seeding.seed();        
            }
        };
        
        new Thread(background).start();
    }

}
