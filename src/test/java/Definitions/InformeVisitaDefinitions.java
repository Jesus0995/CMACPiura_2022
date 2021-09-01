package Definitions;

import PageObjects.LoginPage;
import PageObjects.MenuPrincipalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class InformeVisitaDefinitions {

    MenuPrincipalPage menuPrincipal;
    LoginPage loginInforme;

    public InformeVisitaDefinitions() {
          menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        loginInforme = new LoginPage(Hooks.driver);

    }

    @Given("la web SGCRED esta disponible para usarla")
    public void laWebSGCREDEstaDisponibleParaUsarla() {
        Hooks.driver.get("http://10.0.203.12:8083/propuesta/");
    }

    @When("ingreso usuario y password del perfil Asesor de Finanzas Empresariales")
    public void ingresoUsuarioYPasswordDelPerfilAsesorDeFinanzasEmpresariales(DataTable usuario) {
        List<Map<String, String>> lista = usuario.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            loginInforme.IngresarUsuario(lista.get(i).get("nombre"));
            loginInforme.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @And("doy click en boton ingresar al SGCRED")
    public void doyClickEnBotonIngresarAlSGCRED() {
        loginInforme.ClickSubmit();
        
    }

    @And("Mostrar home principal de SGCRED")
    public void mostrarHomePrincipalDeSGCRED() {
        
    }

    @And("doy click en el menu informe visita")
    public void doyClickEnElMenuInformeVisita() {
        menuPrincipal.ClickInformeVisita();
    }
}
