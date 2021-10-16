package ru.geekbrains.homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsSubMenu {
    private SelenideElement allProjectsButton = $(By.xpath("//span[.='Все проекты']"));

    @Step("Клик на кнопку Все проекты")
    public ProjectsPage allProjectsButtonClick() {
        allProjectsButton.click();
        return page(ProjectsPage.class);
    }
}
