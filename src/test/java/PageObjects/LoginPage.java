package PageObjects;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Functions.funcionExcepciones;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    @FindBy(name = "txtUsuario")
    private WebElement txt_Usuario;
    @FindBy(name = "txtPassword")
    private WebElement txt_Password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_Ingresar;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr[3]/td/form/table/tbody/tr[2]/td/button[1]")
    private WebElement btn_Cerrar;

    public LoginPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void IngresarUsuario(String Usuario) {
        try {
            txt_Usuario.clear();
            txt_Usuario.sendKeys(Usuario);

            if (txt_Usuario.getText().isEmpty()){
                detalleError = "Error al ingresar el usuario";
            }
            else {
                System.out.println("El usuario si existe");
            }
        } catch (Exception Error) {

            objLogErrores.logError(detalleError,Error);
        }
    }

    public void IngresarPassword(String Password) {
        try {
            txt_Password.clear();
            txt_Password.sendKeys(Password);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el passowrd";
            objLogErrores.logError(detalleError,Error);
        }
    }

    public void ClickSubmit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Ingresar));
            btn_Ingresar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en iniciar sesion";
            objLogErrores.logError(detalleError,Error);
        }
    }


    public void ClickCerrarSesion() {
        try {
            Esperar(32);
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click cerrar sesion";
            objLogErrores.logError(detalleError,Error);

        }
    }


    //public void CerrarNavegador(){
    // Esperar(2);
    //driver.close();
    // }

    private void Esperar(Integer Segundos) {
        Integer Milisegundos = Segundos * 1000;
        try {
            Thread.sleep(Milisegundos);
        } catch (InterruptedException error) {
            error.printStackTrace();
        }

    }

}
