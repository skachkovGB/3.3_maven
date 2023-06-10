package org.example.lesson07;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Story("Моя пользовательская история")
public class MainTest extends AbstractTest_For7lesson {

    @Test
    @DisplayName("Пустой скрипт")
    @Description("Тест ничего не делает")
    @Link("http://google.com")
    @Issue("https://developer.accuweather.com/")
    @TmsLink("")
    @Severity(SeverityLevel.MINOR)
    void testTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Делаем скрин")
    @Description("Тест создает скрин")
    @Link("http://google.com")
    @Issue("https://developer.accuweather.com/")
    @Severity(SeverityLevel.BLOCKER)
    void testFalse() throws InterruptedException, IOException {
        Thread.sleep(1000);
        File file = MyUtils.makeScreenshot(getDriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(true);
    }

    @Step("Степ")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Дай логи")
    @Description("Создаем логи")
    @Link("http://google.com")
    @Issue("https://developer.accuweather.com/")
    @Severity(SeverityLevel.NORMAL)
    void testLogs(){
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
    }

    @Feature("Фича")
    @Test
    void testTrue2(){
        Assertions.assertTrue(true);
    }

}