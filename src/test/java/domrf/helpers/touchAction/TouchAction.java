package domrf.helpers.touchAction;

import domrf.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class TouchAction
{
    private AppiumDriver driver;
    private WebDriverWait wait;

    public TouchAction(AppiumDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Configuration.GLOBAL_TIMEOUTS);
    }

    public void singleTap(MobileElement element)
    {
        TouchActions actions = new TouchActions(driver);
        actions.singleTap(element);
        actions.perform();
    }

    public void doubleTap(MobileElement element)
    {
        TouchActions actions = new TouchActions(driver);
        actions.doubleTap(element);
        actions.perform();
    }

    public void swipeDown(MobileElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void swipeLeft(MobileElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "left");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void swipeRight(MobileElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "right");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

    public void swipeUp(MobileElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }

}
