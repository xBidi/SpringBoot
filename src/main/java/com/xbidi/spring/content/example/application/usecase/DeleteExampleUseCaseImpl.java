/* Autogenerated file. Do not edit manually. */

package com.xbidi.spring.content.example.application.usecase;

import com.xbidi.spring.content.example.application.ExampleService;
import com.xbidi.spring.content.example.domain.Example;
import com.xbidi.spring.content.shared.anotation.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteExampleUseCaseImpl implements DeleteExampleUseCase {

  private ExampleService exampleService;
  private FindExampleUseCase findExampleUseCase;

  @Override
  public Example delete(long id) {
    Example example = findExampleUseCase.findById(id);
    exampleService.deleteById(id);
    return example;
  }
}
