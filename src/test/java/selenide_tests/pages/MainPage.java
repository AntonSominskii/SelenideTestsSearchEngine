package selenide_tests.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.function.Supplier;

public class MainPage {

    public int countHideBlocks() {
        return $$("div.HideBlock.HideBlock_CLOSE").size();
    }

    public MainPage clickManagementTab() {
        $(byText("Management")).click();
        return this;
    }

    public MainPage clickStartIndexing() {
        $(byText("Start indexing")).click();
        return this;
    }

    public MainPage clickDashboardTab() {
        $(byText("Dashboard")).click();
        return this;
    }

    public MainPage clickSearchTab() {
        $(byText("Search")).click();
        return this;
    }

    public MainPage performSearch(String query) {
        $("#query").setValue(query);
        $x("//input[@id='query']/following-sibling::button[contains(text(), 'Search')]").click();
        return this;
    }

    public MainPage addUpdatePage(String url) {
        $("input#page").setValue(url);
        $("button.btn.btn_primary.form-btn").click();
        return this;
    }

    public void waitUntilAllIndexed() {
        refreshUntil(() -> $$("span.Statistics-status_checked").filterBy(Condition.text("INDEXED")).size() == 2);
    }

    private void refreshUntil(Supplier<Boolean> condition) {
        while (!condition.get()) {
            refresh();
            sleep(5000);
        }
    }
}