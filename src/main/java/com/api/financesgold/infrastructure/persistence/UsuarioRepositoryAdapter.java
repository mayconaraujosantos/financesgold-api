package com.api.financesgold.infrastructure.persistence;

import com.api.financesgold.application.port.UserRepositoryPort;
import com.api.financesgold.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryAdapter implements UserRepositoryPort {
  private final UsuarioJpaRepository usuarioJpaRepository;

  public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
    this.usuarioJpaRepository = usuarioJpaRepository;
  }

  @Override
  public boolean existsByEmail(String email) {
    return usuarioJpaRepository.existsByEmail(email);
  }

  @Override
  public User save(User user) {
    return usuarioJpaRepository.save(user);
  }
}
