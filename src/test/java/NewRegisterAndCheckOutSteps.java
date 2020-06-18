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
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class NewRegisterAndCheckOutSteps extends TestRunner
{
        @Given("I navigate to url {string}")
        public void iNavigateToUrl(String url)
        {
           BaseTest.homePage.gotoHomePage(url);
        }
        @When("I click on Register link")
        public void iClickOnRegisterLink() {
            BaseTest.homePage.clickRegisterLink();
        }
        @Then("I should be navigated to Register page")
        public void iShouldBeNavigatedToRegisterPage() {
            BaseTest.registerPage.verifyRegisterPageHeader();
        }
        @When("I click on Female Radio Button")
        public void iClickOnFemaleRadioButton()
        {
          BaseTest.registerPage.clickFemaleRadioButton();
        }
        @And("I enter firstname lastname email company name password confirmpassword")
        public void iEnterFirstnameLastnameEmailCompanyNamePasswordConfirmpassword(DataTable dataTable) {
            driver.navigate().refresh();
            BaseTest.registerPage.setFirstNameTextBox(dataTable.cell(1, 0));
            BaseTest.registerPage.setLastNameTextBox(dataTable.cell(1, 1));
            BaseTest.registerPage.setEmailTextBox(dataTable.cell(1, 2));
            BaseTest.registerPage.setCompanyNameTextBox(dataTable.cell(1, 3));
            BaseTest.registerPage.setPasswordTextBox(dataTable.cell(1, 4));
            BaseTest.registerPage.setConfirmPasswordTextBox(dataTable.cell(1, 5));
        }

        @And("I select Day Month Year")
        public void iSelectDayMonthYear() {
            BaseTest.registerPage.setBirthDropDown();
        }

        @And("I click on register button")
        public void iClickOnRegisterButton() {
            BaseTest.registerPage.clickRegisterButton();
        }

        @Then("I should see Your registration completed")
        public void iShouldSeeYourRegistrationCompleted()
        {
            BaseTest.registerPage.verifyNewUserRegistration();
        }
        public String getPageTitle()
        {
            return driver.getTitle();
        }
        @When("I click continue button")
        public void iClickContinueButton()
        {
            System.out.println(getPageTitle());
            BaseTest.registerPage.clickContinueButton();
        }

        @Then("I should be navigated to user home page")
        public void iShouldBeNavigatedToUserHomePage()
        {
            driver.navigate().refresh();
            System.out.println(getPageTitle());
            BaseTest.userPage.verifyUserPageHeader();
        }

        @And("I click add to cart button for the first product")
        public void iClickAddToCartButtonForTheFirstProduct()
        {
            BaseTest.userPage.clickAddToCart();
            driver.navigate().refresh();
        }

        @And("I click on shopping cart link")
        public void iClickOnShoppingCartLink() throws InterruptedException {
            BaseTest.userPage.clickShoppingCartLink();
            driver.navigate().refresh();
        }

        @Then("I should be navigated to shopping cart page")
        public void iShouldBeNavigatedToShoppingCartPage() throws InterruptedException {
            System.out.println(getPageTitle());
            BaseTest.userPage.verifyShoppingCartPageHeader();
        }

        @When("I click the terms of service check box")
        public void iClickTheTermsOfServiceCheckBox()
        {
            BaseTest.userPage.clickTermsOfServiceCheckBox();
        }
        @And("I click on check out button")
        public void iClickOnCheckOutButton()
        {
            BaseTest.userPage.clickCheckoutButton();
        }

        @Then("I should be navigated to checkout page")
        public void iShouldBeNavigatedToCheckoutPage()
        {
            BaseTest.userPage.verifyCheckOutPageHeader();
        }

        @When("I click country and select united kingdom")
        public void iClickCountryAndSelectUnitedKingdom()
        {
            BaseTest.userPage.setCountryDropDown();
        }

        @And("I enter city address postcode phonenumber")
        public void iEnterCityAddressPostcodePhonenumber(DataTable dataTable)
        {
            BaseTest.userPage.setCityTextBox(dataTable.cell(1,0));
            BaseTest.userPage.setAddress(dataTable.cell(1,1));
            BaseTest.userPage.setPostcodeTextBox(dataTable.cell(1,2));
            BaseTest.userPage.setPhonenumberTextBox(dataTable.cell(1,3));
        }
        @And("I click on continue button for billing address")
        public void iClickOnContinueButtonForBillingAddress()
        {
            BaseTest.userPage.clickContinueButtonForBillingAddress();
        }
        @And("I set default shipping method")
        public void iSetDefaultShippingMethod()
        {
            BaseTest.userPage.clickContinueButtonForShippingMeth();
        }

        @And("I set default payment method")
        public void iSetDefaultPaymentMethod()
        {
            BaseTest.userPage.clickContinueButtonForPaymentMeth();
        }

        @And("I set default payment information")
        public void iSetDefaultPaymentInformation()
        {
            BaseTest.userPage.clickContinueButtonForPaymentInfo();
        }

        @And("I confirm the order")
        public void iConfirmTheOrder()
        {
            BaseTest.userPage.clickConfirmOrder();
        }
        @Then("I should see the order confirmation msg {string}")
        public void iShouldSeeTheOrderConfirmationMsg(String msg)
        {
            BaseTest.userPage.verifyOrderSuccessMsg(msg);
        }

}