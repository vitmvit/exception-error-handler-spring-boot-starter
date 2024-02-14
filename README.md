# exception-error-handler-spring-boot-starter

Данный стартер представляет собой автоконфигурацию для обработки различных исключений и возврата объекта ErrorDto,
содержащего сообщение об ошибке и код ошибки.

## Инструкция по установке

В build.gradle основного проекта:

- Необходимо указать mavenLocal() в repositories
    ```text
        repositories {
            mavenLocal()
            mavenCentral()
        }
    ```
- Необходимо добавить зависимость на стартер в dependencies:
    ```text
        implementation "ru.clevertec.news:exception-error-handler-spring-boot-starter:1.0"
    ```

## Реализация

Стартер автоматически обрабатывает исключения, поддерживаемые в конфигурации AutoConfiguration. Для каждого исключения
определен метод в классе GlobalExceptionHandler, который возвращает объект ErrorDto с сообщением об ошибке и кодом
ошибки.

## Пример выброшенного исключения

Request (POST):

```http
    http://localhost:8080/api/signup
```

Body:

```json
{
  "login": "User",
  "password": "user",
  "role": "ADMIN"
}
```

Исключение

```json
{
  "errorMessage": "Username exists",
  "errorCode": 302
}
```