package com.api.financesgold.infrastructure.utils;

import com.api.financesgold.domain.exception.WeakPasswordException;
import java.util.Random;
import java.util.UUID;

public class FakerUtil {
  private static final String EMAIL_DOMAINS[] = {"example.com", "test.com", "demo.com"};

  // Gera um email dinâmico
  public static String generateEmail() {
    String username = "user" + UUID.randomUUID().toString().substring(0, 8);
    String domain = EMAIL_DOMAINS[new Random().nextInt(EMAIL_DOMAINS.length)];
    return username + "@" + domain;
  }

  // Gera uma senha dinâmica com comprimento personalizado
  public static String generatePassword(int length) {
    if (length < 8) {
      throw new WeakPasswordException("Senha deve ter no mínimo 8 caracteres");
    }
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*!";
    StringBuilder password = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < length; i++) {
      password.append(characters.charAt(random.nextInt(characters.length())));
    }
    return password.toString();
  }
}
