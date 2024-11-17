package com.api.financesgold.domain.services;

import com.api.financesgold.domain.exception.InvalidEmailException;
import com.api.financesgold.domain.exception.WeakPasswordException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {

  public static Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

  public void validateEmail(String email) {
    if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
      throw new InvalidEmailException("O formato do email é inválido");
    }
  }

  public void validatePassword(String password) {
    if (password == null || password.trim().isEmpty()) {
      throw new WeakPasswordException("A senha nao pode ser nulla ou vazia");
    }
    if (password.length() < 8) {
      throw new WeakPasswordException("A senha deve ter no minimo 8 caracteres");
    }
  }
}
