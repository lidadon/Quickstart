package ru.geekbrains.homework8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage {

    private SelenideElement projectName = $(By.name("crm_project[name]"));

    @Step("Заполнить название проекта")
    public CreateProjectPage fillProjectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    private SelenideElement organisationNameField = $(By.xpath("//span[.='Укажите организацию']"));

    @Step("Клик на поле Организация")
    public CreateProjectPage organisationNameFieldClick() {
        organisationNameField.click();
        return this;
    }

    private SelenideElement organisationName = $(By.xpath("//div[.='123test']"));

    @Step("Выбрать название организации")
    public CreateProjectPage organisationNameClick() {
        organisationName.click();
        return this;
    }

    private SelenideElement prioritySelect = $(By.name("crm_project[priority]"));

    @Step("Выбрать приоритет")
    public CreateProjectPage selectPriority(String option) {
        prioritySelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement financeSourceSelect = $(By.name("crm_project[financeSource]"));

    @Step("Выбрать источник финансирования")
    public CreateProjectPage selectFinanceSource(String option) {
        financeSourceSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement businessUnitSelect = $(By.name("crm_project[businessUnit]"));

    @Step("Выбрать подразделение")
    public CreateProjectPage selectBusinessUnit(String option) {
        businessUnitSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement curatorSelect = $(By.name("crm_project[curator]"));

    @Step("Выбрать куратора")
    public CreateProjectPage selectCurator(String option) {
        curatorSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement projectAdminSelect = $(By.name("crm_project[rp]"));

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectProjectAdmin(String option) {
        projectAdminSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement projectManagerSelect = $(By.name("crm_project[manager]"));

    @Step("Выбрать менеджера")
    public CreateProjectPage selectProjectManager(String option) {
        projectManagerSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement contactNameField = $(By.xpath("//div[@class='select2-container select2']//a[@class='select2-choice']"));

    @Step("Клик на поле Основное контактное лицо")
    public CreateProjectPage contactNameFieldClick() {
        contactNameField.click();
        return this;
    }

    private SelenideElement contactName = $(By.xpath("//div[.='1111 22222']"));

    @Step("Выбрать контактное лицо")
    public CreateProjectPage contactNameClick() {
        contactName.click();
        return this;
    }

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(), 'закрыть')]"));

    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateProjectPage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }

    public SelenideElement projectCreationSuccess = $(By.xpath("//*[.='Проект сохранен']"));
}
