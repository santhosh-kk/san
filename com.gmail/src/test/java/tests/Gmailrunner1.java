package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"E:\\ravali242\\com.gmail\\src\\test\\resources\\features\\feature1.feature"},glue= {"classpath:glue"},monochrome=true,plugin={"pretty","html:target\\result1"})
public class Gmailrunner1
{
	
}
