package selenide_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;
import io.qameta.allure.*;

@Epic("Управление страницами")
@Feature("Добавление и обновление страниц")
public class TestAddUpdatePage extends BaseTest {

    @Test
    @Owner("Соминский Антон")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Добавление страницы для обновления")
    @DisplayName("Добавление страницы в очередь на обновление")
    @Description("Проверка, что страница корректно добавляется в очередь на обновление через управление.")
    public void testAddUpdatePage() {
        mainPage.clickManagementTab()
                .addUpdatePage("https://www.svetlovka.ru/services");
        $("div.API-success").shouldHave(text("Страница поставлена в очередь на обновление / добавление"));
        screenshot("PageUpdateQueued");
    }
}