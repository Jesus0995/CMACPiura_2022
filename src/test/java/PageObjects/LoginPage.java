package PageObjects;

import Functions.*;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();



    @FindBy(name = "txtUsuario") private WebElement txt_Usuario;
    @FindBy(name = "txtPassword") private WebElement txt_Password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_Ingresar;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr[3]/td/form/table/tbody/tr[2]/td/button[1]") private WebElement btn_Cerrar;


    public LoginPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void IngresarUsuario(String Usuario) {
        try {
            txt_Usuario.clear();
            txt_Usuario.sendKeys(Usuario);
            if (txt_Usuario.getText().isEmpty()) {
                detalleError = "Error al ingresar el usuario";
            } else {
                System.out.println("El usuario si existe");
            }
        } catch (Exception Error) {

            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarPassword(String Password) {
        try {
            txt_Password.clear();
            txt_Password.sendKeys(Password);
        } catch (Exception Error) {
            detalleError = "Error al ingresar el passowrd";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickSubmit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Ingresar));
            btn_Ingresar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en iniciar sesion";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickBtnCerrarSesion() {
        try {
            objFuncionEsperar.EsperarTiempo(5);
            wait.until(ExpectedConditions.elementToBeClickable(btn_Cerrar));
            btn_Cerrar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click cerrar sesion";
            objLogErrores.logError(detalleError, Error);

        }
    }


    public void lecturaLogin() throws IOException {
        // String filepath = "C:\\Matriz.xlsx";

        // String searchLogin = readFile.getCellValue(filepath, "Sheet1", 0, 0);

        //String searchPassword = readFile.getCellValue(filepath, "Sheet1", 0, 1);

        //String resultTest = "ok";

       /* txt_Usuario.clear();
        txt_Usuario.sendKeys(searchLogin);
        System.out.println("VALOR EXCEL usuario"+searchLogin);
        txt_Password.clear();
        txt_Password.sendKeys(searchPassword);
        System.out.println("VALOR EXCEL password"+searchPassword);
        btn_Ingresar.click();


        System.out.println("resultado"+resultTest);

        readFile.readExcel(filepath,"Hoja1");

        writeFile.writeCellValue(filepath,"Hoja1",0,2,resultTest);

        readFile.readExcel(filepath,"Hoja1");
*/



    }


}
