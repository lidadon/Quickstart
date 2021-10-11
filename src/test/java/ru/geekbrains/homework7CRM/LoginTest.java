package ru.geekbrains.homework7CRM;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.homework7CRM.CreateProjectPage;
import ru.geekbrains.homework7CRM.LoginPage;
import ru.geekbrains.homework7CRM.MainPage;
import ru.geekbrains.homework7CRM.ProjectsSubMenu;

@Story("Создание нового проекта")
public class LoginTest extends BaseTest {
    public static final String CRM_URL = "https://crm.geekbrains.space/";
    public static final String LOGIN = "Applanatest1";
    public static final String PASSWORD = "Student2020!";


    @BeforeEach
    void getURL() {
        webDriver.get(CRM_URL);
    }

    @Test
    @Description("Создание нового проекта")
    void loginTest() {
        new LoginPage(webDriver)
                .login(LOGIN, PASSWORD);

        new MainPage(webDriver).navigationMenu.openNavigationSubMenuItems("Проекты");

        new ProjectsSubMenu(webDriver)
                .allProjectsButtonClick()
                .CreateProjectButtonClick();

        new CreateProjectPage(webDriver)
                .fillProjectName("New Project 3546")
                .organisationNameFieldClick()
                .organisationNameClick()
                .selectPriority("Низкий")
                .selectFinanceSource("Внутреннее")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectAdmin("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .contactNameFieldClick()
                .contactNameClick()
                .saveAndCloseButtonClick();

        webDriverWait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//div[@class='loader-frame well']"))));
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[.='Проект сохранен']")).isDisplayed());
    }
}
