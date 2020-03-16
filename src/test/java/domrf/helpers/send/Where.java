package domrf.helpers.send;

import domrf.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Where
{
    private WebDriverWait wait;

    public Where(AppiumDriver driver)
    {
        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public void andClickTo(MobileElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void andClickBy(By by)
    {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

}
