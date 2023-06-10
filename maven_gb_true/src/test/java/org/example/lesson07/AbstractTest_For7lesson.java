package org.example.lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class AbstractTest_For7lesson {
    static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("start-maximized");

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());

        eventDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> eventDriver.navigate().to("https://www.livejournal.com"),"Страница не доступна");
    }

    @AfterAll
    static void close(){
        //if(driver !=null) driver.quit();
        //driver.close();
    }
    public static WebDriver getDriver() {
        return eventDriver;
    }

}
