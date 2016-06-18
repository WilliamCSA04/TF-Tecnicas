package br.pucrs.sisinfo.persistencia.seeding.parsing;

import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class SimpleFileReader implements FileReader<String> {
   
    private Path filePath;
 
    @Override
    public List<String> readFile() throws IOException{
        return Files
                .lines(filePath, Charset.forName("ISO-8859-1"))
                .filter(line -> line.charAt(0) != '#')
                .collect(Collectors.toList()); 
    }
   

    @Override
    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }

}
