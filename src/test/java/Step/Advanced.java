package Step;

	import static org.junit.Assert.fail;

	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.cucumber.datatable.DataTable;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import net.bytebuddy.utility.RandomString;

	public class Advanced {
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

		@Given("I am Ebay advanced seach page")
		public void i_am_ebay_advanced_seach_page() {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.ebay.com/sch/ebayadvsearch");

		}

		@When("I click on Ebay logo")
		public void i_click_on_ebay_logo() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='gh-la']")).click();

		}

		@Then("I navigated to Ebay home page")
		public void i_navigated_to_ebay_home_page() {
			String ExpectedUrl = "https://www.ebay.com/";
			String Actual = driver.getCurrentUrl();
			if (!ExpectedUrl.equals(Actual)) {
				fail("page not navigated to homepage");

			}

		}

		@Then("I advanced search item")
		public void i_advanced_search_item(DataTable dataTable) throws InterruptedException {

			driver.findElement(By.id("_nkw")).sendKeys(dataTable.cell(1, 0));
			driver.findElement(By.id("_ex_kw")).sendKeys(dataTable.cell(1, 1));
			driver.findElement(By.xpath("(//input[@class='price'])[1]")).sendKeys(dataTable.cell(1, 2));
			driver.findElement(By.xpath("(//input[@class='price'])[2]")).sendKeys(dataTable.cell(0, 3));

			driver.findElement(By.id("_nkw")).sendKeys(dataTable.cell(2, 0));
			driver.findElement(By.id("_ex_kw")).sendKeys(dataTable.cell(2, 1));
			driver.findElement(By.xpath("(//input[@class='price'])[1]")).sendKeys(dataTable.cell(2, 2));
			driver.findElement(By.xpath("(//input[@class='price'])[2]")).sendKeys(dataTable.cell(2, 3));

			driver.findElement(By.xpath("//button[@id='searchBtnLowerLnk']")).click();

		}

	}



