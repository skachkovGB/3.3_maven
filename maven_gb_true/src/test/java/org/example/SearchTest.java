package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchTest extends AbstractTest{

    @Test
    @Order(4)
    void searchTest() throws InterruptedException {

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

        Thread.sleep(2000);
        WebElement searchBtn = getDriver().findElement(By.xpath("//button[@data-tour-text]"));
        searchBtn.click();


        Actions search = new Actions(getDriver());
        search.moveToElement(getDriver().findElement(By.cssSelector(".s-inline-search-input")))
                .click()
                .sendKeys("record")
                .pause(1000)
                //.keyUp(Keys.ENTER)
                .build()
                .perform();
        searchBtn.click();

        String currentWindow = getDriver().getWindowHandle();
        for(String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(currentWindow)) {
                getDriver().switchTo().window(winHandle);
                Thread.sleep(2000);
                Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//a[text()='Справка']")));
            }
        }


        Thread.sleep(2000);
        //Смогли вернуться на главную
        getDriver().switchTo().window(currentWindow);
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath(".//a[@href='https://www.livejournal.com/category/novye_lica/']")));
    }
}




