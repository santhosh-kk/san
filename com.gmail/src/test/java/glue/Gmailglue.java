package glue;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailglue
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Scenario s;
	public Properties p;
	public Homepage hp;
	public Loginpage lp;
	public Composepage cp;
	
	@Before
	public void method1(Scenario s) throws Exception
	{
		this.s = s;
		FileInputStream fis = new FileInputStream("E:\\ravali242\\com.gmail\\src\\test\\resources\\repository\\file1.properties");
		p = new Properties();
		p.load(fis);
	}
	
	@Given("^launch site$")
	public void method2()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ravali242\\com.gmail\\chromedriver.exe");
		driver = new ChromeDriver();
		hp = new Homepage(driver);
		lp = new Loginpage(driver);
		cp = new Composepage(driver);
		driver.get(p.getProperty("url"));
		//wait.until(ExpectedConditions.visibilityOf(hp.uid));
		driver.manage().window().maximize();
	}
	
	@Then("^title will be \"(.*)\" for home page$")
	public void method3(String x)
	{
		String t = driver.getTitle();
		if(t.equals(x))
		{
			s.write("Gmail site Title test passed");
		}
		else
		{
			byte []b = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,"Gmail Title test was failed");
		}
	}
	
	@When("^close site$")
	public void method4()
	{
		driver.close();
	}
	
	
}
