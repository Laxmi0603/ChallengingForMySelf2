import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.UserPage;

import java.util.concurrent.TimeUnit;

public class NewRegisterAndCheckOutSteps extends TestRunner {

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

        @Given("I navigate to url {string}")
        public void iNavigateToUrl(String url)
        {
            homePage.gotoHomePage(url);
        }
        @When("I click on Register link")
        public void iClickOnRegisterLink() {
            homePage.clickRegisterLink();
        }
        @Then("I should be navigated to Register page")
        public void iShouldBeNavigatedToRegisterPage() {
            registerPage.verifyRegisterPageHeader();
        }
        @When("I click on Female Radio Button")
        public void iClickOnFemaleRadioButton() {
            registerPage.clickFemaleRadioButton();
        }
        @And("I enter firstname lastname email company name password confirmpassword")
        public void iEnterFirstnameLastnameEmailCompanyNamePasswordConfirmpassword(DataTable dataTable) {
            driver.navigate().refresh();
            registerPage.setFirstNameTextBox(dataTable.cell(1, 0));
            registerPage.setLastNameTextBox(dataTable.cell(1, 1));
            registerPage.setEmailTextBox(dataTable.cell(1, 2));
            registerPage.setCompanyNameTextBox(dataTable.cell(1, 3));
            registerPage.setPasswordTextBox(dataTable.cell(1, 4));
            registerPage.setConfirmPasswordTextBox(dataTable.cell(1, 5));
        }

        @And("I select Day Month Year")
        public void iSelectDayMonthYear() {
            registerPage.setBirthDropDown();
        }

        @And("I click on register button")
        public void iClickOnRegisterButton() {
            registerPage.clickRegisterButton();
        }

        @Then("I should see Your registration completed")
        public void iShouldSeeYourRegistrationCompleted()
        {
            registerPage.verifyNewUserRegistration();
        }
        public String getPageTitle()
        {
            return driver.getTitle();
        }
        @When("I click continue button")
        public void iClickContinueButton()
        {
            System.out.println(getPageTitle());
            registerPage.clickContinueButton();
        }

        @Then("I should be navigated to user home page")
        public void iShouldBeNavigatedToUserHomePage()
        {
            driver.navigate().refresh();
            System.out.println(getPageTitle());
            userPage.verifyUserPageHeader();
        }

        @And("I click add to cart button for the first product")
        public void iClickAddToCartButtonForTheFirstProduct()
        {
            userPage.clickAddToCart();
            driver.navigate().refresh();
        }

        @And("I click on shopping cart link")
        public void iClickOnShoppingCartLink()
        {
            userPage.clickShoppingCartLink();
            driver.navigate().refresh();
        }

        @Then("I should be navigated to shopping cart page")
        public void iShouldBeNavigatedToShoppingCartPage()
        {
            System.out.println(getPageTitle());
            userPage.verifyShoppingCartPageHeader();
        }

        @When("I click the terms of service check box")
        public void iClickTheTermsOfServiceCheckBox()
        {
            userPage.clickTermsOfServiceCheckBox();
        }
        @And("I click on check out button")
        public void iClickOnCheckOutButton()
        {
            userPage.clickCheckoutButton();
        }

        @Then("I should be navigated to checkout page")
        public void iShouldBeNavigatedToCheckoutPage()
        {
            userPage.verifyCheckOutPageHeader();
        }

        @When("I click country and select united kingdom")
        public void iClickCountryAndSelectUnitedKingdom()
        {
            userPage.setCountryDropDown();
        }

        @And("I enter city address postcode phonenumber")
        public void iEnterCityAddressPostcodePhonenumber(DataTable dataTable)
        {
            userPage.setCityTextBox(dataTable.cell(1,0));
            userPage.setAddress(dataTable.cell(1,1));
            userPage.setPostcodeTextBox(dataTable.cell(1,2));
            userPage.setPhonenumberTextBox(dataTable.cell(1,3));
        }
        @And("I click on continue button for billing address")
        public void iClickOnContinueButtonForBillingAddress()
        {
            userPage.clickContinueButtonForBillingAddress();
        }
        @And("I set default shipping method")
        public void iSetDefaultShippingMethod()
        {
            userPage.clickContinueButtonForShippingMeth();
        }

        @And("I set default payment method")
        public void iSetDefaultPaymentMethod()
        {
            userPage.clickContinueButtonForPaymentMeth();
        }

        @And("I set default payment information")
        public void iSetDefaultPaymentInformation()
        {
            userPage.clickContinueButtonForPaymentInfo();
        }

        @And("I confirm the order")
        public void iConfirmTheOrder()
        {
            userPage.clickConfirmOrder();
        }
        @Then("I should see the order confirmation msg {string}")
        public void iShouldSeeTheOrderConfirmationMsg(String msg)
        {
            userPage.verifyOrderSuccessMsg(msg);
        }
        @After
        public void closeBrowser(Scenario scenario)
        {
            byte[] screenShotByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShotByte,"image/png");
            System.out.println("This is the command to close the website:@AfterAll");
        }
}