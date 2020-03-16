package domrf.helpers.click;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Action
{
    private AppiumDriver driver;

    public Action(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public Condition andWaitUntil(MobileElement element)
    {
        return new Condition(this.driver, element);
    }

    public Condition andWaitUntil(By by)
    {
        return new Condition(this.driver, by);
    }

    public Action andSleep(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return this;
    }

}
