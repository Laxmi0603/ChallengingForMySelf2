package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//div[@class='page-title']/h1") public WebElement registerPageHeader;
    public void verifyRegisterPageHeader()
    {
        Assertions.assertTrue(registerPageHeader.isDisplayed(),"Register Page is Displayed?");
    }
    @FindBy(xpath = "//input[@value='F']") public WebElement femaleRadioButton;
    @FindBy(id = "FirstName") public WebElement firstNameTextBox;
    @FindBy(id = "LastName") public WebElement lastNameTextBox;
    @FindBy(id = "Email") public WebElement emailTextBox;
    @FindBy(id = "Company") public WebElement companyNameTextBox;
    @FindBy(id = "Password") public WebElement passwordTextBox;
    @FindBy(id = "ConfirmPassword") public WebElement confirmPasswordTextBox;
    @FindBy(name = "DateOfBirthDay") public WebElement dayOfBirthDropDown;
    @FindBy(name = "DateOfBirthMonth") public WebElement monthOfBirthDropDown;
    @FindBy(name = "DateOfBirthYear") public WebElement yearOfBirthDropDown;
    @FindBy(id = "register-button") public WebElement registerButton;
    @FindBy(xpath = "//div[@class='result']") public WebElement registrationSuccessMsg;
    @FindBy(xpath = "//input[@value='Continue']") public WebElement continueButton;
    public void clickFemaleRadioButton()
    {
        femaleRadioButton.click();
        Assertions.assertTrue(femaleRadioButton.isSelected(),"Female Radio Button is Selected?");
    }
    public void setFirstNameTextBox(String firstname)
    {
        firstNameTextBox.sendKeys(firstname);
    }
    public void setLastNameTextBox(String lastname)
    {
        lastNameTextBox.sendKeys(lastname);
    }
    public void setEmailTextBox(String email)
    {
        emailTextBox.sendKeys(email);
    }
    public void setCompanyNameTextBox(String companyname)
    {
        companyNameTextBox.sendKeys(companyname);
    }
    public void setPasswordTextBox(String password)
    {
        passwordTextBox.sendKeys(password);
    }
    public void setConfirmPasswordTextBox(String confirmpassword)
    {
        confirmPasswordTextBox.sendKeys(confirmpassword);
    }

    public void setBirthDropDown()
    {
        Select day = new Select(dayOfBirthDropDown);
        day.selectByVisibleText("30");
        Select month = new Select(monthOfBirthDropDown);
        month.selectByVisibleText("March");
        Select year = new Select(yearOfBirthDropDown);
        year.selectByVisibleText("1985");
    }

    public void clickRegisterButton()
    {
        registerButton.click();

    }
    public void verifyNewUserRegistration()
    {
        Assertions.assertTrue(registrationSuccessMsg.isDisplayed(),"New user Registration is Successful?");
    }
    public void clickContinueButton()
    {
        continueButton.click();
    }
}
