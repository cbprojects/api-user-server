package com.project.cafe.api.util;

import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConstantsValidations {

  // Expresiones regulares y cadenas
  public static final String EXPRESION_REGULAR_DE_TEXTO_INGRESADO =
    "[a-zA-Z0-9- äÄëËïÏöÖüÜáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙñÑ//\\.]*";
  public static final String EXPRESION_REGULAR_DE_DIRECCIONES =
    "[a-zA-Z0-9- äÄëËïÏöÖüÜáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙñÑ//\\.]*#[a-zA-Z0-9- äÄëËïÏöÖüÜáéíóúÁÉÍÓÚÂÊÎÔÛâêîôûàèìòùÀÈÌÒÙñÑ//\\.]*";
  public static final String EXPRESION_REGULAR_DE_EMAILS =
    "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
  public static final Pattern EMAIL_PATTERN = Pattern.compile(
    "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
  );
  public static final String CARACTERES =
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  // Simbolos y constantes
  public static final String COMODIN_BD = "%";
  public static final String SEPARADOR_TAGS = ";";
  public static final String SEPARADOR_SLASH = "/";
  public static final String PHASE_CREATE = "C";
  public static final String PHASE_UPDATE = "U";
  public static final int TAMANO_TOKEN = 11;
  public static final int MAX_LENGTH_50 = 50;
  public static final int MAX_LENGTH_30 = 30;
  public static final String CRYPT_KEY = "9asud98asyh";
  public static final int ITERATIONS = 10000;
  public static final int KEY_LENGTH = 256;
  public static final int SALT_ENCRIPTAR_CLAVE = 28;
  public static final char[] SIMBOLOS = CARACTERES.toCharArray();
  public static final char[] BUFFER = new char[TAMANO_TOKEN];
}
