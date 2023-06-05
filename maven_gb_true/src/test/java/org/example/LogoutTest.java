package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoutTest extends AbstractTest {
    @Test
    @Order(6)
    void logoutTest() throws InterruptedException {

        //====================================================================================================
        //кусок из теста 1 (Логин), не получилось тесты в подряд запустить
        WebElement loginBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        loginBtn.click();

        WebElement userName = getDriver().findElement(By.id("user"));
        userName.sendKeys("GBTEST_Skachkov");

        Thread.sleep(2000);
        WebElement userPswd = getDriver().findElement(By.id("lj_loginwidget_password"));
        userPswd.sendKeys("1301Skpol");

        WebElement pushLoginBtn = getDriver().findElement(By.name("action:login"));
        pushLoginBtn.click();
        //====================================================================================================

//        new Actions(getDriver())
//                .moveToElement(getDriver().findElement(By.cssSelector(".s-nav-item__name")))
//                .build()
//                .perform();
//
//        WebElement quitBtn = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
//        quitBtn.click();

        Actions quit = new Actions(getDriver());
        quit.moveToElement(getDriver().findElement(By.cssSelector(".s-nav-item__name")))
                .pause(3000)
                .click(getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--logout")))
                .build()
                .perform();


        Thread.sleep(5000);
        //Считаем, что если появилась кнопка выхода, то тест прошел
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath(".//a[text()='Войти']")));
    }
}


