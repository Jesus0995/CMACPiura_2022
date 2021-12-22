package PageObjects;

import Functions.funcionEsperar;
import Functions.funcionExcepciones;
import Functions.funcionVentana;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// from selenium.webdriver.common.keys import Keys  # Antes de usar el método de la tecla del teclado, primero debe importar el paquete de la clase de teclas.

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class PropuestaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private funcionVentana objFuncionVentana = new funcionVentana();
    private funcionEsperar objFuncionEsperar = new funcionEsperar();
    private funcionExcepciones objLogErrores = new funcionExcepciones();
    private String detalleError = new String();
    protected static String numeroPropuesta;
    protected static String montoLiquidacion;
    protected static String monto;

    /*************

     *************/


    @FindBy(xpath = "//textarea[@name='comentCalifCred']") private WebElement txt_ClasificacionCrediticia;
    @FindBy(id = "txtobjetivo") private WebElement txt_ObjetivoCredito;
    @FindBy(id = "justificacion") private WebElement txt_JustificacionCredito;
    @FindBy(name = "btnEnviar") private WebElement btn_NuevaOperacion;
    @FindBy(xpath = "//img[@src='./images/mail-send-receive.png']") private WebElement icn_CambioTasa;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[7]/tbody/tr[1]/td[2]/button") private WebElement btn_AgregarSeguro;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[8]/tbody/tr[1]/td[2]/button") private WebElement btn_AnexarChecklist;
    @FindBy(xpath = "//textarea[@id='txtcaracter']") private WebElement txt_CaracteristicaNegocio; //se cambio el name del nuevo ambiente //textarea[@name='caractNegocio']
    @FindBy(xpath = "//textarea[@id='txtclasificac']") private WebElement txt_ClasificacionRiesgoCliente;
    @FindBy(xpath = "//textarea[@id='txtclasificaAval']") private WebElement txt_ClasificacionRiesgoAval;
    @FindBy(xpath = "//textarea[@id='txtanalisisUEF']") private WebElement txt_AnalisisUnidadFinanciera;
    //nuevos cambios en locator de las cajas de texto de comentarios 29/09
    @FindBy(xpath = "//textarea[@id='txtProducServic']") private WebElement txt_Productos;
    @FindBy(xpath = "//textarea[@id='txtPrincClienProv']") private WebElement txt_PrincipalesClientes;
    @FindBy(xpath = "//textarea[@id='txtPersonalLabora']") private WebElement txt_PersonalLaboral;
    @FindBy(xpath = "//textarea[@id='txtSectorEconomic']") private WebElement txt_AnalisisSector;
    @FindBy(xpath = "//textarea[@id='txtProyeccCreci']") private WebElement txt_ProyeccionesCrecimiento;
    @FindBy(xpath = "//button[@name=\"btnGaranExist\"]") private WebElement btn_AnexarGarantias;
    @FindBy(xpath = "//textarea[@id='txtPrincipalRatio']") private WebElement txt_ComentariosRatios;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[2]/td/table[1]/tbody/tr[2]/td[1]/table/tbody/tr/td[5]/a") private WebElement btn_Grabar;
    @FindBy(xpath = "//td[@id='NewDdTD']") private WebElement btn_Dictamen;
    @FindBy(xpath = "//img[@alt='Aprobar']") private WebElement btn_AprobarPropuesta;
    @FindBy(xpath = "//button[@name='btnEnviar2']") private WebElement btn_VerificarCheckListCredito;
    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[6]/td[3]/button") private WebElement btn_EnlazarEEFFGrupoVinculado;

    //  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/h3") private WebElement lblNumeroPropuesta;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[9]/tbody/tr/td[2]/button") private WebElement btn_CancelarPagares;
    @FindBy(xpath = "/html/body/form/table[1]/tbody/tr[3]/td/div/table[10]/tbody/tr[2]/td[9]/span/img") private WebElement icn_CondicionRefinanciar;

    @FindBy(name = "btnEnviar") private WebElement btn_SolicitarReprogramacion;
    @FindBy(xpath = "//button[text()='Desenlazar']") private WebElement btn_DesenlazarInformeVisitaReprogramacion;

    //---------------/html/body/form/table/tbody/tr[3]/td/div/table[22]/tbody/tr[1]/td[3]/button--------locator de Enlazar Inf.Visita antes del 06/12/2021
    //---------------/html/body/form/table/tbody/tr[3]/td/div/table[22]/tbody/tr[2]/td[3]/button--------locator de Enlazar Inf.Comercial antes del 06/12/2021

    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[1]/td[3]/button") private WebElement btn_EnlazarInformeVisitaReprogramacion; // locator fue cambiado el 06/12/2021
    @FindBy(xpath = "/html/body/form/table[2]/tbody/tr[2]/td[3]/button") private WebElement btn_EnlazarInformeComercialReprogramacion; //locator fue cambiado el 06/12/2021

    @FindBy(xpath = "//img[@alt='Regresar']") private WebElement btn_Regresar;
    @FindBy(name = "observCuota") private WebElement txt_ObservacionMontoPago;
    @FindBy(name="observMejoraGar") private WebElement txt_ObservacionMejoraGarantia;


    public PropuestaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);

    }

    public void ClickBtnOperacion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_NuevaOperacion));
            btn_NuevaOperacion.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton nueva operacion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickIcnCambioTasa() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(icn_CambioTasa));
            icn_CambioTasa.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el icono cambio de tasa";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegistrarSeguro() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_AgregarSeguro));
            btn_AgregarSeguro.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton registrar seguro";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void ClickAnexarCheckListCreditos() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarChecklist));
            btn_AnexarChecklist.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton anexar check ist creditos";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarComentariosPropuesta() {
        try {
            List<WebElement> elementList = driver.findElements(By.tagName("textarea"));
            for (WebElement textarea : elementList) {
                textarea.sendKeys("descripcion general de la propuesta");
            }
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios en la propuesta";
            objLogErrores.logError(detalleError, Error);
        }

    }

    public void IngresarCaracteristicaNegocio() {
        try {
            txt_CaracteristicaNegocio.clear();
            txt_CaracteristicaNegocio.sendKeys("descripcion general de la propuesta");

        } catch (Exception Error) {
            detalleError = "Error al ingresar caracteristica del negocio";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void IngresarClasificacionCrediticia(String clasificacion) {
        try {
            txt_ClasificacionCrediticia.clear();
            txt_ClasificacionCrediticia.sendKeys(clasificacion);
        } catch (Exception Error) {
            detalleError = "Error al ingresar decripcion en clasificacion crediticia";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarObjetivoCredito(String Objetivo) {
        try {
            txt_ObjetivoCredito.clear();
            txt_ObjetivoCredito.sendKeys(Objetivo);

        } catch (Exception Error) {
            detalleError = "Error al ingresar descripcion en objetivo del credito";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarJustificacionCredito(String Justificacion) {
        try {
            txt_JustificacionCredito.clear();
            txt_JustificacionCredito.sendKeys(Justificacion);
        } catch (Exception Error) {
            detalleError = "Error al ingresar descripcion en justificacion del credito";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickAnexarGarantias() {
        try {
            objFuncionEsperar.EsperarTiempo(2);
            wait.until(ExpectedConditions.elementToBeClickable(btn_AnexarGarantias));
            btn_AnexarGarantias.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton anexar garantias";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarEEFF() {
        try {
            WebElement btn_EnlazarEEFF = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td/div/button"));
            objFuncionEsperar.EsperarTiempo(1);
            String JScript = btn_EnlazarEEFF.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar estados financieros";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarComentariosRatios(String ComentariosRatios) {
        try {
            txt_ComentariosRatios.clear();
            txt_ComentariosRatios.sendKeys(ComentariosRatios);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentarios de la seccion ratios";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickDesenlazarInformeVisita() {

        try {
            WebElement btn_desenlazarInformeVisita = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[3]/button"));
            String JScript = btn_desenlazarInformeVisita.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton desenlazar informe visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickDesenlazarInformeVisitaConsumo() {
        try {
            WebElement btn_desenlazarInformeVisitaConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[1]/td[3]/button"));
            String JScript = btn_desenlazarInformeVisitaConsumo.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton desenlazar informe visita consumo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeVisita() {
        try {
            WebElement btn_enlazarInformeVisita = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[3]/button"));
            String JScript = btn_enlazarInformeVisita.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar informe visita";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeVisitaConsumo() {
        try {
            WebElement btn_enlazarInformeVisitaConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[1]/td[3]/button"));
            String JScript = btn_enlazarInformeVisitaConsumo.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar informe visita consumo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeComercialNuevo() {
        try {
            WebElement btn_enlazarInformeComercial = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[3]/td[3]/button"));
            String JScript = btn_enlazarInformeComercial.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar informe comercial nuevo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeComercialConsumo() {
        try {
            WebElement btn_enlazarInformeComercialConsumo = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/div/table[18]/tbody/tr[2]/td[3]/button"));
            String JScript = btn_enlazarInformeComercialConsumo.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar informe comercial consumo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarHojaTrabajo() {
        try {
            WebElement btn_enlazarInformeComercial = driver.findElement(By.xpath(" /html/body/form/table/tbody/tr[3]/td/div/table[16]/tbody/tr/td[3]/button"));
            String JScript = btn_enlazarInformeComercial.getAttribute("onclick");
            ((JavascriptExecutor) driver).executeScript(JScript);
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar hoja de trabajo";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickMenuGrabarPropuesta() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Grabar));
            btn_Grabar.click();
            objFuncionEsperar.EsperarTiempo(30);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton grabar propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void AbrirOpcionesDictamen() {
        try {
            btn_Dictamen.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton opciones dictamen";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void ClickBtnAprobarPropuesta() {
        try {
            //objFuncionEsperar.EsperarTiempo(1);
            btn_AprobarPropuesta.click();
            objFuncionEsperar.EsperarTiempo(2);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton aprobar propuesta";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnVerificarCheckListCredito() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_VerificarCheckListCredito));
            btn_VerificarCheckListCredito.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton verificar checklist credito";
            objLogErrores.logError(detalleError, Error);
        }
    }


    //Fundamentacion credito adicionado el 29/09/2020---- inicio-----------
    public void IngresarProductosNegocio(String ProductosNegocio) {
        try {
            txt_Productos.clear();
            txt_Productos.sendKeys(ProductosNegocio);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentario en productos negocio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarPrincipalesClientes(String PrincipalesClientes) {
        try {
            txt_PrincipalesClientes.clear();
            txt_PrincipalesClientes.sendKeys(PrincipalesClientes);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentario en principales clientes";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarPersonalNegocio(String PersonalNegocio) {
        try {
            txt_PersonalLaboral.clear();
            txt_PersonalLaboral.sendKeys(PersonalNegocio);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentario en personal negocio";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarAnalisisSector(String AnalisisSector) {

        try {
            txt_AnalisisSector.clear();
            txt_AnalisisSector.sendKeys(AnalisisSector);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentario en analisis sector financiero";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void IngresarProyeccionesCrecimiento(String ProyeccionesCrecimiento) {
        try {
            txt_ProyeccionesCrecimiento.clear();
            txt_ProyeccionesCrecimiento.sendKeys(ProyeccionesCrecimiento);
        } catch (Exception Error) {
            detalleError = "Error al ingresar comentario en proyeccines de crecimiento";
            objLogErrores.logError(detalleError, Error);
        }
    }

    //----------- fin de cambio 29/09/2021-----------------------
    public void ClickBtnEnlazarEEFFGrupoVinculadO() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarEEFFGrupoVinculado));
            btn_EnlazarEEFFGrupoVinculado.click();
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlaar estados financieros grupo vinculado";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public String CapturarNumeroPropuesta() {

        WebElement lblNumeroPropuesta = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr[3]/td/input[3]"));
        numeroPropuesta = lblNumeroPropuesta.getAttribute("value");//.replace("PROPUESTA DE FINANCIAMIENTO N º","");
        System.out.println("El numero de propuesta es: " + numeroPropuesta);
        return numeroPropuesta;
    }

    public void ClickIconoCondicionRefinanciar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(icn_CondicionRefinanciar));
            icn_CondicionRefinanciar.click();

        } catch (Exception Error) {
            detalleError = "Error al seleccionar boton cancelar pagares";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickBtnRegresar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_Regresar));
            btn_Regresar.click();
            objFuncionEsperar.EsperarTiempo(2);

        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton regresar";
            objLogErrores.logError(detalleError, Error);
        }
    }

    //----------- Flujo de Reprogramación -----------------------

    public void ClickBtnSolicitarReprogramacion() {
        try {
            objFuncionEsperar.EsperarTiempo(1);
            wait.until(ExpectedConditions.elementToBeClickable(btn_SolicitarReprogramacion));
            btn_SolicitarReprogramacion.click();
        } catch (Exception Error) {
            detalleError = "Error al hacer click en el botón Solicitar Reprogramación";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickDesenlazarInformeVisitaReprogramacion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_DesenlazarInformeVisitaReprogramacion));
            btn_DesenlazarInformeVisitaReprogramacion.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton desenlazar informe visita reprogramacion";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeVisitaReprogramacion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeVisitaReprogramacion));
            btn_EnlazarInformeVisitaReprogramacion.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el boton enlazar informe visita reprogramación";
            objLogErrores.logError(detalleError, Error);
        }
    }

    public void ClickEnlazarInformeComercialReprogramacion() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btn_EnlazarInformeComercialReprogramacion));
            btn_EnlazarInformeComercialReprogramacion.click();
            objFuncionEsperar.EsperarTiempo(1);
        } catch (Exception Error) {
            detalleError = "Error al seleccionar el botón enlazar informe comercial reprogramacion";
            objLogErrores.logError(detalleError, Error);
        }
    }


    public void CapturarMontoLiquidacion() {
        ////*[text()='Monto Liquidacion:']/following::text()[1]
        ///html/body/form/table[1]/tbody/tr[3]/td/div/table[9]/tbody/tr[2]/td[6]

        WebElement lblMontoLiquidacion = driver.findElement(By.xpath("//*[text()='Monto Liquidacion:']/following::text()[1]"));
        monto = lblMontoLiquidacion.getAttribute("text");
        System.out.println(monto);
        //String dato[] = lblMontoLiquidacion.getText().replace("Tipo: Normal    Servicio: CREDITOS PYMES ","").split("S/ ");
        //monto = dato[0];
        //System.out.println(monto);


    }

    ////*[contains(text(),'Monto Liquidacion:')]//following-sibling[]
        /*
        protected static String mes;
        protected static String anio;

        public void CapturarFecha (){
            wait.until(ExpectedConditions.visibilityOf(lbl_fecha));
            //Exp: 22/12/2021
            //montoliquidacion : s/.550.00
            String dato[]=lbl_fecha.getText().replace("Exp:- ","").split("/");
            mes=dato[0];
            anio=dato[1];
            System.out.println(mes);
            System.out.println(anio);
        }
*/
}









