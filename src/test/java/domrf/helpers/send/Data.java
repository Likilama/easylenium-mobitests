package domrf.helpers.send;

import domrf.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Data
{
    private AppiumDriver driver;
    private WebDriverWait wait;
    private String text;
    private Keys key;

    public Data(AppiumDriver driver, String text)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
        this.text = text;
    }

    public Data(AppiumDriver driver, Keys keys)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Configuration.GLOBAL_TIMEOUTS);
        this.key = keys;
    }

    public Where to(MobileElement element)
    {
        if (this.text == null)
        {
            element.sendKeys(key);
        }
        else
         {
            element.sendKeys(text);
            try
            {
                wait.until(ExpectedConditions.attributeToBe(element, "value", text));
            }
            catch (TimeoutException ex)
            {
                ex.printStackTrace();
                throw new RuntimeException("Не удалось ввести текст в указанный элемент");
            }
        }
        return new Where(driver);
    }

    public Where by(By by)
    {
        if (this.text == null)
        {
            driver.findElement(by).sendKeys(key);
        }
        else
        {
            driver.findElement(by).sendKeys(text);
            try
            {
                wait.until(ExpectedConditions.attributeToBe(by, "value", text));
            }
            catch (TimeoutException ex)
            {
                ex.printStackTrace();
                throw new RuntimeException("Не удалось ввести текст в указанный элемент");
            }
        }
        return new Where(driver);
    }

}
