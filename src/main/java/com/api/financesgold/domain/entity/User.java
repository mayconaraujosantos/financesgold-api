package com.api.financesgold.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  private String email;

  public User() {}

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User(UserBuilder builder) {
    this.username = builder.username;
    this.password = builder.password;
    this.email = builder.email;
  }

  public static UserBuilder builder() {
    return new UserBuilder();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static class UserBuilder {
    private String username;
    private String password;
    private String email;

    public UserBuilder username(String username) {
      this.username = username;
      return this;
    }

    public UserBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserBuilder email(String email) {
      this.email = email;
      return this;
    }

    public User build() {
      return new User(username, password, email);
    }
  }
}
