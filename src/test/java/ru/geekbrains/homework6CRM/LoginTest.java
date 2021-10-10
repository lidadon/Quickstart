package ru.geekbrains.homework6CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    public static final String CRM_URL = "https://crm.geekbrains.space/";
    public static final String LOGIN = "Applanatest1";
    public static final String PASSWORD = "Student2020!";

    @BeforeAll
    static void registerDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get(CRM_URL);
    }

    @Test
    void loginTest() {
        new LoginPage(webDriver)
                .login(LOGIN, PASSWORD);

        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Проекты");

        new ProjectsSubMenu(webDriver)
                .allProjectsButtonClick()
                .CreateProjectButtonClick();

        new CreateProjectPage(webDriver)
                .fillProjectName("New Project 54236")
                .organisationNameFieldClick()
                .organisationNameClick()
                .selectPriority("Низкий")
                .selectFinanceSource("Внутреннее")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectAdmin("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .contactNameFieldClick()
                .contactNameClick()
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Проект сохранен']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
