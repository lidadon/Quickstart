package ru.geekbrains.homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement buttonSubmit = $(By.id("_submit"));

    @Step("Заполнить поля логина и пароль, нажать кнопку Войти")
    public MainPage login(String login, String password) {
        open("https://crm.geekbrains.space/");
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return page(MainPage.class);
    }
}
