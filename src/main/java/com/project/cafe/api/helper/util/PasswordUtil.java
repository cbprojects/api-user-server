package com.project.cafe.api.helper.util;

import com.project.cafe.api.helper.constant.ConstantsValidations;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordUtil {

  public static String getSalt(int length, String clave) {
    return clave + length + ConstantsValidations.CRYPT_KEY;
  }

  public static byte[] hash(char[] password, byte[] salt) {
    PBEKeySpec spec = new PBEKeySpec(
      password,
      salt,
      ConstantsValidations.ITERATIONS,
      ConstantsValidations.KEY_LENGTH
    );
    Arrays.fill(password, Character.MIN_VALUE);
    try {
      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return skf.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new AssertionError(
        "Error while hashing a password: " + e.getMessage(),
        e
      );
    } finally {
      spec.clearPassword();
    }
  }

  public static String generateSecurePassword(String password, String salt) {
    String returnValue = null;
    byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
    returnValue = Base64.getEncoder().encodeToString(securePassword);

    return returnValue.replace("/", "c");
  }

  public static boolean verifyUserPassword(
    String providedPassword,
    String securedPassword,
    String salt
  ) {
    boolean returnValue = false;
    String newSecurePassword = generateSecurePassword(providedPassword, salt);
    returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

    return returnValue;
  }
}
