/* Autogenerated file. Do not edit manually. */

package com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.input;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExampleInputDTOValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleInputDTOConstraint {
  String message() default "El formato del 'InputDTO' no es válido";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
