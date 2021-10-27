package HomeStep;


	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;
	import static org.junit.Assert.fail;
	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import net.bytebuddy.utility.RandomString;


	public class Homepage {
		WebDriver driver;

		@Before
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		@After
		public void teardown(Scenario scenario) throws InterruptedException, IOException {
			if (scenario.isFailed()) {

				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String str = RandomString.make(4);
				File dest = new File("C:/New folder/NewProject/screenshot" + str + ".png");
				FileUtils.copyFile(src, dest);
			}
			driver.quit();
		}

		@Given("I am on ebay home page")
		public void i_am_on_ebay_home_page() {

			driver.get("https://www.ebay.com/");

		}

		@When("I click on advanced link")
		public void i_click_on_advanced_link() {
			driver.findElement(By.linkText("Advanced")).click();

		}

		@Then("I navigate to advanced search page")
		public void i_navigate_to_advanced_search_page() throws InterruptedException, IOException {
			String ExpectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
			String Actual = driver.getCurrentUrl();
			Assert.assertEquals(Actual, ExpectedUrl);
			// cb.teardown();

		}

		@When("I search for {string}")
		public void i_search_for_iphone12(String str1) {
			driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
			driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

		}

		@Then("Validate the name {string}")
		public void validate_the_name(String ExpectedName) {
			String ActualName = driver
					.findElement(By.xpath(
							"(((//div[@class='clearfix srp-controls__row-2']/div)[1]/div)[1]/h1/span[@class='BOLD'])[2]"))
					.getText();
			System.out.println(ActualName);
			Assert.assertEquals(ActualName, ExpectedName);
			System.out.println("Name is matched TC passed");
		}

		@When("I click on {string}")
		public void i_click_on(String string) throws InterruptedException {
			driver.findElement(By.linkText(string)).click();
			Thread.sleep(1000);
		}

		@Then("I validate that page  navigates to {string}")
		public void i_validate_that_page_navigates_to(String url) {
			String actualurl = driver.getCurrentUrl();
			Assert.assertEquals(actualurl, url);
			System.out.println("Tc is passed");
		}

		@When("search for {string}")
		public void search_for(String name) {
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
			driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

		}

		@Then("validate the {string} of page")
		public void validate_the_of_page(String Title) {
			String actual = driver.getTitle();
			Assert.assertTrue(actual.contains(Title));
			System.out.println("Title is matched");
		}

	}



