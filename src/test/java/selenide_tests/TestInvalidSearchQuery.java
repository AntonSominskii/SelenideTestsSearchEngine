package selenide_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.*;

@Epic("Поиск")
@Feature("Обработка некорректного запроса")
public class TestInvalidSearchQuery extends BaseTest {

    @Test
    @Owner("Соминский Антон")
    @Severity(SeverityLevel.MINOR)
    @Story("Поиск с некорректным запросом")
    @DisplayName("Поиск с невалидными символами")
    @Description("Проверка, что система корректно обрабатывает некорректный поисковый запрос.")
    public void testInvalidSearchQuery() {
        mainPage.clickSearchTab()
                .performSearch("!@#$%^&*()");
        $("strong.SearchResult-title").shouldHave(text("Found 0 results"));
        screenshot("InvalidSearchResults");
    }
}