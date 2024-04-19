package selenide_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selenide.*;

@Epic("Индексация")
@Feature("Завершение процесса индексации")
public class TestCompleteIndexing extends BaseTest {

    @Test
    @Owner("Соминский Антон")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка завершения индексации")
    @DisplayName("Завершение индексации страниц")
    @Description("Проверка, что индексация всех страниц успешно завершается.")
    public void testCompleteIndexing() {
        mainPage.clickManagementTab()
                .clickStartIndexing()
                .clickDashboardTab();
        refresh();
        sleep(5000);
        mainPage.waitUntilAllIndexed();
        screenshot("CompleteIndexing");
    }
}