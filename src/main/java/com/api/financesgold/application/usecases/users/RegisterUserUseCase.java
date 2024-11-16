package com.api.financesgold.application.usecases.users;

import com.api.financesgold.application.port.UserRepositoryPort;
import com.api.financesgold.domain.entity.User;
import com.api.financesgold.domain.exception.UserAlreadyExistsException;
import com.api.financesgold.domain.services.ValidationService;

public class RegisterUserUseCase {

  private final UserRepositoryPort userRepositoryPort;
  private final ValidationService validationService;

  public RegisterUserUseCase(
      UserRepositoryPort userRepositoryPort, ValidationService validationService) {
    this.userRepositoryPort = userRepositoryPort;
    this.validationService = validationService;
  }

  public User execute(User user) {
    validationService.validateEmail(user.getEmail());
    validationService.validatePassword(user.getPassword());

    if (userRepositoryPort.existsByEmail(user.getEmail())) {
      throw new UserAlreadyExistsException("O email ja esta registrado" + user.getEmail());
    }
    return userRepositoryPort.save(user);
  }
}
