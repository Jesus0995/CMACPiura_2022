package Support;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue= "Definitions",
        //plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-report/cucumber-report.html"},
        tags = "@Prueba"
)


public class runTest {
}
