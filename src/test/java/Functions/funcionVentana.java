package Functions;

import Definitions.Hooks;
import org.openqa.selenium.WebDriver;

import java.util.Set;

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


    public void cerrarVentanaTitulo(){
        Set<String> ventanas = Hooks.driver.getWindowHandles();
        String ventanaPrincipal = Hooks.driver.getWindowHandle();

        System.out.println("Sesiones activas: "+ Hooks.driver.getWindowHandles());

        for (String handle: ventanas){
            Hooks.driver.switchTo().window(handle);
            System.out.println("Posicionarse en: "+Hooks.driver.getTitle());
            String pagetitle = Hooks.driver.getTitle();
            if (pagetitle.equals("Problemas al cargar la página")){
                Hooks.driver.close();
                System.out.println("Se cerró la ventana: "+pagetitle);
            }
        }

        Hooks.driver.switchTo().window(ventanaPrincipal);
    }

    public void cerrarVentanaID(){
        String[] ventanas =new String[Hooks.driver.getWindowHandles().size()];
        Integer indice = 0;

        System.out.println("Sesiones activas: "+ Hooks.driver.getWindowHandles());

        for (String idVentana : Hooks.driver.getWindowHandles()) {
            ventanas[indice] = idVentana;
            indice++;
        }

        System.out.println("SesionID 1: "+ ventanas[0]);
        System.out.println("SesionID 2: "+ ventanas[1]);

        Hooks.driver.switchTo().window(ventanas[1]).close();
        System.out.println("Se cerró SesionID 2");

        Hooks.driver.switchTo().window(ventanas[0]);
        System.out.println("Sesiones activas: "+ Hooks.driver.getWindowHandles());
    }

}
