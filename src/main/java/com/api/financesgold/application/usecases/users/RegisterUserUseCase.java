package com.api.financesgold.application.usecases.users;

import com.api.financesgold.application.port.UserRepositoryPort;
import com.api.financesgold.domain.entity.User;
import com.api.financesgold.domain.exception.UserAlreadyExistsException;
import com.api.financesgold.domain.services.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterUserUseCase {
  private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserUseCase.class);

  private final UserRepositoryPort userRepositoryPort;
  private final ValidationService validationService;

  public RegisterUserUseCase(
      UserRepositoryPort userRepositoryPort, ValidationService validationService) {
    this.userRepositoryPort = userRepositoryPort;
    this.validationService = validationService;
  }

  public User execute(User user) {
    LOGGER.info("Iniciando o registro do usuário");

    validationService.validateEmail(user.getEmail());
    validationService.validatePassword(user.getPassword());

    if (userRepositoryPort.existsByEmail(user.getEmail())) {
      LOGGER.warn("O email {} já está registrado", user.getEmail());
      throw new UserAlreadyExistsException("O email ja esta registrado" + user.getEmail());
    }
    LOGGER.info("Salvando o usuário no repositório");
    var registeredUser = userRepositoryPort.save(user);

    LOGGER.info("Registro do usuário concluído com sucesso");
    return registeredUser;
  }
}
