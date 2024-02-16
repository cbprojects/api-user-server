package com.project.cafe.api.model;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntityTB {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  @Column(name = "id", nullable = false, length = 19)
  private Long id;

  @NotNull
  @Column(name = "active", nullable = false)
  private boolean active;

  @NotNull
  @Column(name = "create_date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime createDate;

  @NotNull
  @Column(name = "create_user", nullable = false)
  private String createUser;

  @Column(name = "update_date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime updateDate;

  @NotNull
  @Column(name = "update_user", nullable = false)
  private String updateUser;
}
