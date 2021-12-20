/* Autogenerated file. Do not edit manually. */

package com.diegotobalina.framework.customizable.entities.example.infrastructure.controller;

import com.diegotobalina.framework.customizable.entities.example.application.ExampleService;
import com.diegotobalina.framework.customizable.entities.example.application.usecase.CreateExampleUseCase;
import com.diegotobalina.framework.customizable.entities.example.application.usecase.DeleteExampleUseCase;
import com.diegotobalina.framework.customizable.entities.example.application.usecase.FindExampleUseCase;
import com.diegotobalina.framework.customizable.entities.example.application.usecase.UpdateExampleUseCase;
import com.diegotobalina.framework.customizable.entities.example.domain.Example;
import com.diegotobalina.framework.customizable.entities.example.domain.ExampleMapper;
import com.diegotobalina.framework.customizable.entities.example.domain.ExampleSpecification;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.input.ExampleInputDTO;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.output.BaseExampleOutputDTO;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.repository.ExampleRepository;
import com.diegotobalina.framework.provided.search.SpecificationsBuilder;
import com.diegotobalina.framework.provided.responses.StyleEnum;
import com.diegotobalina.framework.provided.swagger.ApiPageable;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@Validated
@RestController
@AllArgsConstructor
@Api(tags = "Example")
@RequestMapping("/api/v0/examples")
public class ExampleController {

  private final FindExampleUseCase findExampleUseCase;
  private final CreateExampleUseCase createUseCase;
  private final UpdateExampleUseCase updateUseCase;
  private final DeleteExampleUseCase deleteUseCase;
  private final ExampleRepository exampleRepository;
  private final ExampleService exampleService;

  @GetMapping("{id}")
  @Transactional(rollbackFor = Exception.class, readOnly = true)
  public BaseExampleOutputDTO findById(
      @RequestParam(name = "style", required = false, defaultValue = "BASE") StyleEnum style,
      @PathVariable("id") long id) {
    Example foundExample = findExampleUseCase.findById(id, exampleService, exampleRepository);
    return ExampleMapper.INSTANCE.toExampleOutputDTO(style, foundExample);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional(rollbackFor = Exception.class)
  public BaseExampleOutputDTO create(
      @RequestParam(name = "style", required = false, defaultValue = "BASE") StyleEnum style,
      @RequestBody @Valid ExampleInputDTO exampleInputDTO) {
    Example example = ExampleMapper.INSTANCE.toExample(exampleInputDTO);
    Example createdExample = createUseCase.create(example, exampleService, exampleRepository);
    return ExampleMapper.INSTANCE.toExampleOutputDTO(style, createdExample);
  }

  @PutMapping("{id}")
  @Transactional(rollbackFor = Exception.class)
  public BaseExampleOutputDTO update(
      @RequestParam(name = "style", required = false, defaultValue = "BASE") StyleEnum style,
      @PathVariable("id") long id,
      @RequestBody @Valid ExampleInputDTO exampleInputDTO) {
    Example updatedExample =
        updateUseCase.update(id, exampleInputDTO, exampleService, exampleRepository);
    return ExampleMapper.INSTANCE.toExampleOutputDTO(style, updatedExample);
  }

  @DeleteMapping("{id}")
  @Transactional(rollbackFor = Exception.class)
  public BaseExampleOutputDTO delete(
      @RequestParam(name = "style", required = false, defaultValue = "BASE") StyleEnum style,
      @PathVariable("id") long id) {
    Example deletedExample = deleteUseCase.delete(id, exampleService, exampleRepository);
    return ExampleMapper.INSTANCE.toExampleOutputDTO(style, deletedExample);
  }

  @ApiPageable
  @GetMapping("search")
  @SuppressWarnings("unchecked")
  @Transactional(rollbackFor = Exception.class, readOnly = true)
  public Page<BaseExampleOutputDTO> search(
      @RequestParam(name = "style", required = false, defaultValue = "BASE") StyleEnum style,
      @RequestParam(value = "search", required = false) String search,
      @PageableDefault(sort = "id") Pageable pageable)
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
          InstantiationException, IllegalAccessException {
    Specification<Example> spec =
        (Specification<Example>)
            new SpecificationsBuilder().build(search, ExampleSpecification.class);
    Page<Example> examples = exampleRepository.findAll(spec, pageable);
    return ExampleMapper.INSTANCE.toExampleOutputDTOS(style, pageable, examples);
  }
}
