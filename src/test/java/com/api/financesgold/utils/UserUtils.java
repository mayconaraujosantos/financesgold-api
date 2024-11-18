package com.api.financesgold.utils;

import static com.api.financesgold.infrastructure.utils.Constants.EMAIL;
import static com.api.financesgold.infrastructure.utils.Constants.HASHED_PASSWORD;
import static com.api.financesgold.infrastructure.utils.Constants.USERNAME;

import com.api.financesgold.domain.entity.User;

public class UserUtils {

  public static User createUserValid() {
    return User.builder().username(USERNAME).password(HASHED_PASSWORD).email(EMAIL).build();
  }
}
