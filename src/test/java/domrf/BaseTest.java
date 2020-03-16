package domrf;

import domrf.helpers.ActionHelper;
import domrf.helpers.BaseHelper;
import domrf.helpers.click.Click;
import domrf.helpers.send.Send;
import domrf.helpers.touchAction.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private BaseHelper baseHelper;
    private ActionHelper actionHelper;
    private Send send;
    private Click click;
    private TouchAction touchAction;


    protected AppiumDriver driver;

    private DesiredCapabilities capabilities;
    private URL url;

    @BeforeTest(alwaysRun = true, description = "init settings")
    public void setUp() throws MalformedURLException
    {
        logger.info("Start init settings");

        // url host
        url = new URL("http://0.0.0.0:4723/wd/hub");

        logger.info("Start init capabilities");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ""); //iOS или Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ""); //версия ОС на эмуляторе или на реальном устройстве
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ""); //Имя устройства например iPhone 11 Pro Max
        capabilities.setCapability(MobileCapabilityType.UDID, ""); //id устройства
        capabilities.setCapability(MobileCapabilityType.APP, ""); //путь к приложению
        //capabilities.setCapability("autoAcceptAlerts", true); - автоматически прнимиает алерты, вроде вопроса о согласии на пуши
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET, true); - полный ребут эмулятора

        logger.info("Start init driver");
        try
        {
            driver = new IOSDriver(url, capabilities);
        }
        catch (Exception ex)
        {
            logger.error("Error! Coz: " + ex.getMessage());
        }
        logger.info("End init settings");

    }

    protected BaseHelper app()
    {
        if (this.baseHelper == null) {
            return new BaseHelper(driver);
        } else {
            return this.baseHelper;
        }
    }

    protected ActionHelper action()
    {
        if (this.actionHelper == null)
        {
            return new ActionHelper(driver);
        }
        else
        {
            return this.actionHelper;
        }
    }

    protected Send send()
    {
        if (this.send == null)
        {
            return new Send(driver);
        }
        else
        {
            return this.send;
        }
    }

    protected Click click()
    {
        if (this.click == null)
        {
            return new Click(driver);
        }
        else
        {
            return this.click;
        }
    }

    protected TouchAction touchAction()
    {
        if (this.touchAction == null)
        {
            return new TouchAction(driver);
        }
        else
        {
            return this.touchAction;
        }
    }

}
