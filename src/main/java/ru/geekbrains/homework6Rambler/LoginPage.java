package ru.geekbrains.homework6Rambler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver webDriver;

    @FindBy (name = "login")
    public WebElement inputLogin;

    @FindBy (name = "password")
    public WebElement inputPassword;

    @FindBy (xpath = "//span[@class='rui-Button-content']")
    public WebElement buttonLogin;

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
