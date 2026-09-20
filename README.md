Пример:

```bash
.\gradlew.bat test -Dbrowser=firefox -DbrowserSize=1366x768
```

Адрес TestRail также можно изменить:

```bash
.\gradlew.bat test -DbaseUrl=https://example.testrail.io/
```

## Авторизация

Логин и пароль не хранятся в коде.

Перед запуском нужно добавить переменные окружения:

```text
TESTRAIL_EMAIL
TESTRAIL_PASSWORD
```

В коде они получаются через `System.getenv()`.

## Запуск всех тестов

```bash
.\gradlew.bat clean test
```

## Запуск одного теста

Пример запуска TC-01:

```bash
.\gradlew.bat test --tests "tests.FirstTest.successfulLogin"
```

Для запуска другого теста нужно заменить `successfulLogin` на имя нужного метода.

## Отчёт

После запуска HTML-отчёт находится здесь:

```text
build/reports/tests/test/index.html
```