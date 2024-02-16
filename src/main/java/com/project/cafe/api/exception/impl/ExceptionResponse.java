package com.project.cafe.api.exception.impl;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

  private Date fecha;
  private String mensaje;
  private String detalles;

  public ExceptionResponse(Date fecha, String mensaje, String detalles) {
    this.fecha = fecha;
    this.mensaje = mensaje;
    this.detalles = detalles;
  }
}
