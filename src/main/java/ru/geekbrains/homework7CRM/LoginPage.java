package ru.geekbrains.homework7CRM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseElements {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonSubmit;

    @Step("Заполнить поля логина и пароль, нажать кнопку Войти")
    public MainPage login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return new MainPage(webDriver);
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
}
