# rtk-test
1. Запустить appium сервер с предварительно установленным драйвером uiautomator2 через командную строку командой appium.
Проверить адрес URL для подключения к серверу appium : http://127.0.0.1:4723/ (only accessible from the same host).
2. Включить эмулятор с предварительно установленными приложениями:
- VK видео (https://play.google.com/store/apps/details?id=com.vk.vkvideo),
- Алхимия:Головоломка (https://play.google.com/store/apps/details?id=com.ilyin.alchemy).
3. Запустить тесты через maven менеджер в IntelliJ IDEA: "mvn clean test" или через интерфейс IntelliJ IDEA.