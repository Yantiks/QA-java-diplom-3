package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

public class ConfigForTest {
    public void setUp () {

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = false;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    //перед каждым запуском теста выполнить найстройки, описанные выше
    @Before
    public void unit() {setUp();}

    //после каждого теста нужно закрыть веб-драйвер
    @After
    public void tearDown() {Selenide.closeWebDriver();}
}
