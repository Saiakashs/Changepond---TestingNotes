 
 
 
 package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	static WebDriver driver;    //Web driver is an interface coming from selenium
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is trying to Login");;
		driver = new ChromeDriver();
		driver.get("http://quiz-fe-test.hematitecorp.com/");
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String string, String string2) throws InterruptedException {
		System.out.println("User Enters Valid User name and Password");
		driver.findElement(By.id("email")).sendKeys("saiakash200236@gmail.com");
		driver.findElement(By.id("password")).sendKeys("S@i63akash");;
		Thread.sleep(2000);
	}
	@And("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("User is on Home page");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		System.out.println("User is closing the browser");
		driver.close();
		driver.quit();
	}

}



