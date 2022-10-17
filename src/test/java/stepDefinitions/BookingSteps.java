package stepDefinitions;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class BookingSteps {
	WebDriver driver;
	@Given("Sam has login with {string} and {string}")
	public void sam_has_login_with_and(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver","C:\\Users\\nniharik\\install\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/FlyAway/login");
	
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.name("email_id"));
		username.sendKeys(string);
		WebElement pwd = driver.findElement(By.name("pwd"));
		pwd.sendKeys(string2);
		WebElement login = driver.findElement(By.tagName("button"));
		login.click();
		Thread.sleep(4000);
	    int lstLogout= driver.findElements(By.linkText("Logout")).size();
	    Assert.assertTrue(lstLogout>0);
	}
	@Given("Same has open home page")
	public void same_has_open_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.linkText("Home")).click();
	}
	@When("Sam selects {string} as source and {string} as destination")
	public void sam_selects_as_source_and_as_destination(String Source, String Destination) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    Select selectSrc = new Select(driver.findElement(By.name("source")));
	    Select selectDest = new Select(driver.findElement(By.name("destination")));
	    selectSrc.selectByVisibleText(Source);
	    selectDest.selectByVisibleText(Destination);
	    Thread.sleep(4000);
	}
	@When("Sam clicks on submit")
	public void sam_clicks_on_submit() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Submit = driver.findElement(By.tagName("button"));	
		Submit.click();
	}
	@Then("Sam is able to validate for flight id {string} with message {string}")
	public void sam_is_able_to_see_the(String flightNo, String expMessage) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> lstFlights = driver.findElements(By.linkText("Book Flight"));
//		lstFlights.click();
		String actMsg = "Flight NOT Present";
	    for (WebElement flight : lstFlights) {
	    	System.out.println(flight.getAttribute("href"));
			if (flight.getAttribute("href").contains("bookflight?id="+flightNo)) {
				actMsg = "Flight Present";
				break;
			}
		}
	    Assert.assertEquals( expMessage, actMsg);
	    driver.close();
	}
}

