package ru.geekbrains.homework7CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    EventFiringWebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new EventFiringWebDriver(new ChromeDriver());
        webDriver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLogs = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log: browserLogs) {
            System.out.println(log.getMessage());
            Allure.step("Элемент консоли браузера " + log.getMessage());
        }
        webDriver.quit();
    }
}
