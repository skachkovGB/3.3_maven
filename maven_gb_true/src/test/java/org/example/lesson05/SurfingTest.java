package org.example.lesson05;

import org.example.lesson05.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SurfingTest extends AbstractTest {
    @Test
    @Order(2)
    void surfingTest() throws InterruptedException {

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

        Thread.sleep(10000);
        WebElement topBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--ratings:nth-child(1)"));
        topBtn.click();

        //Thread.sleep(10000);
        WebElement shopBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--shop"));
        shopBtn.click();

        WebElement ideasBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--235ideas"));
        ideasBtn.click();

        //проверка урла
        Assertions.assertEquals("https://gbtest-skachkov.livejournal.com/checklist/summer2023", getDriver().getCurrentUrl());
    }
}
