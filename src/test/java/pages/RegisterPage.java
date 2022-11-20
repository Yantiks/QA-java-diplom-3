package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    //открыть страницу https://stellarburgers.nomoreparties.site/register
    public void openWebSite (String url){
        Selenide.open(url);
    }

    //поля с формы регистрации
    //найти поле Имя
    private final SelenideElement nameField = $(byXpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input"));

    //ввести значение в поле Имя
    public void enterName(String name) {
        nameField.setValue(name);
    }

    //найти поле Email
    private final SelenideElement emailField = $(byXpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input"));

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

    //найти кнопку Зарегистироваться
    private final SelenideElement registerButton = $(byXpath("/html/body/div/div/main/div/form/button"));

    //кликнуть по кнопке Зарегистрироваться
    public void clickRegisterButton() {
        registerButton.click();
    }

    //найти ошибку о некорректном количестве символов в пароле
    private final SelenideElement incorrectPasswordLabel = $(byXpath("/html/body/div/div/main/div/form/fieldset[3]/div/p"));

    //проверка текста ошибки
    public void checkPasswordLabel (){
        incorrectPasswordLabel.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    //найти кнопку Войти на форме регистрации
    private final SelenideElement enterButton = $(byXpath("/html/body/div/div/main/div/div/p/a"));

    //кликнуть по кнопке Войти
    public void clickEnterButton() {
        enterButton.click();
    }
}
