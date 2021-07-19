package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    //2.crear variables driver y wait
    private WebDriver driver;
    private WebDriverWait wait;

    //4. mapear los locator del objeto.
    @FindBy(name = "txtUsuario") private WebElement nombreusuario;


    //1.constructor
    public MenuPage(WebDriver d) {
        //inicializar las variables
        driver=d;
        wait = new WebDriverWait(driver,30); //3. 30 es el tiempo de espera maximo.
        PageFactory.initElements(driver,this);

    }
    //5.Crear metodo para ingresar datos en la caja
    public void Ingresarusuario(){
        nombreusuario.sendKeys("ANGI");

    }

}
