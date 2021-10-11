package ru.geekbrains.homework7CRM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseElements {
    @FindBy (xpath = "//span[.='Все проекты']")
    public WebElement allProjectsButton;

    public ProjectsSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку Все проекты")
    public ProjectsPage allProjectsButtonClick() {
        allProjectsButton.click();
        return new ProjectsPage(webDriver);
    }
}
