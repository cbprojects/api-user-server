package com.project.cafe.api.exception.imp;

public class ModelNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 9215964858678100358L;

  public ModelNotFoundException(String mensaje) {
    super(mensaje);
  }
}
