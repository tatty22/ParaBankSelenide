package app.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public abstract class AbstractPage {
    protected String pageUrl;

    public AbstractPage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @Step("Переход на главную страницу приложения")
    public void open() {
        Selenide.open(pageUrl);
    }
}
