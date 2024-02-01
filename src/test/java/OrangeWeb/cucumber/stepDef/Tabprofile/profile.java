package OrangeWeb.cucumber.stepDef.Tabprofile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class profile {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Tunggu hingga 15 detik
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
    }

    @When("I click tab profile")
    public void i_click_tab_profile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement listButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > span > i"));
        listButton.click();
    }

    @And("I click about")
    public void i_click_about() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement aboutButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(1) > a\n"));
        aboutButton.click();
    }

    @Then("I should see about system web")
    public void i_should_see_about_system_web() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement webSystem = driver.findElement(By.cssSelector("#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > div.orangehrm-modal-header > h6\n"));
        Assert.assertEquals(webSystem.getText(), "About", "About mismatch");

    }

    @And("I click button back")
    public void i_click_button_back() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement backButton = driver.findElement(By.cssSelector("#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > button"));
        backButton.click();
    }
    @And("I click support web")
    public void i_click_support_web() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement supportButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header.toggled > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(2) >"));
        WebElement supportButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(2)"));
        supportButton.click();
    }

    @Then("I should see about support web")
    public void i_should_see_about_support_web() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement supportSystem = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6"));
        Assert.assertEquals(supportSystem.getText(), "Getting Started with OrangeHRM", "Getting Started with OrangeHRM mismatch");
    }

    @And("I click change password")
    public void i_change_password() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement changeButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(3)"));
        changeButton.click();
    }

    @Then("I should see page change password")
    public void i_should_see_page_change_password() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement changepassword = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6"));
        Assert.assertEquals(changepassword.getText(), "Update Password", "Update Password mismatch");
    }

    @When("I enter valid currentpassword {string}, password {string} and password confirm {string}")
    public void i_enter_valid_currentpassword_password_and_passwordconfirm(String currentpassword, String password, String passwordconfirm) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement  currentpasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > input")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input")));
        WebElement passwordconfirmField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input")));

        currentpasswordField.sendKeys(currentpassword);
        passwordField.sendKeys(password);
        passwordconfirmField.sendKeys(passwordconfirm);
    }

    @When("I enter valid currentpassword {string},but valid password {string} and  invalid password confirm {string}")
    public void i_enter_valid_currentpassword_but_valid_password_and_invalid_passwordconfirm(String currentpassword, String password, String passwordconfirm) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement  currentpasswordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > input")));
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input")));
        WebElement passwordconfirmField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input")));

        currentpasswordField.sendKeys(currentpassword);
        passwordField.sendKeys(password);
        passwordconfirmField.sendKeys(passwordconfirm);
    }
    @And("I click the save button")
    public void i_click_save_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement saveButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        saveButton.click();
    }

    @And("I should see fail save new password")
    public void i_should_see_fail_save_new_password() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement failinfo = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container.--collapse > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > span"));
          WebElement failinfo = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > span"));
        Assert.assertEquals(failinfo.getText(), "Passwords do not match", "Passwords do not match");
        driver.quit();
    }
    @And("I click the logout button")
    public void i_click_the_logout_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement logoutButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-userarea > ul > li > ul > li:nth-child(4) > a"));
        logoutButton.click();
    }

    @Then("I should be logged out")
    public void i_should_be_logged_out() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logout = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > h5"));
        Assert.assertEquals(logout.getText(), "Login", "Login title mismatch");
        driver.quit();

    }
}
