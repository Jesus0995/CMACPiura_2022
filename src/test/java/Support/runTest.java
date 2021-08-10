package Support;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.omg.SendingContext.RunTime;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue= "Definitions",
        //plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-report/cucumber-report.html"},
        plugin={"json:src/test/resources/report/cucumber_report.json"},
        tags = "@Prueba"
)


public class runTest {
    @AfterClass
    public static void finish(){
        try {
            System.out.println("Generando Reporte");
            String[] cmd = {"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte generado con Exito");
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }


}
