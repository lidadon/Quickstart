package ru.geekbrains.homework6CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElements {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BaseElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }
}
