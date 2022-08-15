package app;

import app.pages.BasePage;
import app.pages.RegisterPage;

public class PageBuilder {
    public static BasePage buildBasePage() {
        return new BasePage(AppConfig.baseUrl);
    }
    public static RegisterPage buildRegisterPage() {
        return new RegisterPage(AppConfig.registerUrl);
    }
}
