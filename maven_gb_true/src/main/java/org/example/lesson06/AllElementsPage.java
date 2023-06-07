package org.example.lesson06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class AllElementsPage extends AbstractPage{

    private static final String login = "GBTEST_Skachkov";
    private static final String password = "1301Skpol";
    public static final String checkUrl = "https://gbtest-skachkov.livejournal.com/checklist/summer2023";
    private static final String titleBlog = "Test record";
    private static final String textBlog = "test text: 1 2 3 4 5 6";
    private static final String searchText = "record";

    //===================================================================
    //1) локаторы для логина
    @FindBy(css = ".s-header-item__link--login")
    private WebElement loginBtn;
    @FindBy(id = "user")
    private WebElement userNameLogin;
    @FindBy(id = "lj_loginwidget_password")
    private WebElement userPswd;
    @FindBy(name = "action:login")
    private WebElement pushLoginBtn;
    @FindBy(css=".s-header-item-post--long")
    private WebElement writeBlogBth;
    @FindBy(xpath = ".//a[@title='gbtest_skachkov']")
    private WebElement checkLoginName;
    //===================================================================
    //2) локаторы для серфинга
    @FindBy(css = ".s-header-item__link--ratings:nth-child(1)")
    private WebElement topBtn;
    @FindBy(css = ".s-header-item__link--shop")
    private WebElement shopBth;
    @FindBy(css = ".s-header-item__link--235ideas")
    private WebElement ideasBtn;
    //===================================================================
    //3) локаторы для создания страницы
    //кнопка writeBlog определена ранее в 1 блоке
    @FindBy(xpath = ".//textarea[@placeholder='Придумайте заголовок']")
    private WebElement titleArea;
    @FindBy(css = ".public-DraftEditorPlaceholder-inner")
    private WebElement textArea;
    @FindBy (xpath = ".//*[text()='Настроить и опубликовать']/..")
    private WebElement publicAndSettingBtn;
    @FindBy (xpath = ".//*[text()='Опубликовать']/..")
    private WebElement publicBtn;
    @FindBy (xpath = ".mdspost-comments__addcommen")
    private WebElement commentBlog;
    //===================================================================
    //4) локаторы для поиска
    @FindBy (xpath = "//button[@data-tour-text]")
    private WebElement searchBtn;
    @FindBy(css = ".s-inline-search-input")
    private WebElement searchRequest;
    @FindBy (xpath =  "//a[text()='Справка']")
    private WebElement spravkaBtn;
    @FindBy (xpath =  ".//a[@href='https://www.livejournal.com/category/novye_lica/']")
    private WebElement newFaceBtn;
    //===================================================================
    //5) локаторы для удаления блога
    @FindBy (css = ".s-nav-item__name")
    private WebElement userName;
    @FindBy (xpath = "//div[@class='j-l-alpha-content-inner']/article")
    private WebElement blogForDelArea;
    @FindBy (xpath = ".//a[@title='Редактировать запись']")
    private WebElement editPencilBtn;
    @FindBy (xpath = "//a[text()='Удалить пост']")
    private WebElement deleteBlogBtn;
    @FindBy (xpath = ".//*[text()='Удалить']/..")
    private WebElement confirmDeleteBlog;
    @FindBy (xpath = "//a[text()='Создать первую запись']")
    private WebElement createNewBlogBtn;
    //===================================================================
    //6) локаторы для выхода из учетки
    // кнопка userName создана в пятом блоке
    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logOutBtn;
    // кнопка loginBtn создана в первом блоке
    //===================================================================




    public AllElementsPage(WebDriver driver) {
        super(driver);
    }
    // шаги логин теста
    public void login() throws InterruptedException {
        loginBtn.click();
        userNameLogin.sendKeys(login);
        Thread.sleep(2000);
        userPswd.sendKeys(password);
        pushLoginBtn.click();
    }
    public AllElementsPage sleep(int sec) throws InterruptedException {
        Thread.sleep(sec);
        return this;
    }

    public AllElementsPage clickOnElement(WebElement element){
        element.click();
        return this;
    }

    public AllElementsPage clickAndFillTitle() {
        Actions titleAction = new Actions(getDriver());
        titleAction
                .moveToElement(titleArea)
                .click()
                .sendKeys(titleBlog)
                .keyUp(Keys.ENTER)
                .build()
                .perform();
        return this;
    }
    public AllElementsPage clickAndFillText(){
        Actions textAction = new Actions(getDriver());
        textAction
                .moveToElement(textArea)
                .click()
                .sendKeys(textBlog)
                .keyUp(Keys.ENTER)
                .build()
                .perform();
        return this;
    }
    public AllElementsPage searchRequest() {
        Actions searchAction = new Actions(getDriver());
        searchAction
                .moveToElement(searchRequest)
                .click()
                .sendKeys(searchText)
                .pause(1000)
                .build()
                .perform();
        searchBtn.click();
        return this;
    }
    public AllElementsPage changingBlog(){
        Actions changingAction = new Actions(getDriver());
        changingAction
                .moveToElement(blogForDelArea)
                .pause(1000)
                .moveToElement(editPencilBtn)
                .click()
                .build()
                .perform();
        return this;
    }
    public void logout(){
        Actions logoutAction = new Actions(getDriver());
        logoutAction
                .moveToElement(userName)
                .pause(2000)
                .click(logOutBtn)
                .build()
                .perform();
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }
    public WebElement getWriteBlogBth() {
        return writeBlogBth;
    }
    public WebElement getCheckLoginName() {
        return checkLoginName;
    }
    public WebElement getTopBtn() {
        return topBtn;
    }
    public WebElement getShopBth() {
        return shopBth;
    }
    public WebElement getIdeasBtn() {
        return ideasBtn;
    }
    public String getCheckUrl() {
        return checkUrl;
    }
    public WebElement getPublicAndSettingBtn() {
        return publicAndSettingBtn;
    }
    public WebElement getPublicBtn() {
        return publicBtn;
    }
    public WebElement getCommentBlog() {
        return commentBlog;
    }
    public WebElement getSearchBtn() {
        return searchBtn;
    }
    public WebElement getSpravkaBtn() {
        return spravkaBtn;
    }
    public WebElement getNewFaceBtn() {
        return newFaceBtn;
    }
    public WebElement getUserName() {
        return userName;
    }
    public WebElement getLogOutBtn() {
        return logOutBtn;
    }
    public WebElement getDeleteBlogBtn() {
        return deleteBlogBtn;
    }
    public WebElement getConfirmDeleteBlog() {
        return confirmDeleteBlog;
    }
    public WebElement getCreateNewBlogBtn() {
        return createNewBlogBtn;
    }
}
