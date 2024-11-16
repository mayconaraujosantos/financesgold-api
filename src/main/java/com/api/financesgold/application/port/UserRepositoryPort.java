package com.api.financesgold.application.port;

import com.api.financesgold.domain.entity.User;

public interface UserRepositoryPort {

  boolean existsByEmail(String email);

  User save(User user);
}
