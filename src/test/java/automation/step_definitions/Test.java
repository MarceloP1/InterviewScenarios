package automation.step_definitions;

import automation.page.CartPage;
import automation.page.ItemPage;
import automation.page.MainPage;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import automation.utilities.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    WebDriver driver = Driver.getInstance().getDriver();
    MainPage mainPage = new MainPage();
    Helper helper = new Helper();
    SoftAssert softAssert = new SoftAssert();
    List<WebElement> itemsDisplayedTotal = new ArrayList<>();

    ItemPage itemPage = new ItemPage();

    CartPage cartPage = new CartPage();


    @Given("user is on main page of webstaurantstore")
    public void user_is_on_main_page_of_webstaurantstore()  {
        String url = ConfigurationReader.getProperty("ui-config.properties", "webstaurant.url");
        driver.get(url);
    }

    @When("user search for stainless work table")
    public void user_search_for_stainless_work_table() {
        String searchObject = "stainless work table";
        mainPage.searchBox.sendKeys(searchObject);
        mainPage.searchButton.click();
    }

    @Then("assert that every product has the word Table in its title")
    public void assert_that_every_product_has_the_word_Table_in_its_title()  {
        helper.scrollIntoView(mainPage.lastPage);
        String lastPageNum = mainPage.lastPage.getText();
        int lastPage = Integer.parseInt(lastPageNum);


        List<WebElement> itemsNotDisplayingTable = new ArrayList<>();
        List<WebElement> itemsWithTable = new ArrayList<>();
        for (int i=0; i<lastPage; i++) {
            for (WebElement element : mainPage.descriptions) {
                itemsDisplayedTotal.add(element);
                if (element.getText().contains("Table") || element.getText().contains("table")) {
                    itemsWithTable.add(element);
                }
                else if (!element.getText().contains("Table") || !element.getText().contains("table")){
                    itemsNotDisplayingTable.add(element);
                }
            }
            helper.scrollIntoView(mainPage.nextPageButton);
            mainPage.nextPageButton.click();
        }


        int numberNotHavingTableOnDescription = itemsNotDisplayingTable.size();
        System.out.println("There is/are elements not having Table on description: " + numberNotHavingTableOnDescription);
        //System.out.println("Element not displaying Talbe: " + (itemsNotDisplayingTable.get(0).getText()));
        int numItemsWithTableOnDescriptionExpected = itemsWithTable.size();
        int numberOfItemsDisplayedOnPage = itemsDisplayedTotal.size();

        softAssert.assertEquals(numItemsWithTableOnDescriptionExpected, numberOfItemsDisplayedOnPage, "There are items not containing Table on their description!");
        System.out.println("Elements displayed on page: " + numberOfItemsDisplayedOnPage + " ---> " + "Items with Table on description: " + numItemsWithTableOnDescriptionExpected);

    }

    @Then("I add last item of the search into the Cart")
    public void i_add_last_item_of_the_search_into_the_Cart()  {
        WebElement lastElement = mainPage.lastPageList.get(mainPage.lastPageList.size()-1);
        helper.scrollIntoView(lastElement);
        lastElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("buyButton")));
        itemPage.addToCartButton.click();
        itemPage.cartButton.click();
        String numberOfItemsInCart = cartPage.cartItemsCount.getText();
        String actualNumberThatShouldBeOnCart = "1";
        softAssert.assertEquals(numberOfItemsInCart, actualNumberThatShouldBeOnCart, "Cart is empty!");
    }

    @Then("I empty the Cart")
    public void i_empty_the_Cart() {
        itemPage.cartButton.click();
        cartPage.emptyCartButton.click();
        cartPage.emptyButton.click();
        String emptyCartConfirmation = cartPage.emptyCartText.getText();
        String actualEmptyCartText = "Your cart is empty.";
        softAssert.assertEquals(emptyCartConfirmation,actualEmptyCartText, "Cart is not empty!");
        softAssert.assertAll();
    }
}
