package com.project.cafe.api.exception.impl;

import com.project.cafe.api.model.dto.ErrorDTO;

public class ModelException extends Exception {

  private static final String LOG_START = "|~ ModelException ~>| ";
  private static final String LOG_END = " |<~ ModelException ~|";

  public ModelException(String message) {
    super(LOG_START.concat(message).concat(LOG_END));
  }

  public ModelException(ErrorDTO error) {
    super(LOG_START.concat(error.toString()).concat(LOG_END));
  }
}
