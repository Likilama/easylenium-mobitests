package domrf.helpers;

import io.appium.java_client.AppiumDriver;

public class BaseHelper {

    AppiumDriver driver;

    public BaseHelper(AppiumDriver driver)
    {
        this.driver = driver;
    }

    protected AppiumDriver getDriver()
    {
        return this.driver;
    }

}
