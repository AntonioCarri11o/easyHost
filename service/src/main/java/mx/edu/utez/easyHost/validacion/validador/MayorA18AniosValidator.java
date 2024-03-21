package mx.edu.utez.easyHost.validacion.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import mx.edu.utez.easyHost.utilidades.Utilidades;
import mx.edu.utez.easyHost.validacion.anotaciones.MayorA18Anios;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
public class MayorA18AniosValidator implements ConstraintValidator<MayorA18Anios, String> {
    @Override
    public boolean isValid(String fechaTexto, ConstraintValidatorContext contexto) {
        if (!esFechaValida(fechaTexto)) {
            return false;
        }
        Date fecha;
        try {
            fecha = Utilidades.textoAFecha(fechaTexto);
            return esMayorA18(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean esMayorA18(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.YEAR, -18);
        return fecha.before(calendario.getTime());

    }
    private boolean esFechaValida(String fechaCadena) {
        if(fechaCadena == null) {
            return false;
        }
        return Utilidades.esFormatoValidoFecha(fechaCadena);
    }
}
