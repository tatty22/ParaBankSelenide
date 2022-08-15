import app.App;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import helpers.Driver;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

@Listeners({TestListener.class})
public abstract class AbstractTest {
    protected App app;
    protected SoftAssert softAssert;
    protected Logger logger;

    @BeforeClass
    public void setUp() {
        Driver.initDriver();

        app = new App();
        softAssert = new SoftAssert();
        logger = LogManager.getLogger("");
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        ScreenShooter.captureSuccessfulTests = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                                                .screenshots(true).savePageSource(true));
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies();
    }

    @AfterClass
    public void tearDown(){
        Driver.close();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] attachScreen() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();

        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
}
