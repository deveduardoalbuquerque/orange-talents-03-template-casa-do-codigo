package br.com.zupacademy.eduardoalbuquerque.casadocodigo.cliente.validadores;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {VerificaPaisEstadoValidator.class})
public @interface VerificaPaisEstado {

    String message() default "Estado não pode ser Nulo";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
