package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "Email") public WebElement emailTextBox;
    @FindBy(id = "Password") public WebElement passwordTextBox;
    @FindBy(css = "input.login-button") WebElement loginButton;
    public void setEmailTextBox(String email)
    {
        emailTextBox.sendKeys(email);
    }
    public void setPasswordTextBox(String password)
    {
        passwordTextBox.sendKeys(password);
    }
    public void clickLoginButton()
    {
        loginButton.click();
    }
    @FindBy(xpath = "//h2[text()='Welcome to our store']") public WebElement welcomeHeader;
    public void verifyLoginUserHeader(String msg)
    {
        String mesg = welcomeHeader.getText();
        Assertions.assertEquals(mesg,msg);
    }


}
