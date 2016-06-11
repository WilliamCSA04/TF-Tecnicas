package br.pucrs.sisinfo.seeding.parsing;

import java.util.List;
import br.pucrs.sisinfo.model.CrudModel;
import com.google.inject.Inject;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

public class TabLimitedFileReader<T> implements FileReader<T> {
   
    private Path filePath;
    private LineParser<Optional<T>> parser;
    
    @Inject
    public TabLimitedFileReader(LineParser<Optional<T>> parser) {
        this.parser = parser;
    }
   
    @Override
    public List<T> readFile() throws IOException{
        return Files
                .lines(filePath, Charset.forName("ISO-8859-1"))
                .map(parser::parse)
                .filter(line -> line.isPresent())
                .map(lineOptional -> lineOptional.get())
                .collect(Collectors.toList()); 
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }

}
