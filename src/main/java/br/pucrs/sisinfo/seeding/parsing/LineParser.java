package br.pucrs.sisinfo.seeding.parsing;

public interface LineParser<T> {
    
    T parse(String line);
    
}
