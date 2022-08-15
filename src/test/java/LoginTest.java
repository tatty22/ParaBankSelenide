import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;

import static app.AppConfig.password;
import static app.AppConfig.userName;

public class LoginTest extends AbstractTest{
    @Story("Новый пользователь")
    @Test (description = "Добавление нового пользователя")
    public void addNewUser() throws IOException {
        app.basePage.open();
        app.basePage.goToRegisterPage();
        app.registerPage.register();

        softAssert.assertEquals(2,2);
        softAssert.assertAll();

        attachScreen();
    }
    @Story("Новый пользователь")
    @Test (dependsOnMethods= "addNewUser", description = "Вход в Систему")
    public void login() {
        app.basePage.open();
        app.basePage.login(userName, password);

        logger.info("Sample info message");

        softAssert.assertEquals(2,2);
        softAssert.assertAll();
    }
}
