package com.api.financesgold.infrastructure.persistence;

import com.api.financesgold.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);
}
