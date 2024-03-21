package mx.edu.utez.easyHost.validacion.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import mx.edu.utez.easyHost.utilidades.Utilidades;
import mx.edu.utez.easyHost.validacion.anotaciones.FechaActual;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
public class FechaActualValidator implements ConstraintValidator<FechaActual, String> {
    @Override
    public boolean isValid(String fechaTexto, ConstraintValidatorContext contexto) {
        if (!esFechaValida(fechaTexto)) {
            return false;
        }
        Date fecha;
        try {
            fecha = Utilidades.textoAFecha(fechaTexto);
            return !esFechaFutura(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean esFechaFutura(Date fecha) {
        return fecha.after(Calendar.getInstance().getTime());
    }

    private boolean esFechaValida(String fechaCadena) {
        if (fechaCadena == null) {
            return false;
        }
        return Utilidades.esFormatoValidoFecha(fechaCadena);
    }
}
