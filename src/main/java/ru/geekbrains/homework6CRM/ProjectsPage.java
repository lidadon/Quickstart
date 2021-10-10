package ru.geekbrains.homework6CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BaseElements {

    public ProjectsPage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String createProjectButtonXpathLocator = "//a[.='Создать проект']";
    @FindBy(xpath = createProjectButtonXpathLocator)
    public WebElement createProjectButton;

    public void CreateProjectButtonClick() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createProjectButtonXpathLocator)));
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(CreateProjectPage.projectNameNameLocator)));
    }
}
