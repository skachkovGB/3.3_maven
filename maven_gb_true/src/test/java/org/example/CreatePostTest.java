package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class CreatePostTest extends AbstractTest{
    @Test
    @Order(3)
    void createPostTest() throws InterruptedException {

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

        Thread.sleep(5000);
        WebElement writeBlogBtn = getDriver().findElement(By.cssSelector(".s-header-item-post--long"));
        writeBlogBtn.click();

        Actions title = new Actions(getDriver());
        title.moveToElement(getDriver().findElement(By.xpath(".//textarea[@placeholder='Придумайте заголовок']")))
                .click()
                .sendKeys("Test record")
                .keyUp(Keys.ENTER)
                .build()
                .perform();

        Actions text = new Actions(getDriver());
        text.moveToElement(getDriver().findElement(By.cssSelector(".public-DraftEditorPlaceholder-inner")))
                .click()
                .sendKeys("test text: 1 2 3 4 5 6")
                .keyUp(Keys.ENTER)
                .build()
                .perform();


        WebElement publicAndSettingBtn = getDriver().findElement(By.xpath(".//*[text()='Настроить и опубликовать']/.."));
        publicAndSettingBtn.click();

        Thread.sleep(10000);
        WebElement publicBtn = getDriver().findElement(By.xpath(".//*[text()='Опубликовать']/.."));
        publicBtn.click();

        //Считаем, что если появился функционал комментирования, то тест прошел.
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector(".mdspost-comments__addcomment")));
    }
}
