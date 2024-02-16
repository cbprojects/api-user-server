package com.project.cafe.api.helper.util;

import com.project.cafe.api.helper.constant.ConstantsFields;
import com.project.cafe.api.helper.constant.ConstantsMessages;
import com.project.cafe.api.helper.constant.ConstantsTableNames;
import com.project.cafe.api.helper.constant.ConstantsValidations;
import com.project.cafe.api.model.UserEntity;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Util {

  public static boolean esCorreoValido(String email) {
    Matcher mather = ConstantsValidations.EMAIL_PATTERN.matcher(
      email.toLowerCase()
    );
    return mather.find();
  }

  public static boolean tieneCantidadCharPermitida(
    String cadenaValidar,
    int cantidadChar
  ) {
    boolean result = false;
    if (!StringUtils.isBlank(cadenaValidar)) {
      result = cadenaValidar.length() <= cantidadChar;
    }
    return result;
  }

  public static List<String> validaDatos(String tabla, Object entidadTB) {
    List<String> errores = new ArrayList<>();
    if (!StringUtils.isBlank(tabla)) {
      switch (tabla) {
        case ConstantsTableNames.USER_TB:
          errores = validarUsuario((UserEntity) entidadTB);
          break;
      }
    } else {
      errores.add(ConstantsMessages.ERROR_TABLE_NOT_FOUND_ON_VALIDATIONS);
    }

    return errores;
  }

  public static List<String> validarUsuario(UserEntity user) {
    List<String> errores = new ArrayList<>();

    if (StringUtils.isBlank(user.getName())) {
      errores.add(ConstantsFields.NOMBRE + ConstantsMessages.EMPTY_VALUE);
    }
    if (StringUtils.isBlank(user.getLastName())) {
      errores.add(ConstantsFields.APELLIDO + ConstantsMessages.EMPTY_VALUE);
    }
    if (StringUtils.isBlank(user.getPassword())) {
      errores.add(ConstantsFields.PASSWORD + ConstantsMessages.EMPTY_VALUE);
    }
    if (StringUtils.isBlank(user.getMail())) {
      errores.add(ConstantsFields.MAIL + ConstantsMessages.EMPTY_VALUE);
    } else if (!Util.esCorreoValido(user.getMail())) {
      errores.add(ConstantsFields.MAIL + ConstantsMessages.BAD_VALUE);
    }

    return errores;
  }

  public static String generarToken(String usuario) {
    char[] SYM_USUARIO = usuario.toCharArray();
    char[] BUF_USUARIO = new char[ConstantsValidations.TAMANO_TOKEN];
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < ConstantsValidations.BUFFER.length; i++) {
      ConstantsValidations.BUFFER[i] =
        ConstantsValidations.SIMBOLOS[random.nextInt(
            ConstantsValidations.SIMBOLOS.length
          )];
    }
    for (int i = 0; i < BUF_USUARIO.length; i++) {
      BUF_USUARIO[i] = SYM_USUARIO[random.nextInt(SYM_USUARIO.length)];
    }
    String result = new String(ConstantsValidations.BUFFER) +
    new String(BUF_USUARIO);

    return result.substring(5, 15);
  }

  public static String encriptarPassword(String password) {
    String salt = PasswordUtil.getSalt(
      ConstantsValidations.SALT_ENCRIPTAR_CLAVE,
      password
    );
    return PasswordUtil.generateSecurePassword(password, salt);
  }

  public static String buildMessageErrors(List<String> errors) {
    String result = null;
    if (errors != null && !errors.isEmpty()) {
      StringBuilder builderMsg = new StringBuilder();
      String title = "Se encontraron los siguientes errores: ";

      for (String error : errors) {
        builderMsg.append(error + "|");
      }

      result = title + builderMsg;
    }

    return result;
  }
}
