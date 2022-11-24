package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConstructorSection {
    private final ElementsCollection burgetParts = $$(byXpath(".//div[@style='display: flex;']//div"));
    private final SelenideElement constructorLabel = $(byXpath(".//h1[text()='Соберите бургер']"));

    public void checkMainLabel() {
        constructorLabel.shouldBe(visible, Duration.ofSeconds(10));
    }

    //получение названия активной вкладки
    public String getNameOfTheSection() {
        return $(byXpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[@class='text text_type_main-default']")).getText();
    }

    //клик секция Булки
    public void bunsSectionButton() {
        burgetParts.get(0).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    //клик секция Соусы
    public void saucesSectionButton() {
        burgetParts.get(1).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    //клик секция Начинки
    public void fillingsSectionButton() {
        burgetParts.get(2).shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}
