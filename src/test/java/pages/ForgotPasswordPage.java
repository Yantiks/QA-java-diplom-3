package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    //открыть страницу https://stellarburgers.nomoreparties.site/forgot-password
    public void openWebSite (String url){
        Selenide.open(url);
    }

    //найти заголовок Восстановление пароля
    private final SelenideElement recoveryLabel = $(byXpath("/html/body/div/div/main/div/h2"));

    public void waitForLoadForgotPasswordPage (){
        recoveryLabel.shouldBe(Condition.visible);
    }

    //найти кнопку Войти
    private final SelenideElement enterButton = $(byXpath("/html/body/div/div/main/div/div/p/a"));

    //нажать на кнопку Войти
    public void clickEnterButton() {
        enterButton.click();
    }


}
