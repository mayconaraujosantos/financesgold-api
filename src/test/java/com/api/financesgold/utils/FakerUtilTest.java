package com.api.financesgold.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.api.financesgold.annotation.UnitTest;
import com.api.financesgold.domain.entity.User;
import com.api.financesgold.domain.exception.WeakPasswordException;
import org.junit.jupiter.api.Test;

@UnitTest
class FakerUtilTest {

  @Test
  void shouldGenerateDynamicEmailAndPassword() {
    // Gera um email dinâmico e uma senha dinâmica
    String email = FakerUtil.generateEmail();
    String password = FakerUtil.generatePassword(12);
    // Usa os valores para criar um usuário
    User user = User.builder().email(email).password(password).build();
    // Verifica se os valores gerados são válidos
    assertThat(user.getEmail()).isNotEmpty().contains("@");
    assertThat(user.getPassword()).isNotEmpty().hasSize(12);
  }

  @Test
  void shouldThrowExceptionForShortPassword() {
    assertThrows(WeakPasswordException.class, () -> FakerUtil.generatePassword(7));
  }
}
