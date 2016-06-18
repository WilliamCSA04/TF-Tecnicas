package br.pucrs.sisinfo.negocio.services.interpretadores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

public class InterpretadorDeDataBrasileira implements Interpretador<Optional<GregorianCalendar>> {

    public static final String FORMATO_DE_DATA_BRASILEIRO = "dd/MM/yyyy";

    @Override
    public Optional<GregorianCalendar> interpretar(String padrao){

        DateFormat formatoData = new SimpleDateFormat(FORMATO_DE_DATA_BRASILEIRO);
        formatoData.setLenient(false);

        try {
            
            Date dataConvertida = formatoData.parse(padrao);

            GregorianCalendar dataObtida = new GregorianCalendar();
            dataObtida.setTime(dataConvertida);

            return Optional.of(dataObtida);

        } catch (ParseException e) {
            return Optional.empty();
        }

    }

}
