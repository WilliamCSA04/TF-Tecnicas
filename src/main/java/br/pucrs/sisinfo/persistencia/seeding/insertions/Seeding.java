package br.pucrs.sisinfo.persistencia.seeding.insertions;

import br.pucrs.sisinfo.persistencia.seeding.parsing.SimpleFileReader;
import com.google.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seeding {
    
    private List<FileSeed> seeds;
    private SimpleFileReader reader;
    
    @Inject
    public Seeding(SimpleFileReader reader) {
        this.reader = reader;
    }
    
    public void setSeeds(List<FileSeed> seeds) {
        this.seeds = seeds;
    }
    
    public void seed() {
        
        for(FileSeed seed : seeds) {
            
            reader.setFilePath(seed.filePath());
            
            try {
                
                reader
                        .readFile()
                        .stream()
                        .map(seed.parser()::parse)
                        .forEach(seed.inserter()::inserir);
                
            } catch (IOException ex) {
                Logger.getLogger(Seeding.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }
    
}
