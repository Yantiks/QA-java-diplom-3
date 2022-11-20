package tests;

import dto.User;
import dto.UserGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPage;
import pages.PrivateCabPage;
import pages.RegisterPage;

public class PrivateCabTest {
    private final static String REGISTR_URL = "https://stellarburgers.nomoreparties.site/register";
    private final static String PRIVATE_CAB_URL = "https://stellarburgers.nomoreparties.site/account";
    private final static String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
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
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        privateCabPage.clickPrivateCabButton();
    }

    @After
    public void logout() {
        privateCabPage.clickPrivateCabButton();
        privateCabPage.clickLogoutButton();
        loginPage.waitForLoadLoginPage();
    }

    //Проверь переход по клику на «Личный кабинет»
    @Test
    @DisplayName("Successful jump to the Private cabinet page")
    public void enterPrivateCabTest() {
        Assert.assertEquals(PRIVATE_CAB_URL, privateCabPage.checkCurrentUrl());
    }

    //Переход из личного кабинета в конструктор
    //Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
    //переход по клику на «Конструктор»
    @Test
    @DisplayName("Successful jump with the Constructor button")
    public void clickOnStellarBurgersTest() {
        Assert.assertEquals(PRIVATE_CAB_URL, privateCabPage.checkCurrentUrl());
        privateCabPage.clickConstructorButton();
        Assert.assertEquals(MAIN_URL, privateCabPage.checkCurrentUrl());
    }

    //переход по клику на логотип Stellar Burgers
    @Test
    @DisplayName("Successful jump with the Stellar Burgers button")
    public void clickOnConstructorTest() {
        Assert.assertEquals(PRIVATE_CAB_URL, privateCabPage.checkCurrentUrl());
        privateCabPage.burgerLabelIsVisible();
        privateCabPage.clickBurgersButton();
        Assert.assertEquals(MAIN_URL, privateCabPage.checkCurrentUrl());
    }
}
