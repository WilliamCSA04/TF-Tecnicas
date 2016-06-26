package br.pucrs.sisinfo.app.helper;

import java.io.UnsupportedEncodingException;


public class ApplicationHelper {
    
    public static String encodeString(String s) throws UnsupportedEncodingException{
        return new String(s.getBytes(), "UTF-8");
    }
    
}
