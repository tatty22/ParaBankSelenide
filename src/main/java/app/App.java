package app;

import app.pages.BasePage;
import app.pages.RegisterPage;

public class App {
    public BasePage basePage;
    public RegisterPage registerPage;

    public App() {
        basePage = PageBuilder.buildBasePage();
        registerPage = PageBuilder.buildRegisterPage();
    }
}

