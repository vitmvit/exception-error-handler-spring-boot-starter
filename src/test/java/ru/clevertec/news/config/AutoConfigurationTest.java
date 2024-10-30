package ru.clevertec.news.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.clevertec.news.handler.GlobalExceptionHandler;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void shouldCreateControllerBean() {
        contextRunner.withPropertyValues("starter.handler.enabled=true")
                .withUserConfiguration(AutoConfiguration.class)
                .run(context ->
                        assertThat(context).hasSingleBean(GlobalExceptionHandler.class)
                );
    }

    @Test
    public void shouldNotCreateControllerBean() {
        contextRunner.withPropertyValues("starter.handler.enabled=false")
                .withUserConfiguration(AutoConfiguration.class)
                .run(context ->
                        assertThat(context).doesNotHaveBean(GlobalExceptionHandler.class)
                );
    }
}