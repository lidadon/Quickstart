package ru.geekbrains.homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {
    private SelenideElement createProjectButton = $(By.xpath("//a[.='Создать проект']"));

    @Step("Клик на кнопку Создать проект")
    public void CreateProjectButtonClick() {
        createProjectButton.click();
    }
}
