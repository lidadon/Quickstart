package ru.geekbrains.homework6CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseElements {
    @FindBy (xpath = "//span[.='Все проекты']")
    public WebElement allProjectsButton;

    public ProjectsSubMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public ProjectsPage allProjectsButtonClick() {
        allProjectsButton.click();
        return new ProjectsPage(webDriver);
    }
}
