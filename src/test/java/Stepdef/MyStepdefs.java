package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;


public class MyStepdefs {
    WebDriver driver;
    WebDriverWait wait;


    @Given("Navigate to registration page")
    public void navigateToRegistrationPage() {
        //driver = new ChromeDriver();
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I enter valid user info")
    public void iEnterValidUserInfo() {
        driver.findElement(By.id("dp")).sendKeys("22/03/1985");
        driver.findElement(By.id("member_firstname")).sendKeys("Nadia");
        driver.findElement(By.id("member_lastname")).sendKeys("Jarbou");
        driver.findElement(By.id("member_emailaddress")).sendKeys("nadja.jarbou10@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("nadja.jarbou10@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123!");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123!");

        JavascriptExecutor js = (JavascriptExecutor) driver;// this class for click the checkbox element
       WebElement termsAccept = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].click();", termsAccept);

        WebElement ageAccept = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", ageAccept);
        WebElement codeAccept = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", codeAccept);
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        driver.findElement(By.name("join")).click();
    }

    @Then("A new account created successfully")
    public void aNewAccountCreatedSuccessfully() {
        WebElement successMessage = driver.findElement(By.cssSelector(".background-gray"));
       Assert.assertTrue(successMessage.isDisplayed());
        System.out.println("Your account has been successfully created");

    }

    @When("I enter user info without a last name")
    public void iEnterUserInfoWithoutALastName() {
        driver.findElement(By.id("dp")).sendKeys("22/03/1985");
        driver.findElement(By.id("member_firstname")).sendKeys("Nadia");
        driver.findElement(By.id("member_emailaddress")).sendKeys("nadja.jarbou11@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("nadja.jarbou11@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123!");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement termsAccept = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].click();", termsAccept);

        WebElement ageAccept = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", ageAccept);
        WebElement codeAccept = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", codeAccept);


    }

    @Then("An error message for missing last name should be displayed")
    public void anErrorMessageForMissingLastNameShouldBeDisplayed() {
        WebElement lastNameErrorMsg = driver.findElement(By.cssSelector("span[for ='member_lastname'"));
        waitForElement(By.cssSelector("span[for ='member_lastname'"));
        Assert.assertTrue(lastNameErrorMsg.isDisplayed());

    }

    @When("I enter user info without mismatched passwords")
    public void iEnterUserInfoWithoutMismatchedPasswords() {
        driver.findElement(By.id("dp")).sendKeys("22/03/1985");
        driver.findElement(By.id("member_firstname")).sendKeys("Nadia");
        driver.findElement(By.id("member_lastname")).sendKeys("Jarbou");
        driver.findElement(By.id("member_emailaddress")).sendKeys("nadja.jarbou12@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("nadja.jarbou12@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123!");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement termsAccept = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].click();", termsAccept);

        WebElement ageAccept = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", ageAccept);
        WebElement codeAccept = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", codeAccept);

    }

    @Then("An error message for password mismatch should be displayed")
    public void anErrorMessageForPasswordMismatchShouldBeDisplayed() {
        WebElement passWordErrorMsg = driver.findElement(By.cssSelector("span[for ='signupunlicenced_confirmpassword'"));
        waitForElement(By.cssSelector("span[for ='signupunlicenced_confirmpassword'"));
        Assert.assertTrue(passWordErrorMsg.isDisplayed());
    }

    @When("I enter user info without accept terms and conditions")
    public void iEnterUserInfoWithoutAcceptTermsAndConditions() {
        driver.findElement(By.id("dp")).sendKeys("22/03/1985");
        driver.findElement(By.id("member_firstname")).sendKeys("Nadia");
        driver.findElement(By.id("member_lastname")).sendKeys("Jarbou");
        driver.findElement(By.id("member_emailaddress")).sendKeys("nadja.jarbou13@gmail.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("nadja.jarbou13@gmail.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123!");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123!");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement ageAccept = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", ageAccept);
        WebElement codeAccept = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", codeAccept);

    }

    @Then("An error message for unaccepted terms should be displayed")
    public void anErrorMessageForUnacceptedTermsShouldBeDisplayed() {
        WebElement termsErrorMsg = driver.findElement(By.cssSelector("span[for ='TermsAccept'"));
        waitForElement(By.cssSelector("span[for ='TermsAccept'"));
        Assert.assertTrue(termsErrorMsg.isDisplayed());

    }
    private void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @When("I enter valid details: {string}, {string}, {string}, {string}, {string}")
    public void theyEnterValidDetails(String firstname, String lastname, String email, String password, String confirm_password) {
        driver.findElement(By.id("dp")).sendKeys("22/03/1985");
        driver.findElement(By.id("member_firstname")).sendKeys(firstname);
        driver.findElement(By.id("member_lastname")).sendKeys(lastname);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirm_password);
        JavascriptExecutor js = (JavascriptExecutor) driver;// this class for click the checkbox element
        WebElement termsAccept = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].click();", termsAccept);

        WebElement ageAccept = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", ageAccept);
        WebElement codeAccept = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", codeAccept);
    }
}
