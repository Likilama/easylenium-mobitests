package domrf.helpers.send;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;

public class Send
{
    private AppiumDriver driver;

    public Send(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public Data text(String text)
    {
        return new Data(this.driver, text);
    }

    public Data key(Keys keys)
    {
        return new Data(this.driver, keys);
    }
}
