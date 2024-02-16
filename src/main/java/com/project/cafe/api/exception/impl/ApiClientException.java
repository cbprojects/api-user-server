package com.project.cafe.api.exception.impl;

import com.project.cafe.api.model.dto.ErrorDTO;

public class ApiClientException extends Exception {

  private static final String LOG_START = "|~ ApiClientException ~>| ";
  private static final String LOG_END = " |<~ ApiClientException ~|";

  public ApiClientException(String message) {
    super(LOG_START.concat(message).concat(LOG_END));
  }

  public ApiClientException(ErrorDTO error) {
    super(LOG_START.concat(error.toString()).concat(LOG_END));
  }
}
