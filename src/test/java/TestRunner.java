import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@CucumberOptions(
        features = {"src/test/resources"},
       // glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
          // plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"}
         strict = true
         //plugin = {"pretty:target/test.html"}
        //tags = {"@Tag1"}
)
@RunWith(Cucumber.class)
public class TestRunner
{
   public static WebDriver driver;

    public static final String USERNAME = "lakshmi287";
    public static final String AUTOMATE_KEY = "vzyFrx8KDQkjc9XA9Whe";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeClass
    public static void startBrowser() {
        //WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();
        //WebDriverManager.edgedriver().setup();
       // WebDriverManager.edgedriver().operatingSystem(OperatingSystem.WIN).setup();
       // WebDriver driver = new EdgeDriver();
        //WebDriverManager.edgedriver().forceDownload().setup();
       // driver = new EdgeDriver();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "78.0 beta");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Catalina");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Lakshmi Regression Test");

        try {
             driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void stopBrowser()
    {
       driver.quit();
    }

}
