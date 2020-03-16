package domrf.helpers.click;

import domrf.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Condition
{
    private AppiumDriver driver;
    private WebDriverWait wait;
    private MobileElement element;
    private By by;

    public Condition(AppiumDriver driver, MobileElement element)
    {
        this.driver = driver;
        this.element = element;
        wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public Condition(AppiumDriver driver, By by)
    {
        this.driver = driver;
        this.by = by;
        wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public MobileElement toBeVisible()
    {
        MobileElement e;

        if (by == null)
        {
            e = (MobileElement)wait.until(ExpectedConditions.visibilityOf(element));
        }
        else if (element == null)
        {
            e = (MobileElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else
        {
            throw new RuntimeException("Не передан элемент, который нужно ожидать");
        }
        return e;
    }

}
