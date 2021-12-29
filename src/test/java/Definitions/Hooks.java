package Definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hooks {

    public static  WebDriver driver;

    @Before
    public static void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @After

    public static void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed");
        }
        //driver.manage().deleteAllCookies();
        //driver.close();

    }

    public static WebDriver gerDriver()
    {return driver;}

}
