package automation.page;

import automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    WebDriver driver;

    public MainPage (){
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="searchval")
    public WebElement searchBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;


    @FindBy(xpath = "//div[@id='details']")
    public List<WebElement> descriptions ;

    @FindBy(xpath = "//div[@id='paging']//li[7]")
    public WebElement lastPage ;

    @FindBy(xpath = "//li[@class='inline-block leading-4 align-top rounded-r-md']")
    public WebElement nextPageButton;

    @FindBy(xpath = "//div[@id='product_listing']/div")
    public List<WebElement> lastPageList;


}
