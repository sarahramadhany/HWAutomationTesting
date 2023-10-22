package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;
public class Addtocart {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("user enter the valid username and password")
    public void userEnterTheValidUsernameAndpassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click button login")
    public void user_click_button_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("landing page should be displayed")
    public void landing_page_should_be_displayed() {
        assert driver.getCurrentUrl().contains("inventory.html");
//        driver.quit();
    }

    @And("user click add to cart one product")
    public void user_clicks_add_to_cart_one_product() {
        // Identify and click the "Add to Cart" button for the specified product
        WebElement oneproduct = driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)"));
        oneproduct.sendKeys(ENTER);
    }
    @And("user click the cart icon")
    public void user_clicks_the_cart_icon() {
        // Identify and click the cart icon
        WebElement cartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartIcon.click();
    }

    @And("user click checkout")
    public void user_clicks_Checkout() {
        // Identify and click the specified button
        WebElement checkout = driver.findElement(By.name("checkout"));
        checkout.sendKeys(ENTER);
    }

    @And("user enter the valid credentials add item")
    public void user_enters_valid_credentials_additem() {
        // Identify and populate the input fields with valid credentials
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        WebElement postalCodeInput = driver.findElement(By.name("postalCode"));
        firstNameInput.sendKeys("budi");
        lastNameInput.sendKeys("putra");
        postalCodeInput.sendKeys("12345");
    }
    @And("use click continue")
    public void user_clicks_continue() {
        // Identify and click the specified button
        WebElement continueButton = driver.findElement(By.name("continue"));
        continueButton.sendKeys(ENTER);
    }

    @And("use click finish")
    public void user_clicks_Finish() {
        // Identify and click the specified button
        WebElement finish = driver.findElement(By.name("finish"));
        finish.sendKeys(ENTER);
    }

    @Then("checkout complete should be displayed")
    public void checkout_complete_should_be_displayed() {
        String expectText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String complete = driver.findElement(By.cssSelector(".complete-text")).getText();
        Assert.assertEquals(expectText, complete);
        driver.quit();
    }

//    @Then("error in product quantity")
//    public void error_in_product_quantity() {
//        WebElement errorproduct = driver.findElement(By.cssSelector(".error-product"));
//        assert(errorproduct.isDisplayed());
//        driver.quit();
//    }


}