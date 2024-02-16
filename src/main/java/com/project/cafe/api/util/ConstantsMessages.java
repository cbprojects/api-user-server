package com.project.cafe.api.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConstantsMessages {

  public static final String EMPTY_VALUE = "Valor vacío";
  public static final String BAD_VALUE = "Valor incorrecto";
  public static final String ERROR_LOGIN_INACTIVE_OR_BAD_REQUEST =
    "Bad request";
  public static final String ERROR_NO_DATA = "No data found";
  public static final String ERROR_USER_ALREADY_EXIST_BY_MAIL =
    "User already exist with the same mail";
  public static final String ERROR_USER_NOT_FOUND = "User not found";
  public static final String ERROR_ARGUMENT_NOT_VALID = "Argument not valid";
  public static final String ERROR_TABLE_NOT_FOUND_ON_VALIDATIONS =
    "The table was not found in the model";
  public static final String ERROR_NO_ENTITY_ON_DB =
    "Entidad no encontrada para ejecutar el QUERY";
}
