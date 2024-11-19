package com.api.financesgold.infrastructure.persistence;

import static com.api.financesgold.infrastructure.utils.Constants.EMAIL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.api.financesgold.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UsuarioRepositoryAdapterTest {
  private UsuarioJpaRepository usuarioJpaRepository;
  private UsuarioRepositoryAdapter usuarioRepositoryAdapter;

  @BeforeEach
  void setUp() {
    usuarioJpaRepository = Mockito.mock(UsuarioJpaRepository.class);
    usuarioRepositoryAdapter = new UsuarioRepositoryAdapter(usuarioJpaRepository);
  }

  @Test
  @DisplayName("Should call existsByEmail on JpaRepository")
  void shouldCallExistsByEmailOnJpaRepository() {
    String email = EMAIL;
    when(usuarioJpaRepository.existsByEmail(email)).thenReturn(true);

    // Act
    boolean result = usuarioRepositoryAdapter.existsByEmail(email);

    // Assert
    assertThat(result).isTrue();
    verify(usuarioJpaRepository, times(1)).existsByEmail(email);
  }

  @Test
  @DisplayName("Should call save on JpaRepository")
  void shouldCallSaveOnJpaRepository() {
    var savedUser = UserUtils.createUserValid();
    when(usuarioJpaRepository.save(savedUser)).thenReturn(savedUser);

    // Act
    var result = usuarioRepositoryAdapter.save(savedUser);

    // Assert
    assertThat(result).isNotNull();
    assertThat(result.getEmail()).isEqualTo(EMAIL);
    verify(usuarioJpaRepository, times(1)).save(savedUser);
  }
}
