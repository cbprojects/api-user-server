package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
