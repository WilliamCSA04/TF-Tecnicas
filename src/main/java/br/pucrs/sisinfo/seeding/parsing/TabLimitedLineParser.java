package br.pucrs.sisinfo.seeding.parsing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class TabLimitedLineParser implements LineParser<Optional<List<String>>>{
    
    private String filePathString;
   
    @Override
    public Optional<List<String>> parse(String line) {
        String[] columns = line.split("\\t");
        return Optional.of(Arrays.asList(columns));
    }
    
}
