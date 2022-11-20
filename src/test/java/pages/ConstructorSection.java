package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ConstructorSection {
    //открыть страницу https://stellarburgers.nomoreparties.site/login
    public void openWebSite (String url){
        Selenide.open(url);
    }

    private final SelenideElement constructorLabel = $(byXpath("/html/body/div/div/main/section[1]/h1"));

    public void checkMainLabel (){
        constructorLabel.shouldBe(visible, Duration.ofSeconds(30));
        constructorLabel.shouldHave(Condition.exactText("Соберите бургер"));
    }

    //секция Булки
    private final SelenideElement bunsSection = $(byXpath("/html/body/div/div/main/section[1]/div[1]/div[1]"));

    //клик
    public void bunsSectionButton() {
        bunsSection.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    //секция Соусы
    private final SelenideElement saucesSection = $(byXpath("/html/body/div/div/main/section[1]/div[1]/div[2]"));

    //клик
    public void saucesSectionButton() {
        saucesSection.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    //секция Начинки
    private final SelenideElement fillingsSection = $(byXpath("/html/body/div/div/main/section[1]/div[1]/div[3]"));

    //клик
    public void fillingsSectionButton() {
        fillingsSection.shouldBe(visible, Duration.ofSeconds(30)).click();
    }

    //получение класса Булок
    public String getAttributeBuns() {
        return bunsSection.getAttribute("class");
    }

    //получение класса Соусов
    public String getAttributeSauces() {
        return saucesSection.getAttribute("class");
    }

    //получение класса Начинок
    public String getAttributeFillings() {
        return fillingsSection.getAttribute("class");
    }
}
