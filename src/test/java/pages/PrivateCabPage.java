package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PrivateCabPage {
    public void openWebSite (String url){
        Selenide.open(url);
    }

    //найти кнопку Личный Кабинет
    private final SelenideElement privateCabButton = $(byXpath("/html/body/div/div/header/nav/a/p"));

    //нажать на кнопку Личный Кабинет
    public void clickPrivateCabButton() {
        privateCabButton.click();
    }

    //проверить URL страницы
    public String checkCurrentUrl() {return url();}

    //найти кнопку Конструктор
    private final SelenideElement constructorButton = $(byXpath("/html/body/div/div/header/nav/ul/li[1]/a/p"));

    //кликнуть
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //найти кнопку Stellar burgers
    private final SelenideElement burgersButton = $(byXpath("/html/body/div/div/header/nav/div/a"));

    //кликнуть
    public void clickBurgersButton() {
        burgersButton.click();
    }

    public void burgerLabelIsVisible() {
        burgersButton.shouldBe(visible);
    }

    //найти кнопку Выход
    private final SelenideElement logoutButton = $(byXpath("/html/body/div/div/main/div/nav/ul/li[3]/button"));

    //кликнуть
    public void clickLogoutButton() {
        logoutButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }
    //public void logoutButtonisVisible() {logoutButton.shouldBe(visible, Duration.ofSeconds(10)).click() ;}


}
