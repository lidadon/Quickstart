package ru.geekbrains.homework6Rambler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    public static final String RAMLER_URL = "https://mail.rambler.ru/";
    public static final String LOGIN = "20testtest21@rambler.ru";
    public static final String PASSWORD = "1Wordpass!";

    @BeforeAll
    static void registerDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 5);
        webDriver.get(RAMLER_URL);
    }

    @Test
    void loginTest() {
        webDriver.switchTo().frame(0);
        new LoginPage(webDriver)
                .login(LOGIN, PASSWORD);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Входящие']")));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//span[.='Входящие']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

}
