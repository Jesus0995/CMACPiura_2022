package Definitions;

import Functions.ReadExcelFile;
import Functions.WriteExcelFile;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ReadExcelDefinitions {

    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;

    LoginPage login;


    public ReadExcelDefinitions() {


       login = new LoginPage(Hooks.driver);


    }

    @Given("la pagina disponible")
    public void la_pagina_disponible() {

        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }
    @When("login en la pagina")
    public void login_en_la_pagina() throws IOException {
        login.lecturaLogin();

    }


}
