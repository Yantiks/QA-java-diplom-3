package tests;

import dto.User;
import dto.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.*;

public class LoginTest {
    private final static String REGISTR_URL = "https://stellarburgers.nomoreparties.site/register";
    private final static String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private final static String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ConstructorSection constructorSection = new ConstructorSection();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private PrivateCabPage privateCabPage = new PrivateCabPage();
    private User user = UserGenerator.getRandomUser();

    @Before
    public void register() {
        registerPage.openWebSite(REGISTR_URL);
        registerPage.enterName(user.getName());
        registerPage.enterEmail(user.getEmail());
        registerPage.enterPassword(user.getPassword());
        registerPage.clickRegisterButton();
        loginPage.waitForLoadLoginPage();
    }

    @After
    public void logout() {
        privateCabPage.clickPrivateCabButton();
        privateCabPage.clickLogoutButton();
        loginPage.waitForLoadLoginPage();
    }

    //вход по кнопке «Войти» на главной
    @Test
    @DisplayName("Successful login with the Login button")
    public void enterAccountButtonTest() {
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        constructorSection.checkMainLabel();
    }

    //вход через кнопку «Личный кабинет»
    @Test
    @DisplayName("Successful login with the Login button")
    public void enterPrivateCabTest() {
        loginPage.openWebSite(MAIN_URL);
        loginPage.clickPrivateCabButton();
        loginPage.waitForLoadLoginPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        constructorSection.checkMainLabel();
    }

    //вход через кнопку в форме регистрации
    @Test
    @DisplayName("Successful login with the Login button on the Registration page")
    public void enterFromRegistrationFormTest() {
        loginPage.openWebSite(REGISTR_URL);
        registerPage.clickEnterButton();
        loginPage.waitForLoadLoginPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        constructorSection.checkMainLabel();
    }

    //вход через кнопку в форме восстановления пароля
    @Test
    @DisplayName("Successful login with the Login button on the Password recovery page")
    public void enterWithPasswordRecoveryTest() {
        loginPage.clickRecoveryPasswordButton();
        forgotPasswordPage.clickEnterButton();
        loginPage.waitForLoadLoginPage();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        constructorSection.checkMainLabel();
    }
}
