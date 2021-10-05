package ru.geekbrains.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateProjectTest {
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
        webDriverWait = new WebDriverWait(webDriver, 5);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(CRM_URL);
        login();
    }

    @Test
    void createProjectTest() {
        WebElement projects = webDriver.findElement(By.xpath("//a//span[.='Проекты']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(projects).perform();

        webDriver.findElement(By.xpath("//span[.='Все проекты']")).click();
        webDriver.findElement(By.xpath("//a[.='Создать проект']")).click();
        webDriver.findElement(By.name("crm_project[name]")).sendKeys("New Project 654");
        webDriver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriver.findElement(By.xpath("//div[.='123test']")).click();

        Select prioritySelect = new Select(webDriver.findElement(By.name("crm_project[priority]")));
        prioritySelect.selectByVisibleText("Низкий");

        Select financeSourceSelect = new Select(webDriver.findElement(By.name("crm_project[financeSource]")));
        financeSourceSelect.selectByVisibleText("Внутреннее");

        Select businessUnitSelect = new Select(webDriver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(webDriver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select rpSelect = new Select(webDriver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select managerSelect = new Select(webDriver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        webDriver.findElement(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")).click();
        webDriver.findElement(By.xpath("//div[.='1111 22222']")).click();
        webDriver.findElement(By.xpath("//button[contains(text(), 'закрыть')]")).click();

        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Проект сохранен']")).isDisplayed());
    }

    public void login() {
        webDriver.findElement(By.id("prependedInput")).sendKeys(LOGIN);
        webDriver.findElement(By.id("prependedInput2")).sendKeys(PASSWORD);
        webDriver.findElement(By.id("_submit")).click();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
