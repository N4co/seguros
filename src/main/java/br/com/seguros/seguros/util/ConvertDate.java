package br.com.seguros.seguros.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (dateString != null) {
            return formato.parse(dateString);
        } else {
            return null;
        }
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }
}