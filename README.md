# Проект по автоматизации тестирования для "Приорбанк".

## Содержание

- <a href="#description">Описание</a>
- <a href="#tools">Технологии</a>
- <a href="#jenkins">Сборка в Jenkins</a>
- <a href="#allure">Пример Allure-отчета</a>
- <a href="#telegram">Уведомление в Telegram при помощи бота</a>

<a id="description"></a>

## Описание:

Автоматизированные UI-тесты для сайта [priorbank.by](https://www.priorbank.by) с использованием:

- Java 17
- Selenide 7.2.3
- JUnit 5
- Allure Reports

<a id="tools"></a>

## Технологии:

<p align="center">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов
  в <code>Telegram</code> при помощи бота.

<a id="jenkins"></a>

## <img src="media/logo/Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins

<p align="center">
<img title="Jenkins Build" src="media/screen/Jenkins.PNG">
</p>

<a id="allure"></a>

## <img src="media/logo/Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета

<p align="center">
<img title="Allure Overview" src="media/screen/Allure.PNG">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screen/Result.PNG">
</p>

<a id="telegram"></a>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с
результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screen/Telegram.PNG">
</p>




