package mx.edu.utez.easyHost.validacion.anotaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.edu.utez.easyHost.validacion.validador.ValidarTextoGlobalValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidarTextoGlobalValidator.class)
public @interface ValidarTextoGlobal {
    String message() default "Texto inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
