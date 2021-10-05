package ru.geekbrains.homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateProjectCRM {
    public static final String CRM_URL = "https://crm.geekbrains.space/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(CRM_URL);

        login(driver);

        WebElement projects = driver.findElement(By.xpath("//a//span[.='Проекты']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(projects).perform();

        driver.findElement(By.xpath("//span[.='Все проекты']")).click();
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("New Project 678");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[.='123test']")).click();

        Select prioritySelect = new Select(driver.findElement(By.name("crm_project[priority]")));
        prioritySelect.selectByVisibleText("Низкий");

        Select financeSourceSelect = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        financeSourceSelect.selectByVisibleText("Внутреннее");

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        driver.findElement(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']")).click();
        driver.findElement(By.xpath("//div[.='1111 22222']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'закрыть')]")).click();

    }

    public static void login(WebDriver driver) {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }





}
