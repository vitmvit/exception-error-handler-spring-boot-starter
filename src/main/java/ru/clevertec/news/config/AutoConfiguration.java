package ru.clevertec.news.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.news.handler.GlobalExceptionHandler;

/**
 * Автоконфигурация для обработки исключений.
 * Конфигурация может быть включена и выключена с помощью свойства "starter.handler.enabled" в файле application.yml.
 */
@Slf4j
@Configuration
@EnableConfigurationProperties
@ConditionalOnProperty(prefix = "starter.handler", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AutoConfiguration {

    /**
     * Инициализирует класс AutoConfiguration и регистрирует сообщение инициализации
     */
    @PostConstruct
    void init() {
        log.info("AutoConfiguration initialized");
    }

    /**
     * Возвращает bean-компонент GlobalExceptionHandler
     *
     * @return GlobalExceptionHandler bean.
     */
    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler create() {
        return new GlobalExceptionHandler();
    }
}