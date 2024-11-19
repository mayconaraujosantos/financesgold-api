package com.api.financesgold.infrastructure.configs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {
  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();

    // Módulo para serializar/desserializar datas e horários do Java 8
    JavaTimeModule module = new JavaTimeModule();

    // Formatador de data e hora personalizado
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));

    mapper.registerModule(module);

    // Outras configurações (opcional)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignorar
    // propriedades
    // desconhecidas
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // Não serializar propriedades
    // nulas

    return mapper;
  }
}
