/* Autogenerated file. Do not edit manually. */

package com.xbidi.spring.content.example.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@AllArgsConstructor
public class ExampleInputDTOValidator
    implements ConstraintValidator<ExampleInputDTOConstraint, ExampleInputDTO> {

  @Override
  public void initialize(ExampleInputDTOConstraint constraintAnnotation) {
    // empty
  }

  @Override
  public boolean isValid(
      ExampleInputDTO exampleInputDTO, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
