import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.UserPage;

import java.util.concurrent.TimeUnit;

public class BaseTest extends TestRunner
{
    public static HomePage homePage;
    public static RegisterPage registerPage;
    public static LoginPage loginPage;
    public static UserPage userPage;

    @Before
    public void launchBrowser()
    {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("This is the command to open the website:@BeforeAll");

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        userPage = new UserPage(driver);
        loginPage = new LoginPage(driver);

    }
    @After
    public void closeBrowser(Scenario scenario)
    {
        byte[] screenShotByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShotByte,"image/png");
        System.out.println("This is the command to close the website:@AfterAll");
        BaseTest.homePage.clickLogOutLink();
    }

}
