package com.StepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.assertEquals;

public class Login {

    WebDriver driver;


    @Given("^I enter url as \"([^\"]*)\"$")
    public void iEnterUrlAs(String url) throws Throwable {

        System.out.println(url);

        ChromeDriverManager.getInstance().setup();

        driver = new ChromeDriver();

        driver.get(url);
    }
      @When("^I click on register button$")
    public void iClickOnRegisterButton() {
        driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
    }

    @Then("^I should see text \"([^\"]*)\"$")
    public void iShouldSeeText(String accname) throws Throwable {
        String actual_url;
        String Expected_url = "Create an account";

       actual_url= driver.findElement(By.xpath("//*[@id=\"swtActDiv\"]/div[1]")).getText();
    assertEquals(Expected_url,actual_url);

    driver.navigate().back();
    driver.navigate().forward();
}
}

