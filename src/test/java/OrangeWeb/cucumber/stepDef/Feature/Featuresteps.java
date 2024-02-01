package OrangeWeb.cucumber.stepDef.Feature;

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
public class Featuresteps {
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
    }
    @When("I click button list menu")
    public void i_click_button_menu() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // css WebElement listButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > div > div > button"));
        WebElement listButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button"));
        listButton.click();
    }

    @And("I click admin menu")
    public void i_click_admin_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement adminMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1)"));
        adminMenu.click();
    }

    @Then("I should see a list of employees with Admin role")
    public void i_should_see_a_list_of_employees_with_Admin_role() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adminPageTitle = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5"));
        Assert.assertEquals(adminPageTitle.getText(), "System Users", "Admin page title mismatch");
    }


    @And("I click PIM menu")
    public void i_click_pim_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // cssWebElement pimMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a"));
        WebElement pimMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
        pimMenu.click();

    }

    @Then("I should see a list of employees under PIM")
    public void i_should_see_a_list_of_employees_under_PIM_module() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pimPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")));

        Assert.assertEquals(pimPageTitle.getText(), "Employee Information", "PIM page title mismatch");
    }

    @And("I click leave menu")
    public void i_click_leave_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cssWebElement pimMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a"));
        WebElement leaveMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a"));
        leaveMenu.click();
    }
    @Then("I should see a list of employees whose leave")
    public void i_should_see_a_list_of_employees_whose_leave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement leavePageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")));
        String pageTitle = leavePageTitle.getText();
        Assert.assertEquals(pageTitle, "Leave List", "Leave page title mismatch");
    }

    @And("I click time menu")
    public void i_click_time_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement timeMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(4) > a"));
        timeMenu.click();
    }
    @Then("I should see a list of timesheets pending action")
    public void i_should_see_a_list_of_time_pending() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timePageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > h6")));
        String timeTitle = timePageTitle.getText();
        Assert.assertEquals(timeTitle, "Timesheets Pending Action", "Timesheets page title mismatch");
    }

    @And("I click recruitment menu")
    public void i_click_recruit_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement recruitMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(5) > a"));
        recruitMenu.click();
    }

    @Then("I should see a list of candidates")
    public void i_should_see_a_list_of_recruit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       // css WebElement recruitPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container.--collapse > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")));
        WebElement recruitPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")));
        String recruitTitle = recruitPageTitle.getText();
        Assert.assertEquals(recruitTitle, "Candidates", "Candiates page title mismatch");
    }

    @And("I click profile menu")
    public void i_click_profile_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement profileMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(6) > a"));
        profileMenu.click();
    }
    @Then("I should see my profile")
    public void i_should_see_my_profile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement profilePageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > h6")));
        String profileTitle = profilePageTitle.getText();
        Assert.assertEquals(profileTitle, "Personal Details", "Personal Details page title mismatch");
    }
    @And("I click performance menu")
    public void i_click_performance_menu() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    //    WebElement performancePageTitle = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(7) > a"));
    //    WebElement performancePageTitle = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(7) > a"));
        WebElement performancePageLink = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(7) > a"));
        performancePageLink.click();
    }

    @Then("I should see a list of performance")
    public void i_should_see_a_of_directory() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement directoryMenupage = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5"));
        String directoryMenu = directoryMenupage.getText();
        Assert.assertEquals(directoryMenu, "Employee Reviews", "Employee Reviews menu title mismatch"); // Sesuaikan pesan error dan teks yang diverifikasi

    }
    @And("I click dashboard menu")
    public void i_click_dashboard_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dashboardMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(8) > a"));
        dashboardMenu.click();
    }
    @Then("I should see a dashboard")
    public void i_should_see_a_dashborad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dashboardPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6")));
        String dashboardTitle = dashboardPageTitle.getText();
        Assert.assertEquals(dashboardTitle, "Dashboard", "Dashboard page title mismatch");

    }



    @And("I click maintance menu")
    public void i_click_maintance_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement maintanceMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(10) > a > span"));
        maintanceMenu.click();
    }



    @When("I enter valid password {string}")
    public void i_enter_valid_password(String password) throws InterruptedException {

        Thread.sleep(30000);
        //WebElement passwordField = driver.findElement(By.cssSelector("#app > div.orangehrm-admin-access-container > div.orangehrm-card-container > form > div:nth-child(6) > div > div:nth-child(2) > input"));
        //WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input"));
        passwordField.sendKeys(password);
    }

    @And("I click the confirm button")
    public void i_click_confirm_button() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adminButton = driver.findElement(By.cssSelector("#app > div.orangehrm-admin-access-container > div.orangehrm-card-container > form > div.orangehrm-admin-access-button-container > button.oxd-button.oxd-button--large.oxd-button--secondary.orangehrm-admin-access-button"));
        adminButton.click();
    }
    @Then("I should be logged admin in successfully")
    public void i_should_be_admin_in_successfully() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement adminPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-card-container > h6")));
        String adminTitle = adminPageTitle.getText();
        Assert.assertEquals(adminTitle, "Purge Employee Records", "Purge Employee Records page title mismatch");
    }
    @And("I click claim menu")
    public void i_click_claim_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement claimMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(11) > a"));
        claimMenu.click();
    }
    @Then("I should see a list of claim employees")
    public void i_should_see_a_of_claim_employess() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // WebElement claimPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")));

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement claimPageTitle = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5"));
        String claimTitle = claimPageTitle.getText();
        Assert.assertEquals(claimTitle, "Employee Claims", "Employee Claims page title mismatch");}

    @And("I click Buzz menu")
    public void i_click_buzz_menu() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement buzzMenu = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(12) > a"));
        buzzMenu.click();
    }
    @Then("I should see a Buzz Newsfeed")
    public void i_should_see_a_buzz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement buzzPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6")));
        String buzzTitle = buzzPageTitle.getText();
        Assert.assertEquals(buzzTitle, "Buzz", "Page title mismatch");
        driver.quit();

    }
    @When("I enter invalid password {string}")
    public void i_enter_invalid_password(String password) throws InterruptedException {
        //Thread.sleep untuk menunggu 30 detik
        Thread.sleep(30000);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input"));
        passwordField.sendKeys(password);
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement errorMessage = driver.findElement(By.cssSelector("#app > div.orangehrm-admin-access-container > div.orangehrm-card-container > form > div.oxd-alert.oxd-alert--error > div.oxd-alert-content.oxd-alert-content--error > p"));

        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Invalid credentials"; // Atau pesan kesalahan diharapkan
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch");
        driver.quit();
    }
}