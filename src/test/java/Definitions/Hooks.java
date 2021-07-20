package Definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
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



    public static void tearDown(){
        driver.manage().deleteAllCookies();
        //driver.close();

    }

}
