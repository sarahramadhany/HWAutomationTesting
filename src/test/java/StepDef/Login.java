package StepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemo_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("user enter the valid credentials")
    public void userEnterTheValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user enter the invalid credentials")
    public void user_enters_the_invalid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
    }

    @And("user click login")
    public void user_clicks_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("home page should be displayed")
    public void homePageShouldBeDisplayed() {
            assert driver.getCurrentUrl().contains("inventory.html");
            driver.quit();
        }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed () {
        assert driver.findElement(By.cssSelector(".error-button")).isDisplayed();
        driver.quit();
    }
}
