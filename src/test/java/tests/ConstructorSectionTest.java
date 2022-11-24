package tests;

import dto.User;
import dto.UserGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.ConstructorSection;
import pages.LoginPage;
import pages.PrivateCabPage;
import pages.RegisterPage;

public class ConstructorSectionTest {
    private final static String REGISTR_URL = "https://stellarburgers.nomoreparties.site/register";

    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ConstructorSection constructorSection = new ConstructorSection();
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
        constructorSection.checkMainLabel();
    }

    @After
    public void logout() {
        privateCabPage.clickPrivateCabButton();
        privateCabPage.clickLogoutButton();
        loginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Successful jump to section Buns")
    public void isBunsActive() {
        constructorSection.saucesSectionButton();
        Assert.assertEquals("Соусы", constructorSection.getNameOfTheSection());
        constructorSection.bunsSectionButton();
        Assert.assertEquals("Булки", constructorSection.getNameOfTheSection());
    }

    @Test
    @DisplayName("Successful jump to section Sauces")
    public void isSaucesActive() {
        constructorSection.saucesSectionButton();
        Assert.assertEquals("Соусы", constructorSection.getNameOfTheSection());
    }

    @Test
    @DisplayName("Successful jump to section Filling")
    public void isFillingsActive() {
        constructorSection.fillingsSectionButton();
        Assert.assertEquals("Начинки", constructorSection.getNameOfTheSection());
    }
}
