package automation.page;

import automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage (){
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Empty Cart']")
    public WebElement emptyCartButton;

    @FindBy(id ="cartItemCountSpan")
    public WebElement cartItemsCount;

    @FindBy(xpath = "//button[text()='Empty']")
    public WebElement emptyButton;

    @FindBy(xpath= "//p[@class='header-1']")
    public WebElement emptyCartText;


}
