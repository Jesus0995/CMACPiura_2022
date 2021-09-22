package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

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
        txt_Usuario.clear();
        txt_Usuario.sendKeys(Usuario);
    }

    public void IngresarPassword(String Password) {
        txt_Password.clear();
        txt_Password.sendKeys(Password);
    }

    public void ClickSubmit(){
        btn_Ingresar.click();
    }

    public void ClickCerrarSesion(){
        btn_Cerrar.click();
    }

}
