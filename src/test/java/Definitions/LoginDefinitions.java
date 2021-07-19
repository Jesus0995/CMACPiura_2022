package Definitions;

import PageObjects.MenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDefinitions {

    //Crear Variables de Menu Page
    MenuPage menu;

    //crear constructor
    public LoginDefinitions() {
        menu = new MenuPage(Hooks.driver);
        menu.Ingresarusuario();
    }

    WebDriver driver;

    @Given("La web esta disponible")
    public void la_web_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/logout.jsp");
    }
    @When("Ingreso usuario")
    public void ingreso_usuario() {


    }
    @When("hago click en el boton Ingresar")
    public void hago_click_en_el_boton_ingresar() {
        Hooks.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }

    @Then("Me muestra el Home de la web SGCRED")
    public void me_muestra_el_home_de_la_web_sgcred() {

    }



    }


