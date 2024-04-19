package selenide_tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import selenide_tests.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public abstract class BaseTest {
    protected MainPage mainPage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "http://localhost:8080";
        Configuration.browserSize = "1920x1080";
        open("/");
        mainPage = new MainPage();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}