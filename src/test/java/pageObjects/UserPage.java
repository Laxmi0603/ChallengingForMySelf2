package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(css = "input.product-box-add-to-cart-button") public WebElement addtocartButton;
    public void clickAddToCart()
    {
        addtocartButton.click();
    }
   // @FindBy(xpath = "//a//span[@class='cart-label']") public WebElement shoppingCartLink;


    public void clickShoppingCartLink() throws InterruptedException {
       // WebDriverWait wait = new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//span[contains(text(),'(1)')]")));
        //shoppingCartLink.click();
        Thread.sleep(3000);
        driver.navigate().to("http://twentyconsulting-001-site1.dtempurl.com/cart");
    }

    @FindBy(xpath = "//div[@class='page-title']/h1") public WebElement shoppingCartPageHeader;
    public void verifyShoppingCartPageHeader() throws InterruptedException {
        Thread.sleep(1000);
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
    @FindBy(css = "input.payment-info-next-step-button") public WebElement continueButtonForPaymentInfo;
    public void clickContinueButtonForPaymentInfo()
    {
        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButtonForPaymentInfo.click();
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
