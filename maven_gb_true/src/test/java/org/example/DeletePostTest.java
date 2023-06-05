package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeletePostTest extends AbstractTest {

    @Test
    @Order(5)
    void deletePostTest() throws InterruptedException {

        //====================================================================================================
        //кусок из теста 1 (Логин), не получилось тесты в подряд запустить
        WebElement loginBtn = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        loginBtn.click();

        WebElement userName = getDriver().findElement(By.id("user"));
        userName.sendKeys("GBTEST_Skachkov");

        //Thread.sleep(5000);
        WebElement userPswd = getDriver().findElement(By.id("lj_loginwidget_password"));
        userPswd.sendKeys("1301Skpol");

        WebElement pushLoginBtn = getDriver().findElement(By.name("action:login"));
        pushLoginBtn.click();
        //====================================================================================================

        WebElement nameBtn = getDriver().findElement(By.cssSelector(".s-nav-item__name"));
        nameBtn.click();

        Actions changing = new Actions(getDriver());
        changing.moveToElement(getDriver().findElement(By.xpath("//div[@class='j-l-alpha-content-inner']/article")))
                //.moveToElement(getDriver().findElement(By.xpath(".//*[text()='Редактировать запись']/..")))
                .moveToElement(getDriver().findElement(By.xpath(".//a[@title='Редактировать запись']")))
                .click()
                .build()
                .perform();

        //WebElement delBtn = getDriver().findElement(By.xpath("//a[contains(text(),'Удалить пост')]"));
        WebElement delBtn = getDriver().findElement(By.xpath("//a[text()='Удалить пост']"));
        delBtn.click();

        WebElement confirmDelBtn = getDriver().findElement(By.xpath(".//*[text()='Удалить']/.."));
        confirmDelBtn.click();


        //Считаем, что если появилась кнопка создания первой записи, то тест прошел
        //Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//a[contains(text(),'Создать первую запись')]")));
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//a[text()='Создать первую запись']")));
    }
}

