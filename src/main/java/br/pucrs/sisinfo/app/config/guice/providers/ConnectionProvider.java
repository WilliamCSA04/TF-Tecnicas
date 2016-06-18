package br.pucrs.sisinfo.app.config.guice.providers;

import com.google.inject.Provider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider implements Provider<Connection>{

    @Override
    public Connection get() {
        try {
            
            return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/tftecnicas", "tftecnicas", "tftecnicas");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } 
    }
    
}
