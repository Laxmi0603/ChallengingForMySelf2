import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class LoginWithValidUserAndPerformCheckoutSteps extends TestRunner
{
    @When("I click on login link")
    public void iClickOnLoginLink()
    {
        BaseTest.homePage.clickLoginLink();
    }
    @Then("I should be navigated to login page")
    public void iShouldBeNavigatedToLoginPage()
    {
        String s1 = "Your store. Login";
        String s2 = driver.getTitle();
        Assertions.assertEquals(s1,s2);
        System.out.println(s2);
    }
    @When("I enter email {string}")
    public void iEnterEmailLuckyStarGmailCom(String email)
    {
         BaseTest.loginPage.setEmailTextBox(email);
    }
    @And("I enter password {string}")
    public void iEnterPasswordLuckystar(String password)
    {
        BaseTest.loginPage.setPasswordTextBox(password);
    }
    @And("I click login button")
    public void iClickLoginButton()
    {
        BaseTest.loginPage.clickLoginButton();
    }
    @Then("I should be navigated to user login page and i should see msg {string}")
    public void iShouldBeNavigatedToUserLoginPageAndIShouldSeeMsg(String msg)
    {
        BaseTest.loginPage.verifyLoginUserHeader(msg);
    }
}
