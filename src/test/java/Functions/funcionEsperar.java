package Functions;


import Definitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class funcionEsperar {

    public void EsperarTiempo(Integer Segundos){
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void EsperarCierreVentana(String VentanaUltima){
        WebDriver driver = Hooks.driver;

        System.out.println("Inicio cerrar ventana");

        for (int i = 0; i <=240; i+=1)
        {
            if(driver.getWindowHandles().contains(VentanaUltima)){
                EsperarTiempo (1);
                System.out.println("Esperando el cierre de ventana:" +i);
            }
            else{
                i = 241;
            }
        }
    }
}