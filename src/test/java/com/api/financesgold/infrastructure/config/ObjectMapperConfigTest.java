package com.api.financesgold.infrastructure.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectMapperConfigTest {
  @Autowired private ObjectMapper objectMapper;

  @Test
  public void shouldSerializeLocalDateTimeCorrectly() throws JsonProcessingException {
    LocalDateTime now = LocalDateTime.now();
    String json = objectMapper.writeValueAsString(now);

    // Verifica se o JSON gerado está no formato esperado
    assertEquals(
        "\"" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\"", json);
  }
}
