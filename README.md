# UI Tests — TestRail

Проект с UI-автотестами для TestRail.

## Стек

- Java 17
- Gradle
- JUnit 5
- Selenide

## Структура проекта

- `config` — настройки проекта
- `data` — тестовые данные
- `pages` — Page Object классы
- `tests` — автотесты

## Настройки

По умолчанию используются:

- браузер: Chrome
- размер окна: 1920x1080
- TestRail: https://bebra.testrail.io/

Настройки можно изменить при запуске без изменения кода.

Пример:

```bash
.\gradlew.bat test -Dbrowser=firefox -DbrowserSize=1366x768