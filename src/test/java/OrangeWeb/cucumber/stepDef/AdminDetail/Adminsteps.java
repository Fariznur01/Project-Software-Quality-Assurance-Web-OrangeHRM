package OrangeWeb.cucumber.stepDef.AdminDetail;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
public class Adminsteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        driver.manage().window().maximize();
        Dimension screenSize = new Dimension(1266, 668);
        driver.manage().window().setSize(screenSize);
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

    @And("I click admin via sidebar")
    public void i_click_admin_via_sidebar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement adminSidebar = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a"));
        adminSidebar.click();
    }
    @Then("I should in admin page")
    public void i_should_in_admin_page() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement adminPage = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5"));
        //WebElement adminSidebar = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a"));
        Assert.assertEquals(adminPage.getText(), "System Users", "System Users mismatch");
    }
    /*
    @When("I enter system user with valid username {string}, select user role as {string} from the dropdown, valid employee name as {string}, and select status as {string} from the dropdown")
    public void valid_system_user(String username, String userRole, String employee, String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > input")));
        usernameField.sendKeys(username);

        String employeeName = "Paul Collings";
        WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(3) > div > div:nth-child(2) > div > div > input")));
        employeeNameField.sendKeys(employeeName);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Paul Collings']")));

        option.click();

        //WebElement adminOption = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(2) > div > div:nth-child(2) > div > div > div.oxd-select-text-input"));
        //WebElement adminOption = driver.findElement(By.cssSelector(".oxd-select-text-input"));
        //WebElement adminOption = driver.findElement(By.cssSelector(".dropdown-container .dropdown-menu\n"));
        WebElement adminOption = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
        adminOption.click();

        WebElement statusDropdown = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(4) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"));
        statusDropdown.click();

        WebElement enableOption = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(4) > div > div:nth-child(2) > div > div > div.oxd-select-text-input"));
        enableOption.click();
    }

     */
    @When("I enter system user with valid username {string}")
    public void valid_system_user(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > input")));
        usernameField.sendKeys(username);
    }

    @And("I click search button")
    public void i_click_search_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        searchButton.click();
    }
    @Then("I should see a record")
    public void i_should_see_a_record() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement record = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div:nth-child(2) > div > span"));
        Assert.assertEquals(record.getText(), "(1) Record Found", "(1) Record Found mismatch");
        driver.quit();
    }

    /*
    @And("I click button data admin")
    public void i_click_edit_data_admin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // WebElement editButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div > div > div > div > div.card-header-slot > div.card-item.card-header-slot-content.--right > div > div > button:nth-child(2)\n"));
        // WebElement editButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div > div > div > div > div.card-header-slot > div.card-item.card-header-slot-content.--right > div > div > button:nth-child(2)\n"));
        // Eksekusi JavaScript untuk menemukan tombol menggunakan document.querySelector
        //String script = "document.querySelector(\"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div > div > div > div > div.card-header-slot > div.card-item.card-header-slot-content.--right > div > div > button:nth-child(2)\")";
        //WebElement editButton = (WebElement) ((JavascriptExecutor) driver).executeScript("return " + script);
        //WebElement editButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[1]/div[2]/div/div/button[2]"));
        WebElement editButton = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div > div > div > div > div.card-header-slot > div.card-item.card-header-slot-content.--right > div > div > button:nth-child(2) > i"));

        editButton.click();
    }

    @Then("I check a box password")
    public void i_check_a_box_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordCheckbox = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row > div > div:nth-child(5) > div > div:nth-child(2) > div > label > span > i"));
        if (!passwordCheckbox.isSelected()) {
            passwordCheckbox.click();
        }
    }

     */
    @And("I click bar menu Job")
    public void i_click_menu_job() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement joblist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-body > nav > ul > li:nth-child(2) > span")));
        joblist.click();
    }
    @Then("I choose job titles from several options")
    public void i_choose_job() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement job = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > header > div.oxd-topbar-body > nav > ul > li.--active.oxd-topbar-body-nav-tab.--parent > ul > li:nth-child(1) > a")));
        job.click();
    }
    @And("I should in job page")
    public void i_click_job_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement jobpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div.orangehrm-header-container > h6")));
        Assert.assertEquals(jobpage.getText(), "Job Titles", "Job Titles mismatch");
    }
    @Then("I choose button add job")
    public void i_chooe_button_add_job() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addjob = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div.orangehrm-header-container > div > button")));
        addjob.click();
    }
    @And("I should in page add job")
    public void i_add_job_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement addjobpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6")));
        Assert.assertEquals(addjobpage.getText(), "Add Job Title", "Add Job Title mismatch");
    }

    @When("I enter valid job title {string}, valid job description {string}  and valid note {string}")
    public void i_enter_valid_job_title_valid_job_description_and_valid_note(String jobTitle, String jobDescription, String note) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement jobTitleField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > input")));
        jobTitleField.sendKeys(jobTitle);

        WebElement jobDescriptionField = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(2) > div > div:nth-child(2) > textarea"));
        jobDescriptionField.sendKeys(jobDescription);

        WebElement noteField = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(4) > div > div:nth-child(2) > textarea"));
        noteField.sendKeys(note);
    }

    /*
    @When("I enter valid job title {string}, valid job description {string}, valid file, and valid note {string}")
    public void i_enter_valid_job_title_valid_job_description_valid_file_and_valid_note(String jobTitle, String jobDescription, String note) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement jobTitleField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > input")));
        jobTitleField.sendKeys(jobTitle);

        WebElement jobDescriptionField = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(2) > div > div:nth-child(2) > textarea"));
        jobDescriptionField.sendKeys(jobDescription);

        String filePath = "C:\\Users\\Administrator\\Downloads\\Lain-lain\\Tip portofolio QA.pdf";
        WebElement fileInput = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(2) > input[type='file']"));
        fileInput.sendKeys(filePath);

        WebElement noteField = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(4) > div > div:nth-child(2) > textarea"));
        noteField.sendKeys(note);
    }
*/

    @And("I click save button")
    public void i_click_save_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement jobSaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")));
        jobSaveButton.click();
        driver.quit();
    }

    @When("I enter system user with invalid username {string}")
    public void invalid_system_user(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > input")));
        usernameField.sendKeys(username);
    }
    @Then("I should see no record")
    public void i_should_see_no_record() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement record = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div:nth-child(2) > div > span"));
        Assert.assertEquals(record.getText(), "No Records Found", "NoRecord Found mismatch");
        driver.quit();
    }
}
