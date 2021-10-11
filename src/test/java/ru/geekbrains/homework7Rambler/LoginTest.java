package ru.geekbrains.homework7Rambler;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Story("Вход в почту")
public class LoginTest extends BaseTest {
    public static final String RAMLER_URL = "https://mail.rambler.ru/";
    public static final String LOGIN = "20testtest21@rambler.ru";
    public static final String PASSWORD = "1Wordpass!";

    @BeforeEach
     void getURL() {
        webDriver.get(RAMLER_URL);
    }

    @Test
    @Description("Логин в почту")
    void loginTest() {
        webDriver.switchTo().frame(0);
        new LoginPage(webDriver)
                .login(LOGIN, PASSWORD);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Входящие']")));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//span[.='Входящие']")).isDisplayed());
    }
}
