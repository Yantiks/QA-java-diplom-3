package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PrivateCabPage {
    //найти кнопку Личный Кабинет
    private final SelenideElement privateCabButton = $(byXpath(".//p[text()='Личный Кабинет']"));
    //найти кнопку Конструктор
    private final SelenideElement constructorButton = $(byXpath(".//p[text()='Конструктор']"));
    //найти кнопку Stellar burgers
    private final SelenideElement burgersButton = $(byXpath(".//a[@href='/']"));
    //найти кнопку Выход
    private final SelenideElement logoutButton = $(byXpath(".//button[@type='button']"));

    //нажать на кнопку Личный Кабинет
    public void clickPrivateCabButton() {
        privateCabButton.click();
    }

    //проверить URL страницы
    public String checkCurrentUrl() {
        return url();
    }

    //кликнуть кнопку Конструктор
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //кликнуть кнопку Stellar burgers
    public void clickBurgersButton() {
        burgersButton.click();
    }

    public void burgerLabelIsVisible() {
        burgersButton.shouldBe(visible);
    }

    //кликнуть кнопку Выход
    public void clickLogoutButton() {
        logoutButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}
