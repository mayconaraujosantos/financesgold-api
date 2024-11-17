package com.api.financesgold.application.usecases.user;

import static com.api.financesgold.utils.Constants.EMAIL;
import static com.api.financesgold.utils.Constants.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.api.financesgold.annotation.UnitTest;
import com.api.financesgold.application.port.UserRepositoryPort;
import com.api.financesgold.application.usecases.users.RegisterUserUseCase;
import com.api.financesgold.domain.entity.User;
import com.api.financesgold.domain.exception.InvalidEmailException;
import com.api.financesgold.domain.services.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@UnitTest
public class RegisterUserUseCaseTest {
  private UserRepositoryPort userRepository;
  private RegisterUserUseCase registerUserUseCase;

  @BeforeEach
  void setUp() {
    userRepository = Mockito.mock(UserRepositoryPort.class);
    ValidationService validationService = new ValidationService();
    registerUserUseCase = new RegisterUserUseCase(userRepository, validationService);
  }

  @Test
  @DisplayName("Should register user successfully")
  void shouldRegisterUserSuccessfully() {
    // Arrange
    User user = new User(EMAIL, PASSWORD, EMAIL);

    when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
    when(userRepository.save(user)).thenReturn(user);
    // Act
    User result = registerUserUseCase.execute(user);
    // Assert
    assertThat(result).isNotNull();
    assertThat(result.getEmail()).isEqualTo(EMAIL);
    verify(userRepository, times(1)).save(user);
  }

  @Test
  @DisplayName("Should throw exception for invalid email")
  void shouldThrowExceptionForInvalidEmail() {
    // Arrange
    User user = new User("invalid-email", "password123");

    // Act & Assert
    assertThatThrownBy(() -> registerUserUseCase.execute(user))
        .isInstanceOf(InvalidEmailException.class)
        .hasMessage("O formato do email é inválido");
  }
}
