package ru.geekbrains.homework7CRM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseElements {
    public CreateProjectPage(WebDriver webDriver) {
        super(webDriver);
    }

    final static String  projectNameNameLocator = "crm_project[name]";
    @FindBy (name = projectNameNameLocator)
    public WebElement projectName;

    @Step("Заполнить название проекта")
    public CreateProjectPage fillProjectName(String name) {
        projectName.sendKeys(name);
        return this;
    }

    @FindBy (xpath = "//span[.='Укажите организацию']")
    public WebElement organisationNameField;

    @Step("Клик на поле Организация")
    public CreateProjectPage organisationNameFieldClick() {
        organisationNameField.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(organisationNameXpathLocator)));
        return this;
    }

    public static String organisationNameXpathLocator = "//div[.='123test']";
    @FindBy (xpath = "//div[.='123test']")
    public WebElement organisationName;

    @Step("Выбрать название организации")
    public CreateProjectPage organisationNameClick() {
        organisationName.click();
        return this;
    }

    @FindBy (name = "crm_project[priority]")
    public WebElement prioritySelect;

    @Step("Выбрать приоритет")
    public CreateProjectPage selectPriority(String option) {
        new Select(prioritySelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (name = "crm_project[financeSource]")
    public WebElement financeSourceSelect;

    @Step("Выбрать источник финансирования")
    public CreateProjectPage selectFinanceSource(String option) {
        new Select(financeSourceSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    @Step("Выбрать подразделение")
    public CreateProjectPage selectBusinessUnit(String option) {
        new Select(businessUnitSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (name = "crm_project[curator]")
    public WebElement curatorSelect;

    @Step("Выбрать куратора")
    public CreateProjectPage selectCurator(String option) {
        new Select(curatorSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (name = "crm_project[rp]")
    public WebElement projectAdminSelect;

    @Step("Выбрать руководителя проекта")
    public CreateProjectPage selectProjectAdmin(String option) {
        new Select(projectAdminSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (name = "crm_project[manager]")
    public WebElement projectManagerSelect;

    @Step("Выбрать менеджера")
    public CreateProjectPage selectProjectManager(String option) {
        new Select(projectManagerSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy (xpath = "//div[@class='select2-container select2']//a[@class='select2-choice']")
    public WebElement contactNameField;

    @Step("Клик на поле Основное контактное лицо")
    public CreateProjectPage contactNameFieldClick() {
        contactNameField.click();
        return this;
    }

    @FindBy (xpath = "//div[.='1111 22222']")
    public WebElement contactName;

    @Step("Выбрать контактное лицо")
    public CreateProjectPage contactNameClick() {
        contactName.click();
        return this;
    }

    @FindBy (xpath = "//button[contains(text(), 'закрыть')]")
    public WebElement saveAndCloseButton;

    @Step("Клик на кнопку Сохранить и закрыть")
    public CreateProjectPage saveAndCloseButtonClick() {
        saveAndCloseButton.click();
        return this;
    }
}
