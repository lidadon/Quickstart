package ru.geekbrains.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RamblerMail {
    public static final String RAMLER_URL = "https://mail.rambler.ru/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(RAMLER_URL);

        login(driver);

    }

    public static void login(WebDriver driver) {
        driver.switchTo().frame(0);
        WebElement login = driver.findElement(By.name("login"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement enter = driver.findElement(By.xpath("//span[@class='rui-Button-content']"));
        login.sendKeys("20testtest21@rambler.ru");
        password.sendKeys("1Wordpass!");
        enter.click();
    }


}
