package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends AbstractTest {
    @Test
    @Order(1)
    void loginTest() throws InterruptedException{
        //Thread.sleep(20000);
        WebElement loginBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        loginBtn.click();

        WebElement userName = getDriver().findElement(By.id("user"));
        userName.sendKeys("GBTEST_Skachkov");

        Thread.sleep(2000);
        WebElement userPswd = getDriver().findElement(By.id("lj_loginwidget_password"));
        userPswd.sendKeys("1301Skpol");

        WebElement pushLoginBtn = getDriver().findElement(By.name("action:login"));
        pushLoginBtn.click();

        //проверка на появление кнопки инфтерфейса "Написать в блог"
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".s-header-item-post--long")));
        //проверка на появление имени пользователя
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath(".//a[@title='gbtest_skachkov']")));
    }
}