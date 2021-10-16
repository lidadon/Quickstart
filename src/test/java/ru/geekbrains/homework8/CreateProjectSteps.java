package ru.geekbrains.homework8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectSteps {
    @Given("^I am authorized$")
    public void iAmAuthorized() {
        new LoginPage().login("Applanatest1", "Student2020!");
    }

    @Given("i hover  projects menu")
    public void iHoverProjectsMenu() {
        new MainPage().navigationMenu.openNavigationSubMenuItems("Проекты");
    }

    @And("i click all projects button")
    public void iClickAllProjectsButton() {
        new ProjectsSubMenu().allProjectsButtonClick();
    }

    @And("i click create project button")
    public void iClickCreateProjectButton() {
        new ProjectsPage().CreateProjectButtonClick();
    }

    @When("^i fill project name field$")
    public void iFillProjectNameField() {
        new CreateProjectPage().fillProjectName("New Project 07292986352");
    }

    @And("i click on organisation name field")
    public void iClickOnOrganisationNameField() {
        new CreateProjectPage().organisationNameFieldClick();
    }

    @And("^i click on organisation name$")
    public void iClickOnOrganisationName() {
        new CreateProjectPage().organisationNameClick();
    }

    @And("^i select priority$")
    public void iSelectPriority() {
        new CreateProjectPage().selectPriority("Низкий");
    }

    @And("^i select finance source$")
    public void iSelectFinanceSource() {
        new CreateProjectPage().selectFinanceSource("Внутреннее");
    }

    @And("^i select business unit$")
    public void iSelectBusinessUnit() {
        new CreateProjectPage().selectBusinessUnit("Research & Development");
    }

    @And("^i select curator$")
    public void iSelectCurator() {
        new CreateProjectPage().selectCurator("Applanatest1 Applanatest1 Applanatest1");
    }

    @And("^i select project admin$")
    public void iSelectProjectAdmin() {
        new CreateProjectPage().selectProjectAdmin("Applanatest1 Applanatest1 Applanatest1");
    }

    @And("^i select project manager$")
    public void iSelectProjectManager() {
        new CreateProjectPage().selectProjectManager("Applanatest1 Applanatest1 Applanatest1");
    }

    @And("i click on contact name field")
    public void iClickOnContactNameField() {
        new CreateProjectPage().contactNameFieldClick();
    }

    @And("^i click on contact name$")
    public void iClickOnContactName() {
        new CreateProjectPage().contactNameClick();
    }

    @And("^i click save and close button$")
    public void iClickSaveAndCloseButton() {
        new CreateProjectPage().saveAndCloseButtonClick();
    }

    @Then("^i see success message$")
    public void iSeeSuccessMessage() {
        new CreateProjectPage().projectCreationSuccess.shouldHave(Condition.exactText("Проект сохранен"));
    }
}