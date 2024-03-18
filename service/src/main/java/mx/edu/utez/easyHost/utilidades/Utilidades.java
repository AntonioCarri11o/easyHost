package mx.edu.utez.easyHost.utilidades;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
    public static Date textoAFecha(String fechaCadena) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.parse(fechaCadena);
    }
    public static boolean esFormatoValidoFecha(String fechaCadena) {
        Pattern patron = Pattern.compile("^([0-9]{4}-[0-9]{2}-[0-9]{2})$");
        Matcher comparador = patron.matcher(fechaCadena);
        return comparador.matches();
    }
    public static List<String> obtenerErrores(ConstraintViolationException errores) {
        Set<ConstraintViolation<?>> excepciones = errores.getConstraintViolations();
        List<String> mensajesDeError = new ArrayList<>();
        for (ConstraintViolation<?> excepion : excepciones) {
            mensajesDeError.add(excepion.getMessage());
        }
        return mensajesDeError;

    }
}
