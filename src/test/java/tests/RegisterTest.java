package tests;

import dto.User;
import dto.UserGenerator;
import org.junit.Test;
import pages.ConstructorSection;
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPage;
import pages.PrivateCabPage;
import pages.RegisterPage;

public class RegisterTest {
    private final static String MAIN_URL = "https://stellarburgers.nomoreparties.site/register";
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ConstructorSection constructorSection = new ConstructorSection();
    private User user = UserGenerator.getRandomUser();
    private PrivateCabPage privateCabPage = new PrivateCabPage();

    //успешная регистрация
    @Test
    @DisplayName("Successful Registration")
    public void successfulRegistrationTest() {
        registerPage.openWebSite(MAIN_URL);
        registerPage.enterName(user.getName());
        registerPage.enterEmail(user.getEmail());
        registerPage.enterPassword(user.getPassword());
        registerPage.clickRegisterButton();
        loginPage.waitForLoadLoginPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        privateCabPage.clickPrivateCabButton();
        privateCabPage.clickLogoutButton();
        loginPage.waitForLoadLoginPage();
    }

    //Ошибку для некорректного пароля. Минимальный пароль — шесть символов
    @Test
    @DisplayName("Check the message error with the incorrect password")
    public void incorrectPasswordTest() {
        registerPage.openWebSite(MAIN_URL);
        registerPage.enterPassword("12345");
        registerPage.clickRegisterButton();
        registerPage.checkPasswordLabel();
    }
}
