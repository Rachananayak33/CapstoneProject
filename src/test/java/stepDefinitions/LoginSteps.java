package stepDefinitions;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginSteps{
	WebDriver driver;
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user is on the login page");
System.setProperty("webdriver.chrome.driver","C:\\Users\\nniharik\\install\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/FlyAway/login");
		driver.manage().window().maximize();
		
		
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String UN, String PWD) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user enters UN and Password");
		WebElement username = driver.findElement(By.name("email_id"));
		username.sendKeys("user@user.com");
		WebElement pwd = driver.findElement(By.name("pwd"));
		pwd.sendKeys("user");
	}
	@When("user clicks on Login")
	public void user_clicks_on_login() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user clicks on Login");
		WebElement login = driver.findElement(By.tagName("button"));
		Thread.sleep(4000);
		
		// driver.findElement(By.tagName("button"));
		login.click();
	}
	@Then("user should be able to validate {string}")
	public void user_should_be_able_to_validate(String pageName) {
	    // Write code here that turns the phrase above into concrete actions
		String actTitle= driver.getTitle();
		Assert.assertEquals(pageName, actTitle);
	}
	@Then("user should be navigated to {string}")
	public void user_should_be_navigated_to(String expString) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> lstLogout=driver.findElements(By.linkText("Logout"));
		String actStatus;
		if(lstLogout.size()>0) {
			actStatus= "Login Pass";
		}
		else {
			actStatus= "Login Fail";
		}
	}
	@Then("user should be able to Login successfully")
	public void user_should_be_able_to_login_successfully() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user should be able to Login successfully");
		List<WebElement> listLogout = driver.findElements(By.linkText("Logout"));
		Assert.assertTrue(listLogout.size()>0);
	}
	@Then("user should navigate to {string}")
	public void user_should_navigated_to_home_page(String expPage) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user should navigated to home page");
		String strTitle = driver.getTitle();
		System.out.println(strTitle);
		Assert.assertEquals(expPage, strTitle);
		driver.close();
	}
//	@Given("user is able to login successfully with valid details")
//	
}
