package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class LoginSteps {


static WebDriver driver;    //Web driver is an interface coming from selenium
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("User is trying to log in");
	    
		driver = new FirefoxDriver();  //test it on firefox
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //waits bcoz, if any delays occur due network speed
		driver.get("http://quiz-fe-test.hematitecorp.com/");
	}
	
	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
	    
		System.out.println("When");
		
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    
	}
	
	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("And1");
	
	     driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();     
	     
	}
		
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    System.out.println("Then");
	       
	    System.out.println("User is on Home Page");
	}
 
	@And("Close the browser")
	public void close_the_browser() {
	    
		System.out.println("And2");
	    driver.close();
	  //  driver.quit();
	
	}

}
