package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {
    //поля с формы регистрации
    //найти поля Имя и Email
    private final ElementsCollection FieldCollection = $$(byName("name"));
    //найти поле Пароль
    private final SelenideElement passwordField = $(byName("Пароль"));
    //найти кнопку Зарегистироваться
    private final SelenideElement registerButton = $(byXpath(".//button[text()='Зарегистрироваться']"));
    //найти ошибку о некорректном количестве символов в пароле
    private final SelenideElement incorrectPasswordLabel = $(byXpath(".//p[@class='input__error text_type_main-default']"));
    //найти кнопку Войти на форме регистрации
    private final SelenideElement enterButton = $(byXpath(".//a[@href='/login']"));

    //открыть страницу https://stellarburgers.nomoreparties.site/register
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    //ввести значение в поле Имя
    public void enterName(String name) {
        FieldCollection.get(0).setValue(name);
    }

    public void enterEmail(String email) {
        FieldCollection.get(1).setValue(email);
    }

    //ввести значение в поле Пароль
    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    //кликнуть по кнопке Зарегистрироваться
    public void clickRegisterButton() {
        registerButton.click();
    }

    //проверка текста ошибки
    public void checkPasswordLabel() {
        incorrectPasswordLabel.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    //кликнуть по кнопке Войти
    public void clickEnterButton() {
        enterButton.click();
    }
}
