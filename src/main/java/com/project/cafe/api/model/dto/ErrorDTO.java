package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {

  @JsonProperty(value = "class")
  private String clazz;

  private String method;
  private String line;
  private String message;
  private String details;
}
