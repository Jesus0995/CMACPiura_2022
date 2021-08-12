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



    public InformeVisitaDefinitions() {
          menuPrincipal = new MenuPrincipalPage(Hooks.driver);

    }


    @And("doy click en el menu informe visita")
    public void doyClickEnElMenuInformeVisita() {
        menuPrincipal.ClickInformeVisita();

    }
}
