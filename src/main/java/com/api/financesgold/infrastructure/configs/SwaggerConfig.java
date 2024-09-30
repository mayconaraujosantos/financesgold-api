package com.api.financesgold.infrastructure.configs;

import static com.api.financesgold.infrastructure.utils.Constants.OPEN_API_DESCRIPTION;
import static com.api.financesgold.infrastructure.utils.Constants.OPEN_API_TITLE;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Value("${build.version}")
  private String projectVersion;

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title(OPEN_API_TITLE)
                .description(OPEN_API_DESCRIPTION)
                .version(projectVersion));
  }
}
