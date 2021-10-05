package ru.geekbrains.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RamblerMailTest {
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
        WebElement login = webDriver.findElement(By.name("login"));
        WebElement password = webDriver.findElement(By.name("password"));
        WebElement enter = webDriver.findElement(By.xpath("//span[@class='rui-Button-content']"));
        login.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        enter.click();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
