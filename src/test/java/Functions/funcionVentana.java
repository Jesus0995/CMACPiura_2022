package Functions;

import Definitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class funcionVentana {

    public void cambiarVentanaNueva(){
        WebDriver driver = Hooks.driver;
        String ventanaNueva = "";
        for (String idVentana: driver.getWindowHandles()){
            ventanaNueva = idVentana;
        }
        driver.switchTo().window(ventanaNueva);
    }

    /*public void cambiarVetanaInicial(){
        WebDriver driver = Hooks.driver;
        String[] listaVentanas = new String[driver.getWindowHandles().size()];
        //String ventanaNueva = driver.getWindowHandles().stream().findFirst();
        ventanaIncial

        for (String ventanaNueva: driver.getWindowHandles()){
            listaVentanas = idVentana;
        }
        driver.switchTo().window(ventanaInicial);
    }*/

}
