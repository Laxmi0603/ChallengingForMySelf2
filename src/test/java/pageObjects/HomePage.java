package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void gotoHomePage(String url)
    {
        driver.navigate().to(url);
    }
    @FindBy(linkText = "Log in") public WebElement loginLink;
    public void clickLoginLink()
    {
        loginLink.click();
    }
    @FindBy(linkText = "Register") public WebElement registerLink;
    public void clickRegisterLink() { registerLink.click(); }
    public String getPageTitle()
    {
        return driver.getTitle();
    }

}
