package com.api.financesgold.infrastructure.utils;

import java.util.Arrays;

public class Constants {
  public static final String JWT_SECRET = "financesgold";
  public static final String JWT_TOKEN_PREFIX = "Bearer ";
  public static final String JWT_TOKEN_HEADER = "Authorization";
  public static final String JWT_TOKEN_ISSUER = "financesgold";
  public static final String JWT_TOKEN_AUDIENCE = "financesgold";

  public static final String EMAIL_PATTERN =
      "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
  public static final String PASSWORD_PATTERN =
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

  public static final String ROLE_USER = "ROLE_USER";
  public static final String ROLE_ADMIN = "ROLE_ADMIN";

  public static final String DEFAULT_PAGE_NUMBER = "0";
  public static final String DEFAULT_PAGE_SIZE = "10";
  public static final String DEFAULT_SORT_BY = "id";
  public static final String DEFAULT_SORT_DIRECTION = "asc";

  public static final String ROLE_PREFIX = "ROLE_";

  public static final String LOGIN = "/login";
  public static final String REGISTER = "/register";

  public static final String DEFAULT_SUCCESS_URL = "/";

  public static final String LOGIN_PROCESS = "/login-process";
  public static final String LOGOUT = "/logout";
  public static final String LOGOUT_SUCCESS_URL = "/login";

  public static final String OPEN_API_TITLE = "Finances Gold API";
  public static final String OPEN_API_DESCRIPTION = "API para gerenciamento de finanças";

  // Routes AUTH API
  public static final String AUTH_REGISTER = "/auth/register";
  public static final String AUTH_LOGIN = "/auth/login";
  public static final String AUTH_LOGIN_PROCESS = "/login-process";
  public static final String AUTH_LOGOUT = "/logout";
  public static final String AUTH_LOGOUT_SUCCESS_URL = "/login";

  public static final String H2_CONSOLE = "/h2-console/**";
  // Routes SwaggerDOC API
  public static final String[] SWAGGER_OPEN_API = {
    "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**", "/v2/api-docs",
  };

  public static final String[] ROUTES = {
    "/", H2_CONSOLE, Arrays.asList(SWAGGER_OPEN_API).toString(), AUTH_REGISTER, AUTH_LOGIN, "/**"
  };

  private Constants() {}
}
