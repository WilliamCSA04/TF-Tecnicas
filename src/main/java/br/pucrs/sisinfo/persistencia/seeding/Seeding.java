package br.pucrs.sisinfo.persistencia.seeding;

import br.pucrs.sisinfo.persistencia.seeding.insertions.FileSeed;
import br.pucrs.sisinfo.persistencia.seeding.parsing.SimpleFileReader;
import com.google.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seeding {
    
    private static final String SEED_FILE_BASE_PATH = "src/main/java/resources/seed/%s.dat";
    public static final String SEPARATOR = "\t";
    
    public static String seedingPathFor(String fileName) {
        return String.format(SEED_FILE_BASE_PATH, fileName);
    }
    
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
                        .forEach(seed.inserter()::insert);
                
            } catch (IOException ex) {
                Logger.getLogger(Seeding.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
    }
    
}
