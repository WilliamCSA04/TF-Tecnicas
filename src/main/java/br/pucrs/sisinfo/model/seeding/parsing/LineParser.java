package br.pucrs.sisinfo.model.seeding.parsing;

public interface LineParser<T> {
    
    T parse(String line);
    
}
