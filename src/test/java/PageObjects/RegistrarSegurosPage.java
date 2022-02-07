package PageObjects;

import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.apache.commons.math3.analysis.function.Abs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.Set;

import Functions.funcionEsperar;

public class RegistrarSegurosPage {
    //2. crear variables
    private WebDriver driver;
    private WebDriverWait wait;
    private Set<String> identificadoresRegistrarSeguros;
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();

    //Mapear los locator de la pagina
    @FindBy(id = "4_02201") private WebElement chk_SeguroDesgravamenFlatMN;
    @FindBy(id = "dps02201") private WebElement txt_SeguroDesgravamenFlatMN;
    //cambio de ID: 5_13501
    @FindBy(id = "5_13001") private WebElement chk_SeguroRiesgoPlanPymes;
    //cambio de ID: dps13501
    @FindBy(id = "dps13001") private WebElement txt_SeguroRiesgoPlanPymes;
    @FindBy(id = "4_01301") private WebElement chk_SeguroDesgravamenSaldoCapital;
   // @FindBy(xpath = "//input[@id='4_01201']") private WebElement chk_SeguroDesgravamenSaldoCapital; --- Locator del checkbox antes del 09/12/2021. Cambió id
   @FindBy(id = "dps01301") private WebElement txt_SeguroDesgravamenSaldoCapital;
    // @FindBy(xpath = "//input[@id='dps01201']") private WebElement txt_SeguroDesgravamenSaldoCapital; --- Locator del cuadro de texto antes del 09/12/2021. Cambió id
    @FindBy(id = "6_91001") private WebElement chk_SeguroVidaPlan1;
    @FindBy(id = "dps91001") private WebElement txt_SeguroVidaPlan1;
    @FindBy(xpath = "//button[@type=\"submit\"]") private WebElement btn_confirmar;

    public void AbrirVentanaRegistrarSeguros() {
        try{
        identificadoresRegistrarSeguros = driver.getWindowHandles();
        System.out.println(identificadoresRegistrarSeguros);
        String LastHandle = "";

        for (String identificadorRegistrarSeguros : identificadoresRegistrarSeguros) {
            LastHandle = identificadorRegistrarSeguros;
        }
        driver.switchTo().window(LastHandle);
        System.out.println("Titulo:" + driver.getTitle());

    }catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana seguros";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void CerrarVentanaRegistrarSeguros() {
        try{
        Integer SetSize = identificadoresRegistrarSeguros.size();
        Integer Index = 0;
        String[] Handles = new String[SetSize];
        for (String identificadorRegistrarSeguros : identificadoresRegistrarSeguros) {
            Handles[Index] = identificadorRegistrarSeguros;
            Index++;
        }
        System.out.println(Handles[0]);
        driver.switchTo().window(Handles[0]);
    }catch (Exception Error) {
            detalleError = "Error al posicionarse en la ventana propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }


    //1.Constructor
    public RegistrarSegurosPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ClickCheckSeguroDesgravamenMN() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroDesgravamenFlatMN));
            chk_SeguroDesgravamenFlatMN.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el check Seguros desgravamen MN";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarDPSSeguroDesgravamen() {
        //int  numero = Abs(-80000000);
        try {
            int min_val = 10000000;
            int max_val = 99999999;
            Random rand = new Random();
            int rand_val = Math.abs(rand.nextInt((max_val - min_val + 1)) + min_val);
            String DPSDesgravamen = '9' + String.valueOf(rand_val);
            //System.out.println(Math.abs(a));
            System.out.println(rand.nextInt());
            System.out.println("el numero aleatorio es:" + (rand_val));
            txt_SeguroDesgravamenFlatMN.clear();
            txt_SeguroDesgravamenFlatMN.sendKeys(DPSDesgravamen);
        } catch (Exception Error) {
            detalleError = "Error al generar el numero aleatorio del seguro desgravamen";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void ClickCheckSeguroRiesgoPlanPymes() {
        try {
            objFuncionEsperar.EsperarTiempo(5);
            wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroRiesgoPlanPymes));
            chk_SeguroRiesgoPlanPymes.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar los check de seguro riesgo plan pymes";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarDPSeguroRiesgoPlanPymes() {
        try {
            int min_val = 10000000;
            int max_val = 99999999;
            Random rand = new Random();
            int rand_val1 = Math.abs(rand.nextInt(max_val - min_val + 2) + min_val);
            String DPSPlanPymes = '9' + String.valueOf(rand_val1);
            System.out.println("el numero aleatorio es:" + DPSPlanPymes);
            objFuncionEsperar.EsperarTiempo(2);
            txt_SeguroRiesgoPlanPymes.clear();
            txt_SeguroRiesgoPlanPymes.sendKeys(DPSPlanPymes);
        } catch (Exception Error) {
            detalleError = "Error al generar numeros del seguro Riesgo plan pymes";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void IngresarSeguroDesgravamenSaldoCapital() {
        try {
            int min_val = 10000000;
            int max_val = 99999999;
            Random rand = new Random();

            int rand_val = Math.abs(rand.nextInt((max_val - min_val + 1)) + min_val);
            String DPSDesgravamenSaldo = '9' + String.valueOf(rand_val);
            System.out.println("el numero aleatorio es:" + (rand_val));
            txt_SeguroDesgravamenSaldoCapital.clear();
            txt_SeguroDesgravamenSaldoCapital.sendKeys(DPSDesgravamenSaldo);
        } catch (Exception Error) {
            detalleError = "Error al generar numero de seguro desgravamen saldo";
            objLogErrores.logError(detalleError, Error);

        }
    }


    public void ClickCheckSeguroVidaPlan1() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroVidaPlan1));
            chk_SeguroVidaPlan1.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer check en el seguro vida plan 1";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarSeguroVidaPlan1() {
        try {
            int min_val = 10000000;
            int max_val = 99999999;
            Random rand = new Random();

            int rand_val1 = Math.abs(rand.nextInt((max_val - min_val + 2)) + min_val);
            String DPSVidaPlan = '9' + String.valueOf(rand_val1);
            System.out.println("el numero aleatorio es:" + (rand_val1));
            txt_SeguroVidaPlan1.clear();
            txt_SeguroVidaPlan1.sendKeys(DPSVidaPlan);
        } catch (Exception Error) {
            detalleError = "Error al ingresar dps de seguro vida plan 1";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnConfirmar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_confirmar));
            btn_confirmar.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el boton confirmar";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickCheckSeguroDesgravamenSaldoCapital() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(chk_SeguroDesgravamenSaldoCapital));
            chk_SeguroDesgravamenSaldoCapital.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el check seguro desgravamen saldo capital";
            objLogErrores.logError(detalleError, Error);

        }
    }

    public void IngresarDPSSeguroDesgravamenSaldoCapital(){
        try{
        int min_val = 10000000;
        int max_val = 99999999;
        Random rand = new Random();

        int rand_val1 = Math.abs(rand.nextInt((max_val - min_val + 2)) + min_val);
        String DPSSaldoCapital = '9' + String.valueOf(rand_val1);
        System.out.println("el numero aleatorio es:" + (rand_val1));
        txt_SeguroDesgravamenSaldoCapital.clear();
        txt_SeguroDesgravamenSaldoCapital.sendKeys(DPSSaldoCapital);
    } catch (Exception Error) {
        detalleError = "Error al ingresar dps de seguro vida plan 1";
        objLogErrores.logError(detalleError, Error);


        }


    }

}
