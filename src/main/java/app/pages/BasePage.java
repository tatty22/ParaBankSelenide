package app.pages;

import app.AppConfig;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage extends AbstractPage {
    private SelenideElement loginField = $x("//input[@name='username']");
    private SelenideElement passwordField = $x("//input[@name='password']");
    private SelenideElement registerLink = $x("//a[text()[contains(.,'Register')]]");
    private SelenideElement signInButton = $x("//input[@value='Log In']");

    public BasePage(String pageUrl) {
        super(pageUrl);
    }

    @Step("Вход в Систему")
    public void login(String username, String password) {
        loginField.setValue(username);
        passwordField.setValue(password);
        signInButton.click();
        Driver.waitForUrlContains("overview.htm");
    }

    @Step("Переход к странице регистрации нового пользователя")
    public RegisterPage goToRegisterPage() {
        registerLink.click();
        return new RegisterPage(AppConfig.registerUrl);
    }
}