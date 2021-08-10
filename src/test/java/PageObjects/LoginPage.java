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

    @FindBy(name = "txtUsuario") private WebElement txt_usuario;
    @FindBy(name = "txtPassword") private WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']") private WebElement btn_ingresar;
    @FindBy(linkText = "CERRAR SESION") private WebElement lnk_cerrar;

    public LoginPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }

    public void IngresarUsuario(String nombre) {
        txt_usuario.clear();
        txt_usuario.sendKeys(nombre);
    }

    public void IngresarPassword(String password) {
        txt_password.clear();
        txt_password.sendKeys(password);
    }

    public void ClickSubmit()
    {btn_ingresar.click();}


    public void CerrarSesion()
    {lnk_cerrar.click();}

}
