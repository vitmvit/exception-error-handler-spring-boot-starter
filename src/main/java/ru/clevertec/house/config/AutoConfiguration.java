package ru.clevertec.house.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.house.handler.GlobalExceptionHandler;


@Configuration
@EnableConfigurationProperties
@ConditionalOnProperty(prefix = "handler", name = "enabled", havingValue = "true")
public class AutoConfiguration {

    @Bean
    public GlobalExceptionHandler create() {
        return new GlobalExceptionHandler();
    }
}
