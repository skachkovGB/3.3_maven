package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        test_1(driver);
        test_2(driver);
        //test_3(driver);
        //test_4(driver);

        //driver.close();
        //driver.quit();
    }

    public static void test_1(WebDriver driver) throws InterruptedException {


        driver.get("https://www.livejournal.com/");

        //Thread.sleep(20000);
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.sendKeys("GBTEST_Skachkov");

        //Thread.sleep(5000);
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.sendKeys("1301Skpol");

        WebElement webElement4 = driver.findElement(By.name("action:login"));
        webElement4.click();
    }

    public static void test_2(WebDriver driver) throws InterruptedException {

        Thread.sleep(5000);
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--ratings:nth-child(1)"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-item__link--shop"));
        webElement2.click();

        WebElement webElement3 = driver.findElement(By.cssSelector(".s-header-item__link--235ideas"));
        webElement3.click();

    }

    public static void test_3(WebDriver driver) {


    }
    public static void test_4(WebDriver driver) {

        //WebElement webElement1 = driver.findElement();
    }

}






//          с лекции
//        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");        //запустить браузер на весь экран
//        //options.addArguments("--headless");           //запуск в фоновом режиме
//        //options.addArguments("--incognito");          //запуск в режиме инкогнито
//
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://www.livejournal.com/");
//
//        //WebElement webElement1 = driver.findElement();
//
//        //driver.close();
//        //driver.quit();



