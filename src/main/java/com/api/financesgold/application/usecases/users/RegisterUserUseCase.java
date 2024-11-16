package com.api.financesgold.application.usecases.users;

import com.api.financesgold.application.port.UserRepositoryPort;
import com.api.financesgold.domain.entity.User;
import com.api.financesgold.domain.exception.UserAlreadyExistsException;

public class RegisterUserUseCase {

  private final UserRepositoryPort userRepositoryPort;

  public RegisterUserUseCase(UserRepositoryPort userRepositoryPort) {
    this.userRepositoryPort = userRepositoryPort;
  }

  public User execute(User user) {
    validateUser(user);
    if (userRepositoryPort.existsByEmail(user.getEmail())) {
      throw new UserAlreadyExistsException("Username already exists" + user.getEmail());
    }
    return userRepositoryPort.save(user);
  }

  private void validateUser(User user) {
    if (user.getEmail() == null || user.getEmail().isEmpty() || !isValidEmail(user.getEmail())) {
      throw new IllegalArgumentException("Invalid email: " + user.getEmail());
    }
    if (user.getPassword() == null || user.getPassword().isEmpty()) {
      throw new IllegalArgumentException("Invalid password: " + user.getPassword());
    }
  }

  private boolean isValidEmail(String email) {
    return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
  }
}
