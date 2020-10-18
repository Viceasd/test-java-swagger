package io.swagger.api.util;

import io.swagger.model.Tarea;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JavaUtil {



    public static java.sql.Date stringToSqlDate(Tarea tarea) throws ParseException {
        String startDate= tarea.getFechaCreacion();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = sdf1.parse(startDate);
        return new Date(date.getTime());

    }
}
