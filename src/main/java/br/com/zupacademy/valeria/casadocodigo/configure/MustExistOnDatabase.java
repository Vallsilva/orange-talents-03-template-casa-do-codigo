package br.com.zupacademy.valeria.casadocodigo.configure;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {MustExistOnDatabaseValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface MustExistOnDatabase {

    String message() default "Valor não existe no banco!";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldName();
    Class<?> domainClass();
}
