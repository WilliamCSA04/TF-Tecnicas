package br.pucrs.sisinfo.persistencia.seeding.parsing;

public interface LineParser<T> {
    
    T parse(String line);
    
}
