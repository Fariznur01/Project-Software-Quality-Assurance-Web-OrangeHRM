package OrangeWeb.cucumber.stepDef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Loginsteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginButton = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button"));
        loginButton.click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement yourElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
        driver.quit();
    }
    @When("I enter a valid username {string} and an invalid password {string}")
    public void enterInvalidUsernameAndPassword(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement errorMessage = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > div > div.oxd-alert.oxd-alert--error > div.oxd-alert-content.oxd-alert-content--error > p"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch");
        driver.quit();
    }

    @When("I enter an invalid username {string} and a valid password {string}")
    public void enterInvalidUsernameAndValidPassword(String invalidUsername, String validPassword) {
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Inisialisasi WebDriverWait
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")));

        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
    }


    @When("I click on the \"Forgot Password\" link")
    public void clickForgotPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.orangehrm-login-forgot > p")));
        forgotPasswordLink.click();
    }

    @And("I enter my username {string}")
    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Tunggu hingga 5 detik
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-forgot-password-container > div.orangehrm-forgot-password-wrapper > div > form > div.oxd-form-row > div > div:nth-child(2) > input")));
        usernameField.sendKeys(username);
    }

    @And("I click the reset password button")
    public void clickResetPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resetPasswordButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.orangehrm-forgot-password-container > div.orangehrm-forgot-password-wrapper > div > form > div.orangehrm-forgot-password-button-container > button.oxd-button.oxd-button--large.oxd-button--secondary.orangehrm-forgot-password-button.orangehrm-forgot-password-button--reset")));
        resetPasswordButton.click();
    }

    @Then("I should see a message that a password reset link has been sent to my email")
    public void verifyPasswordResetEmailMessage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement resetMessage = driver.findElement(By.cssSelector("#app > div.orangehrm-forgot-password-container > div.orangehrm-forgot-password-wrapper > div > p:nth-child(3) > p"));
        String actualMessage = resetMessage.getText();
        String expectedMessage = "A reset password link has been sent to you via email.";

        Assert.assertEquals(actualMessage, expectedMessage, "Reset password email message mismatch");

        // Close the browser session
        driver.quit();
    }

    @Then("I should see a message that the username is not registered")
    public void verifyUsernameNotRegisteredMessage() {
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement errorMessage = driver.findElement(By.cssSelector("#app > div.orangehrm-forgot-password-container > div.orangehrm-forgot-password-wrapper > div > p:nth-child(3) > p"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "A reset password link has been sent to you via email.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Username not registered message mismatch");
        driver.quit();
    }



}

