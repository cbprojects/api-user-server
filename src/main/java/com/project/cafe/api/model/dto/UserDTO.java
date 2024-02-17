package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO extends BaseDTO {

  private String name;
  private String lastName;
  private String mail;
  private String password;
  private boolean receiveNewsletter;

  @JsonIgnore
  public String getFullName() {
    return this.name + this.lastName;
  }
}
