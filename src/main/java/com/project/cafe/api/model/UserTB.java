package com.project.cafe.api.model;

import com.project.cafe.api.util.ConstantsTableNames;
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = ConstantsTableNames.USER_TB)
public class UserTB extends BaseEntityTB implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @Column(name = "us_name", nullable = false, length = 100)
  private String name;

  @NotNull
  @Column(name = "us_last_name", nullable = false, length = 100)
  private String lastName;

  @NotNull
  @Column(name = "us_mail", nullable = false, length = 100)
  private String mail;

  @NotNull
  @Column(name = "us_password", nullable = false, length = 100)
  private String password;

  @NotNull
  @Column(name = "us_receive_newsletter", nullable = false)
  private boolean receiveNewsletter;
}
