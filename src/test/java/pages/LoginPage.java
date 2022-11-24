package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement enterLabel = $(byXpath(".//h2[text()='Вход']"));
    //найти поле Email
    private final SelenideElement emailField = $(byXpath(".//input[@type='text']"));
    //найти поле Пароль
    private final SelenideElement passwordField = $(byName("Пароль"));
    //найти кнопку Войти
    private final SelenideElement loginButton = $(byXpath(".//button[text()='Войти']"));
    //найти кнопку Личный Кабинет
    private final SelenideElement privateCabButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    //найти кнопку Восставновить пароль
    private final SelenideElement recoveryPasswordButton = $(byXpath(".//a[@href='/forgot-password']"));

    //открыть страницу https://stellarburgers.nomoreparties.site/login
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    public void waitForLoadLoginPage() {
        enterLabel.shouldBe(Condition.visible);
    }

    //ввести значение в поле Email
    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    //ввести значение в поле Пароль
    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    //нажать кнопку Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    //нажать на кнопку Личный Кабинет
    public void clickPrivateCabButton() {
        privateCabButton.click();
    }

    //нажать на кнопку Восставновить пароль
    public void clickRecoveryPasswordButton() {
        recoveryPasswordButton.click();
    }
}
