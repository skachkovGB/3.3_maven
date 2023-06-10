package org.example.lesson06;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.lesson07.AbstractTest_For7lesson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Story("6 тестов")
public class OneFileForSixTest extends AbstractTest_For7lesson {

    private final AllElementsPage allElementsPage = new AllElementsPage(getDriver());
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Order(1)
    void loginTest() throws InterruptedException {
        allElementsPage.login();
        //проверка на появление кнопки инфтерфейса "Написать в блог"
        Assertions.assertDoesNotThrow(allElementsPage::getWriteBlogBth);
        //проверка на появление имени пользователя
        Assertions.assertDoesNotThrow(allElementsPage::getCheckLoginName);
    }

    @Test
    @Order(2)
    void surfingTest() throws InterruptedException {
        allElementsPage.login();
        allElementsPage
                .sleep(2000)
                .clickOnElement(allElementsPage.getTopBtn())
                .clickOnElement(allElementsPage.getShopBth())
                .clickOnElement(allElementsPage.getIdeasBtn());
        //проверка урла
        Assertions.assertEquals(allElementsPage.getCheckUrl(), getDriver().getCurrentUrl());
    }

    @Test
    @Order(3)
    void createPostTest () throws InterruptedException {
        allElementsPage.login();
        allElementsPage
                .sleep(2000)
                .clickOnElement(allElementsPage.getWriteBlogBth())
                .sleep(2000)
                .clickAndFillTitle()
                .sleep(2000)
                .clickAndFillText()
                .sleep(2000)
                .clickOnElement(allElementsPage.getPublicAndSettingBtn())
                .sleep(2000)
                .clickOnElement(allElementsPage.getPublicBtn());
        //Считаем, что если появился функционал комментирования, то тест прошел.
        Assertions.assertDoesNotThrow(allElementsPage::getCommentBlog);
    }

    @Test
    @Order(4)
    void searchTest() throws InterruptedException {
        allElementsPage.login();
        allElementsPage
                .sleep(2000)
                .clickOnElement(allElementsPage.getSearchBtn())
                .searchRequest();

        String currentWindow = getDriver().getWindowHandle();
        for(String winHandle : getDriver().getWindowHandles()) {
            if (!winHandle.equals(currentWindow)) {
                getDriver().switchTo().window(winHandle);
                allElementsPage.sleep(2000);
                Assertions.assertDoesNotThrow(allElementsPage::getSpravkaBtn);
            }
        }
        allElementsPage.sleep(2000);
        getDriver().switchTo().window(currentWindow);
        Assertions.assertDoesNotThrow(allElementsPage::getNewFaceBtn);
    }

    @Test
    @Order(5)
    void deletePostTest() throws InterruptedException {
        allElementsPage.login();
        allElementsPage
                .clickOnElement(allElementsPage.getUserName())
                .changingBlog();
        allElementsPage
                .clickOnElement(allElementsPage.getDeleteBlogBtn())
                .clickOnElement(allElementsPage.getConfirmDeleteBlog());
        Assertions.assertDoesNotThrow(allElementsPage::getCreateNewBlogBtn);
    }

    @Test
    @Order(6)
    void logoutTest() throws InterruptedException {
        allElementsPage.login();
        allElementsPage.logout();
        allElementsPage.sleep(2000);
        Assertions.assertDoesNotThrow(allElementsPage::getLoginBtn);
    }
}


