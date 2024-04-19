package selenide_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.*;

@Epic("Поиск")
@Feature("Функциональность поиска")
public class TestSearchFunctionality extends BaseTest {

    @Test
    @Owner("Соминский Антон")
    @Severity(SeverityLevel.NORMAL)
    @Story("Поиск по частичному совпадению")
    @DisplayName("Осуществление поиска по фрагменту текста")
    @Description("Проверка функциональности поиска с вводом фрагмента слова и проверка результатов.")
    public void testSearchFunctionality() {
        mainPage.clickSearchTab()
                .performSearch("тел");
        $("strong.SearchResult-title").shouldHave(text("Found"));
        int resultsCount = Integer.parseInt($("span.SearchResult-amount").text());
        assert resultsCount >= 0 : "Results count should be non-negative";
        screenshot("SearchResults");
    }
}