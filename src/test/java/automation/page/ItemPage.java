package automation.page;

import automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    WebDriver driver;

    public ItemPage (){
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="buyButton")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@data-testid='cart-nav-link']")
    public WebElement cartButton;

}
