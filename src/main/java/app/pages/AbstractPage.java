package app.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriverException;

public abstract class AbstractPage {
    protected String pageUrl;
    private final static int MAX_RETRY_COUNT = 5;

    public AbstractPage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @Step("Переход на главную страницу приложения")
    public void open() {
        int retryCount = 0;
        while(true)
        {
            try
            {
                Selenide.open(pageUrl);
                break;
            }
            catch(WebDriverException e)
            {
                if( retryCount > MAX_RETRY_COUNT )
                {
                    throw new RuntimeException("Too many retries...", e);
                }

//                logger.warn("encountered exception : ", e);
//                logger.warn("Trying again...");

                retryCount++;
                try
                {
                    Thread.sleep(2_000);
                }
                catch (InterruptedException interruptedException)
                {
                    interruptedException.printStackTrace();
                }
                continue;
            }
        }
    }
}
