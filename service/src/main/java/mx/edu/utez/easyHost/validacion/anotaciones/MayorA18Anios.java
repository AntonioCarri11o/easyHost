package mx.edu.utez.easyHost.validacion.anotaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.edu.utez.easyHost.validacion.validador.MayorA18AniosValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MayorA18AniosValidator.class)
public @interface MayorA18Anios {
    String message() default "Fecha inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
