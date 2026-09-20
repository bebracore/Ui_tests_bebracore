# UI Tests - TestRail

Проект с UI-автотестами для TestRail.

Автоматизировано 10 UI-кейсов: авторизация, навигация по TestRail, открытие проекта, переходы между разделами и создание Test Run.

## Стек

- Java 17
- Gradle
- JUnit 5
- Selenide

## Структура проекта

- `config` - настройки проекта
- `data` - тестовые данные
- `pages` - Page Object классы с локаторами и действиями
- `tests` - автотесты

## Требования для запуска

- Java 17
- Google Chrome
- доступ к TestRail
- логин и пароль от TestRail

## Настройка

По умолчанию используются:

- браузер: Chrome
- размер окна: 1920x1080
- адрес TestRail: `https://bebra.testrail.io/`

Адрес, браузер и размер окна можно изменить при запуске без изменения кода.

Пример:

```bash
.\gradlew.bat test -Dbrowser=firefox -DbrowserSize=1366x768
```

Изменение адреса:

```bash
.\gradlew.bat test -DbaseUrl=https://example.testrail.io/
```

## Авторизация

Логин и пароль не хранятся в коде.

Для авторизации используются переменные окружения:

```text
TESTRAIL_EMAIL
TESTRAIL_PASSWORD
```

В коде значения получаются через `System.getenv()`.

В PowerShell их можно задать перед запуском:

```powershell
$env:TESTRAIL_EMAIL="your_email"
$env:TESTRAIL_PASSWORD="your_password"
```

Также переменные окружения можно указать в конфигурации запуска IntelliJ IDEA.

## Запуск всех тестов

```bash
.\gradlew.bat clean test
```

## Запуск одного теста

Например, запуск TC-01:

```bash
.\gradlew.bat test --tests "tests.FirstTest.successfulLogin"
```

Для запуска другого теста нужно заменить `successfulLogin` на имя нужного метода.

## Отчет

После запуска Gradle HTML-отчет находится по адресу:

```text
build/reports/tests/test/index.html
```

## Тестовые сценарии

Ручные кейсы на платформе недоступны. По согласованию с ментором автотесты были написаны сразу, без создания новых ручных кейсов.

В проекте автоматизировано 10 сценариев:

| ID | Сценарий | Метод |
|---|---|---|
| TC-01 | Успешная авторизация | successfulLogin |
| TC-02 | Авторизация с неверным паролем | checkInvalidPassword |
| TC-03 | Авторизация с пустым Email и неверным паролем | checkEmptyEmail |
| TC-04 | Авторизация с пустым паролем | checkEmptyPassword |
| TC-05 | Переход на Dashboard после авторизации | openDashboard |
| TC-06 | Открытие Sample Project | openSampleProject |
| TC-07 | Поиск и открытие Sample Project | searchAndOpenSampleProject |
| TC-08 | Переход в Test Cases проекта | openTestCases |
| TC-09 | Переход в Test Runs & Results | openTestRunsResults |
| TC-10 | Создание Test Run | createTestRun |

## Известные ограничения

Для выполнения тестов нужен доступ к TestRail и проект `Sample Project`.

TC-10 создает новый Test Run. Автоматическое удаление созданного Test Run в UI-проекте не реализовано.