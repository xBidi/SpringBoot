package com.xbidi.spring.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
  @ApiImplicitParam(
      name = "page",
      required = true,
      defaultValue = "0",
      dataTypeClass = Integer.class,
      paramType = "query",
      value = "Results page you want to retrieve (0..N)"),
  @ApiImplicitParam(
      name = "size",
      required = true,
      defaultValue = "10",
      dataTypeClass = Integer.class,
      paramType = "query",
      value = "Number of records per page."),
  @ApiImplicitParam(
      name = "sort",
      allowMultiple = true,
      dataTypeClass = String.class,
      paramType = "query",
      value =
          "Sorting criteria in the format of this examples: (id,ASC | id,DESC) Default sort order is ascending. Multiple sort criteria are supported.")
})
public @interface ApiPageable {}
