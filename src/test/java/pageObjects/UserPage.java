package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void alert()
    {
        driver.switchTo().alert().accept();
    }
    @FindBy(xpath = "//div[@class='topic-block-title']/h2") public WebElement userPageHeader;
    public void verifyUserPageHeader()
    {
        Assertions.assertTrue(userPageHeader.isDisplayed(),"User page is displayed?");
    }
    @FindBy(xpath = "(//input[@value='Add to cart'])[1]") public WebElement addtocartButton;
    public void clickAddToCart()
    {
        driver.navigate().refresh();
        addtocartButton.click();
    }
    @FindBy(css = "span.cart-label") public WebElement shoppingCartLink;
    public void clickShoppingCartLink()
    {
        shoppingCartLink.click();
    }

    @FindBy(xpath = "//div[@class='page-title']/h1") public WebElement shoppingCartPageHeader;
    public void verifyShoppingCartPageHeader()
    {
        Assertions.assertTrue(shoppingCartPageHeader.isDisplayed(),"shopping cart page is displayed?");
    }
    @FindBy(id = "termsofservice") public WebElement termsOfServiceCheckBox;
    public void clickTermsOfServiceCheckBox()
    {
        termsOfServiceCheckBox.click();
    }
    @FindBy(id = "checkout") public WebElement checkoutButton;
    public void clickCheckoutButton()
    {
        checkoutButton.click();
    }
    @FindBy(xpath = "//div[@class='page-title']/h1") public WebElement checkoutPageHeader;
    public void verifyCheckOutPageHeader()
    {
        Assertions.assertTrue(checkoutPageHeader.isDisplayed(),"ChceckOutPage is displayed?:");
    }
    @FindBy(id = "BillingNewAddress_CountryId") public WebElement countryDropDown;
    public void setCountryDropDown()
    {
        Select country = new Select(countryDropDown);
        country.selectByVisibleText("United Kingdom");
    }
    @FindBy(id = "BillingNewAddress_City") public WebElement cityTextBox;
    public void setCityTextBox(String city)
    {
        cityTextBox.sendKeys(city);
    }
    @FindBy(id = "BillingNewAddress_Address1") public WebElement addressTextBox;
    public void setAddress(String address)
    {
        addressTextBox.sendKeys(address);

    }
    @FindBy(id = "BillingNewAddress_ZipPostalCode") public WebElement postcodeTextBox;
    public void setPostcodeTextBox(String postcode)
    {
        postcodeTextBox.sendKeys(postcode);
    }
    @FindBy(id = "BillingNewAddress_PhoneNumber") public WebElement phonenumberTextBox;
    public void setPhonenumberTextBox(String phonenumber)
    {
        phonenumberTextBox.sendKeys(phonenumber);
    }

    @FindBy(xpath = "(//input[@value='Continue'])[1]") public WebElement continueButton1;

    public void clickContinueButtonForBillingAddress()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton1.click();
    }
    @FindBy(xpath = "(//input[@value='Continue'])[3]") public WebElement continueButton2;
    public void clickContinueButtonForShippingMeth()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton2.click();
    }
    @FindBy(xpath = "(//input[@value='Continue'])[4]") public WebElement continueButton3;
    public void clickContinueButtonForPaymentMeth()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton3.click();
    }
    @FindBy(xpath = "(//input[@value='Continue'])[5]") public WebElement continueButton4;
    public void clickContinueButtonForPaymentInfo()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton4.click();
    }
    @FindBy(xpath = "//input[@value='Confirm']") public WebElement confirmOrderButton;
    public void clickConfirmOrder()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        confirmOrderButton.click();
    }
    @FindBy(xpath = "//div[@class='title']/strong") public WebElement orderSuccessMsg;
    public void verifyOrderSuccessMsg(String msg)
    {
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String smg = orderSuccessMsg.getText();
        Assertions.assertEquals(msg,smg);
    }

}
