package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    //открыть страницу https://stellarburgers.nomoreparties.site/login
    public void openWebSite (String url){
        Selenide.open(url);
    }
    private final SelenideElement enterLabel = $(byXpath("/html/body/div/div/main/div/h2"));

    public void waitForLoadLoginPage (){
        enterLabel.shouldBe(Condition.visible);
    }

    //поля с формы входа
    //найти поле Email
    private final SelenideElement emailField = $(byXpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input"));

    //ввести значение в поле Email
    public void enterEmail(String email) {
        emailField.setValue(email);
    }

    //найти поле Пароль
    private final SelenideElement passwordField = $(byXpath("//input[@name='Пароль']"));

    //ввести значение в поле Пароль
    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    //найти кнопку Войти
    private final SelenideElement loginButton = $(byXpath("/html/body/div/div/main/div/form/button"));

    //нажать кнопку Войти
    public void clickLoginButton() {
        loginButton.click();
    }

    //найти кнопку Личный Кабинет
    private final SelenideElement privateCabButton = $(byXpath("/html/body/div/div/header/nav/a/p"));

    //нажать на кнопку Личный Кабинет
    public void clickPrivateCabButton() {
        privateCabButton.click();
    }

    //найти кнопку Восставновить пароль
    private final SelenideElement recoveryPasswordButton = $(byXpath("/html/body/div/div/main/div/div/p[2]/a"));

    //нажать на кнопку Восставновить пароль
    public void clickRecoveryPasswordButton() {
        recoveryPasswordButton.click();
    }



}
