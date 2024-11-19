package com.api.financesgold.domain.services;

import com.api.financesgold.domain.exception.InvalidEmailException;
import com.api.financesgold.domain.exception.WeakPasswordException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ValidationService {

  public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

  public void validateEmail(String email) {
    Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    Matcher matcher = pattern.matcher(email);
    if (!matcher.matches()) {
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
