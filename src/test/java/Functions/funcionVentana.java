package Functions;

import Definitions.Hooks;
import org.openqa.selenium.WebDriver;

public class funcionVentana {

    public void cambiarVentanaNueva(){
        WebDriver driver = Hooks.driver;
        String ventanaNueva = "";
        for (String idVentana: driver.getWindowHandles()){
            ventanaNueva = idVentana;
        }
        driver.switchTo().window(ventanaNueva);
        System.out.println("Ultima ventana: "+driver.getWindowHandle() +" - "+driver.getTitle());
    }

    public void cambiarVentanaInicial() {
        WebDriver driver = Hooks.driver;
        String[] listaVentanas = new String[driver.getWindowHandles().size()];
        Integer indice = 0;
        for (String idVentana : driver.getWindowHandles()) {
            listaVentanas[indice] = idVentana;
            indice++;
        }
        driver.switchTo().window(listaVentanas[0]);
        System.out.println("Ventana inicial: "+driver.getWindowHandle()+" - "+driver.getTitle());
    }

}
