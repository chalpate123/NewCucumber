package LoginStep;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class Login {

	WebDriver driver;
	String baseurl;
	String Actual;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void teardown() throws InterruptedException, IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String str = RandomString.make(2);
		System.out.println(str);
		File dest = new File("C:\\New folder\\NewProject\\screenshot" + str + ".png");
		FileUtils.copyFile(src, dest);
		driver.quit();
	}

	@Given("user is on register page")
	public void user_is_on_register_page() {
		System.out.println("Login page");
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\NewProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseurl = "https://shop.demoqa.com/my-account/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(baseurl);

	}

	@When("user enter following data")
	public void user_enter_following_data(DataTable dataTable) {

		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);
		int datasize = userdata.size();

		for (int i = 0; i < datasize; i++) {

			driver.findElement(By.xpath("//input[@id='reg_username']")).sendKeys(userdata.get(i).get("username"));
			driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(userdata.get(i).get("email"));
			driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(userdata.get(i).get("password"));
			System.out.println("submit");
			driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
			System.out.println("logged user as name " + userdata.get(i).get("username"));

			driver.navigate().to(baseurl);

		}

	}

	@Then("user navigated to login page")
	public void user_navigated_to_login_page() {
		System.out.println("User is on login page");

	}

}
