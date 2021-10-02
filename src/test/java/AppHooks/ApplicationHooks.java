package AppHooks;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Helps to launch the browser
 */
public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order=0)
    public void getProperties(){
        configReader = new ConfigReader();
        prop = configReader.initProp();
    }

    @Before(order=1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        System.out.println("browser:"+browserName);
//        String browser = prop.getProperty("browser");
//        String browserName = System.getProperties().get("browser").toString();
        driverFactory = new DriverFactory();
        this.driver = driverFactory.getInit(browserName);
    }

    @After(order=0)
    public void closeBrowser(){
        driver.quit();
    }

    @After(order=1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            //take screenshots of failed cases
            String screenshotName=scenario.getName().replace(" ","_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);

        }
    }

}
