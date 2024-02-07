package ru.clevertec.house.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.house.handler.GlobalExceptionHandler;

/**
 * Автоконфигурация для обработки исключений.
 * Конфигурация может быть включена и выключена с помощью свойства "handler.enabled" в файле application.yml.
 */
@Configuration
@EnableConfigurationProperties
@ConditionalOnProperty(prefix = "handler", name = "enabled", havingValue = "true")
public class AutoConfiguration {

    @Bean
    public GlobalExceptionHandler create() {
        return new GlobalExceptionHandler();
    }
}
