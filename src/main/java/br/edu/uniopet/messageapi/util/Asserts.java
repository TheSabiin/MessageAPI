package br.edu.uniopet.messageapi.util;

public class Asserts {

    public static void assertNull(Object o, String field){
        if (o == null || o.toString().equals("")){
            throw new NullPointerException(field);
        }
    }
}
