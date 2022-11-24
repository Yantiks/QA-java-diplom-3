package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    //найти заголовок Восстановление пароля
    private final SelenideElement recoveryLabel = $(byXpath(".//a[@href='/forgot-password']"));
    //найти кнопку Войти
    private final SelenideElement enterButton = $(byXpath(".//a[@href='/login']"));

    //открыть страницу https://stellarburgers.nomoreparties.site/forgot-password
    public void openWebSite(String url) {
        Selenide.open(url);
    }

    public void waitForLoadForgotPasswordPage() {
        recoveryLabel.shouldBe(Condition.visible);
    }

    //нажать на кнопку Войти
    public void clickEnterButton() {
        enterButton.click();
    }
}
