package br.pucrs.sisinfo.interpretadores;

import br.pucrs.sisinfo.exceptions.InterpretadorException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterpretadorDeDataBrasileira implements Interpretador<GregorianCalendar> {

    public static final String FORMATO_DE_DATA_BRASILEIRO = "dd/MM/yyyy";

    @Override
    public GregorianCalendar interpretar(String padrao) throws InterpretadorException{

        DateFormat formatoData = new SimpleDateFormat(FORMATO_DE_DATA_BRASILEIRO);
        formatoData.setLenient(false);

        try {

            Date dataConvertida = formatoData.parse(padrao);

            GregorianCalendar dataObtida = new GregorianCalendar();
            dataObtida.setTime(dataConvertida);

            return dataObtida;

        } catch (ParseException e) {
            throw new InterpretadorException();
        }

    }

}
