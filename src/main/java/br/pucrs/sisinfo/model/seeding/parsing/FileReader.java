package br.pucrs.sisinfo.model.seeding.parsing;

import java.io.IOException;
import java.util.List;


public interface FileReader<T> {
    
    public List<T> readFile() throws IOException;
    void setFilePath(String filePath);
    
}
