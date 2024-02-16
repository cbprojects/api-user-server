package com.project.cafe.api.enums;

public enum EYesNo {
  NO("NO"),
  SI("SI");

  private final String nombre;

  private EYesNo(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
