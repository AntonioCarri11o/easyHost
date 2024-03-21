package mx.edu.utez.easyHost.validacion.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.NoArgsConstructor;
import mx.edu.utez.easyHost.validacion.anotaciones.ValidarTextoGlobal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class ValidarTextoGlobalValidator implements ConstraintValidator<ValidarTextoGlobal, String> {

    @Override
    public boolean isValid(String texto, ConstraintValidatorContext contexto) {
        if (esTextoNulo(texto)) {
            return false;
        }
        return !esTextoEnBlanco(texto) ||
                !esTextoConDemasiadosEspaciosIntermedios(texto) ||
                !esTextoConEspaciosAlInicioOFinal(texto) ||
                !esTextoConDemasiadosEspaciosIntermedios(texto);
    }

    private boolean esTextoNulo(String texto) {
        return texto == null;
    }

    private boolean esTextoEnBlanco(String texto) {
        return texto == "" || texto == " " || texto.isEmpty() || texto.isBlank();
    }

    private boolean esTextoConEspaciosAlInicioOFinal(String texto) {
        Pattern patron = Pattern.compile("^\\\\S.*\\\\S$");
        Matcher comparador = patron.matcher(texto);
        return comparador.matches();
    }

    private boolean esTextoConDemasiadosEspaciosIntermedios(String texto) {
        Pattern patron = Pattern.compile("\\\\b\\\\S+\\\\s+(\\\\S+\\\\s+)*\\\\S+\\\\b");
        Matcher comparador = patron.matcher(texto);
        return comparador.matches();
    }
}
