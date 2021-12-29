package com.esi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class stepdefs {
    

	static ChromeOptions chromeOptions = new ChromeOptions();
	static FirefoxOptions firefoxOptions = new FirefoxOptions();
	static EdgeOptions edgeOptions = new EdgeOptions();
    static URL url;
    static WebDriver driver;

    
    @Given("^I am on the ebay home page$")
    public void i_am_on_the_ebay_home_page() throws Exception {
        url = new URL("http://localhost:4444");
        driver = new RemoteWebDriver(url, chromeOptions);
        driver.get("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));        
    }

    @When("^I set the search type to \"([^\"]*)\"$")
    public void i_set_the_search_type_to(String searchType) {
        WebElement searchTypeDropdown = driver.findElement(By.id("gh-cat"));
        Select searchTypeDropdownSelect = new Select(searchTypeDropdown);
        searchTypeDropdownSelect.selectByVisibleText(searchType);
    }
    @And("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) {
        WebElement inputSearch = driver.findElement(By.id("gh-ac"));
        inputSearch.sendKeys(arg1);
        inputSearch.submit();
        //wait for the results to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //check if the results are displayed
        WebElement result = driver.findElement(By.cssSelector("#srp-river-results > ul > li:nth-child(2) > div > div.s-item__info.clearfix > a"));
        assertTrue(result.isDisplayed());
    }

    @Then("^I should see the results for \"([^\"]*)\"$")
    public void i_should_see_the_results_for(String arg1) {
        WebElement result = driver.findElement(By.cssSelector("#srp-river-results > ul > li:nth-child(2) > div > div.s-item__info.clearfix > a"));
        assertTrue(result.isDisplayed());
        assertEquals(arg1, result.getText());
    }

    @When("^I am on the product page$")
    public void i_am_on_the_product_page() {
        WebElement result = driver.findElement(By.cssSelector("#srp-river-results > ul > li:nth-child(2) > div > div.s-item__info.clearfix > a"));
        String mainWindow = driver.getWindowHandle();
        result.click();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("eBay", driver.getTitle());

    }    
    @And("^I add the product to the cart$")
    public void i_add_the_product_to_the_cart() {
        WebElement addToCart = driver.findElement(By.cssSelector("#atcRedesignId_btn"));
		addToCart.click();

        //wait 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("^I should see the product in the cart$")
    public void i_should_see_the_product_in_the_cart() {
        WebElement icon = driver.findElement(By.cssSelector("#gh-cart-n"));
        assertEquals(1, icon.getText());
    }

    @And("^I should see the total price of the product : \"([^\"]*)\"$")
    public void i_should_see_the_total_price_of_the_product(String arg1) {
		WebElement price = driver.findElement(By.cssSelector("#mainContent > div > div.right-section > div > div.table > div:nth-child(4) > div.val-col.total-row > span > span > span"));
        assertEquals(arg1, price.getText());
    }

}
