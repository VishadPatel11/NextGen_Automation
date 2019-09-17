package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;



public class SqspLoginStepDef  {
    private WebDriver driver;
    ConfigFileReader configFileReader;
    WebDriverManager webDriverManager;

    @Before
    public void setup()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        configFileReader= new ConfigFileReader();

    }


    @Given("User is on Squarespace Login page")
    public void user_is_on_Squarespace_Login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.get(configFileReader.getApplicationUrl());
        driver.findElement(By.className("login-button")).click();
    }

    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//*[@class='username Input-sc-134gy6z-0 iKyBme']")).sendKeys(username);
        driver.findElement(By.xpath(".//*[@class='password Input-sc-134gy6z-0 iKyBme']")).sendKeys(password);
    }

    @When("user clicks Login button")
    public void user_clicks_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//*[@data-test='login-button']")).click();
    }

    @Then("Error msg is displayed")
    public void error_msg_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(".//*[@data-test='sentinel-username-error']")).isDisplayed();
    }

    @After
    public void tearDown()
    {
        webDriverManager.closeDriver();
    }
}