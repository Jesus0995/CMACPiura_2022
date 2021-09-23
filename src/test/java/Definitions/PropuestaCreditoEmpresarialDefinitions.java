package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static Support.screenshot.pantallazo;


public class PropuestaCreditoEmpresarialDefinitions {
    //crear variables de los pages
    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage Servicio;
    PopUpComunicadoPage PopUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOpeCred;
    OperacionCreditoPage operacioncredito;
    SeleccionarSegurosPage seleccionarSeguros;
    CambioTasaCreditoPage cambioTasaCredito;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    CancelandoPagaresPage cancelandoPagares;
    GrabarDocumentoPropuestaPage grabarPropuesta;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarinformevisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;
    GrabarInformacionErroresPage grabarInformacionErrores;



    //Constructor
    public PropuestaCreditoEmpresarialDefinitions() {
        //Inicializar las paginas
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        Servicio = new SeleccionarServicioPage(Hooks.driver);
        PopUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOpeCred = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacioncredito = new OperacionCreditoPage(Hooks.driver);
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        cancelandoPagares = new CancelandoPagaresPage(Hooks.driver);
        grabarPropuesta = new GrabarDocumentoPropuestaPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarinformevisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
        grabarInformacionErrores = new GrabarInformacionErroresPage(Hooks.driver);

    }

    @Given("la web SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {

        Hooks.driver.get("http://10.0.203.12:8082/propuesta/");
    }

    @When("ingreso usuario y password")

    public void ingreso_usuario_y_password(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("nombre"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }

    @When("doy clic en boton ingresar")
    public void doy_click_en_boton_ingresar() {
        login.ClickSubmit();

    }

    @And("Mostrar home de SGCRED")
    public void mostrarHomeDeSGCRED() {

    }

    @And("doy click en link propuesta financiamiento")
    public void doyClickEnLinkPropuestaFinanciamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();
        //pantallazo();

    }

    @And("doy click en el boton crear_propuesta de la ventana Listado Propuesta")
    public void doyClickEnElBotonCrear_propuestaDeLaVentanaListadoPropuesta(){
        //listadoPropuesta.AbrirVentana();
        listadoPropuesta.ClickCrearPropuesta();
        //pantallazo();
    }

    @And("mostrar la ventana cliente para realizar la busqueda en el tab codigo")
    public void mostrarLaVentanaClienteParaRealizarLaBusquedaEnElTabCodigo() {
        //listadoClientes.AbrirVentana();
        listadoClientes.SeleccionarTabCodigo();
    }

    @And("en la ventana cliente ingresar el codigo a buscar {string}")
    public void enLaVentanaClienteIngresarElCodigoABuscar(String CodCliente) {
        listadoClientes.IngresarCodigoCliente(CodCliente);
    }


    @And("en la ventana cliente doy click en el boton buscar")
    public void enLaVentanaClienteDoyClickEnElBotonBuscar() {
        listadoClientes.ClickBuscarCliente();

    }

    @And("en la ventana cliente hacer click en el icono propuesta")
    public void enLaVentanaClienteHacerClickEnElIconoPropuesta() {

        listadoClientes.SeleccionarIconoPropuesta();
    }

    @And("el sistema muestra la ventana de servicio e ingresamos la informacion")
    public void elSistemaMuestraLaVentanaDeServicioEIngresamosLaInformacion(DataTable tipoServicio) throws IOException {

        Servicio.AbrirVentanaServicio();

        List<Map<String, String>> lista = tipoServicio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            Servicio.SeleccionarServicio(lista.get(i).get("TipoServicio"));
            Servicio.SeleccionarServicioCredito(lista.get(i).get("ServicioCredito"));
            Servicio.SeleccionarTipoPropuesta(lista.get(i).get("TipoPropuesta"));
            Servicio.SeleccionarSubTipoPropuesta(lista.get(i).get("SubTipoPropuesta"));
            Servicio.SeleccionarPromocion(lista.get(i).get("Promocion"));
            //Servicio.SeleccionarNegocio(lista.get(i).get("Negocio"));
            //Servicio.SeleccionarTipoOperacion(lista.get(i).get("TipoOperacion"));
        }

        try {
            Servicio.ClickCargar();
        } catch (Exception Error) {
        }

        Servicio.CerrarVentanaServicio();
    }

    @And("en la ventana servicio doy click en el boton cargar")

    public void enLaVentanaServicioDoyClickEnElBotonCargar() throws InterruptedException {

        Servicio.ClickCargar();
    }

    @And("validar el mensaje del popup Comunicado")
    public void validarElMensajeDelPopupComunicado(){
        // PopUpComunicado.UbicarVentanaComunicado();
        PopUpComunicado.ValidarComunicado();

    }

    @And("en la ventana propuesta ingresar comentarios en clasificacion, objetivo y justificacion")
    public void enLaVentanaPropuestaIngresarComentariosEnClasificacionObjetivoYJustificacion(DataTable comentarios) {
        List<Map<String, String>> lista = comentarios.asMaps(String.class,String.class);
        for (Integer i = 0;i < lista.size(); i++){
            propuesta.IngresarClasificacionCrediticia(lista.get(i).get("clasificacion"));
            propuesta.IngresarObjetivoCredito(lista.get(i).get("objetivo"));
            propuesta.IngresarJustificacionCredito(lista.get(i).get("justificacion"));
        }
    }

    @And("en la ventana propuesta doy click en el boton nueva operacion")
    public void enLaVentanaPropuestaDoyClickEnElBotonNuevaOperacion()
    {
        propuesta.ClickBotonOperacion();
    }


    @And("validar la ventana seleccionar operacion de credito luego doy click en boton aceptar")
    public void validarLaVentanaSeleccionarOperacionDeCreditoLuegoDoyClickEnBotonAceptar() {
        seleccionarOpeCred.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOpeCred.ValidarVentanaOP();
        } catch(Exception Error){

        }

        seleccionarOpeCred.CerrarVentanaSeleccionarOP();

    }

    @And("posicionarse en la ventana Operacion Credito e ingresar la Operacion y doy click en Calcular")

    public void posicionarseEnLaVentanaOperacionCreditoEIngresarlaOperacionYDoyClickEnCalcular(DataTable OperacionCredito) throws InterruptedException {

        operacioncredito.AbrirVentanaOperacionCredito();

        List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacioncredito.SeleccionarMoneda(lista.get(i).get("Moneda"));
            operacioncredito.IngresarMonto(lista.get(i).get("Monto"));
            operacioncredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));

        }

        operacioncredito.ClickCalcular();

    }

    @And("en la ventana Operacion Credito seleccionar plan de pagos {string}")
    public void enLaVentanaOperacionCreditoSeleccionarPlanDePagos(String PlanPagos) {
        operacioncredito.SeleccionarPlanPagos(PlanPagos);

    }

    @And("en la ventana Operacion Credito seleccionar modalidad {string}")
    public void enLaVentanaOperacionCreditoSeleccionarModalidad(String Modalidad) {
        operacioncredito.SeleccionarModalidad(Modalidad);

    }

    @And("en la ventana Operacion Credito Ingresar los dias {string}")
    public void enLaVentanaOperacionCreditoIngresarLosDias(String Dias) {
        operacioncredito.IngresarDias(Dias);
    }

    @And("en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial {string}")
    public void enLaVentanaOperacionCreditoIngresarPorcentajeDeTasaPreferencial(String TasaPreferencial) {
        operacioncredito.IngresarTasaPreferencial(TasaPreferencial);

    }

    @And("en la ventana Operacion Credito seleccionar forma de desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarFormaDeDesembolso(String FormaDesembolso) {
        operacioncredito.SeleccionarFormaDesembolso(FormaDesembolso);

    }

    @And("en la ventana Operacion Credito seleccionar plaza de desembolso")
    public void enLaVentanaOperacionCreditoSeleccionarPlazaDeDesembolso(DataTable PlazaDesembolso) {

        List<Map<String,String>> lista = PlazaDesembolso.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacioncredito.SeleccionarDepartamento(lista.get(i).get("Departamento"));
            operacioncredito.SeleccionarProvincia(lista.get(i).get("Provincia"));
            operacioncredito.SeleccionarDistrito(lista.get(i).get("Distrito"));

        }

    }

    @And("en la ventana Operacion Credito ingresar fecha probable del desembolso {string}")
    public void enLaVentanaOperacionCreditoIngresarFechaProbableDelDesembolso(String FechaDesembolso) {
        operacioncredito.IngresarFechaDesembolso(FechaDesembolso);

    }

    @And("en la ventana Operacion Credito Ingresar notas {string}")
    public void enLaVentanaOperacionCreditoIngresarNotas(String Notas) {
        operacioncredito.IngresarNotas(Notas);

    }

    @And("en la ventana Operacion Credito doy click en grabar")
    public void enLaVentanaOperacionCreditoDoyClickEnGrabar() {
        operacioncredito.ClickGrabar();

    }

    @And("en la ventana Operacion Credito aceptar la alerta")
    public void enLaVentanaOperacionCreditoAceptarLaAlerta() {
        operacioncredito.ObtenerAlerta();

        operacioncredito.CerrarVentanaOperacionCredito();
    }

    @Then("el sistema direcciona a ventana Propuesta y doy click icono cambio de tasa")
    public void elSistemaDireccionaAVentanaPropuestaYDoyClickIconoCambioDeTasa() {
        propuesta.ClickIcnCambioTasa();

    }

    @And("en la ventana Cambio Tasa de credito registro el comentario de solicitud {string}")
    public void enLaVentanaCambioTasaDeCreditoRegistroElComentarioDeSolicitud(String ComentarioCambioTasa) {
        cambioTasaCredito.AbrirVentanaCambioTasaCredito();
        cambioTasaCredito.IngresarComentarioCambio(ComentarioCambioTasa);

    }

    @And("en la ventana Cambio Tasa de Credito doy click en boton Grabar")
    public void enLaVentanaCambioTasaDeCreditoDoyClickEnBotonGrabar() {
        cambioTasaCredito.ClickGrabar();
        cambioTasaCredito.CerrarVentanaCambioTasaCredito();

    }

    @Then("el sistema direcciona a la ventana propuesta y doy click al boton Registro de seguros")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClickAlBotonRegistroDeSeguros() {
        propuesta.ClickBotonRegistrarSeguro();

    }

    @And("en la ventana Seleccion de seguros doy click en boton Confirmar")
    public void enLaVentanaSeleccionDeSegurosDoyClickEnBotonConfirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

    }


    @And("el sistema direcciona a la ventana Registro Seguros y check en seguro desgravamen flat MN")
    public void elSistemaDireccionaALaVentanaRegistroSegurosYCheckEnSeguroDesgravamenFlatMN() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenMN();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS {string}")
    public void enLaVentanaRegistroSegurosIngresarElNumeroDPS(String seguroDesgravameMN) {
        registrarSeguros.IngresarSeguroDesgravamenMN(seguroDesgravameMN);
    }

    @And("en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes")
    public void enLaVentanaRegistroSegurosHacerCheckEnSeguroTodoRiesgoPlanPymes() {
        registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS {string} del seguro Plan Pymes")
    public void enLaVentanaRegistroSegurosIngresarElNumeroDPSDelSeguroPlanPymes(String seguroRiesgoPlanPymes) {
        registrarSeguros.IngresarSeguroRiesgoPlanPymes(seguroRiesgoPlanPymes);
    }

    @And("en la ventana Registro Seguros doy click en Confirmar")
    public void enLaVentanaRegistroSegurosDoyClickEnConfirmar() {
        registrarSeguros.ClickConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();

    }

    @And("en la ventana seguros seleccionados visualizar información y doy click en cerrar")
    public void enLaVentanaSegurosSeleccionadosVisualizarInformaciónYDoyClickEnCerrar() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();

    }

    @Then("el sistema direcciona a la ventana propuesta y doy click en Anexar CheckList creditos")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClickEnAnexarCheckListCreditos() {
        propuesta.ClickAnexarCheckListCreditos();
    }

    @And("en la ventana CheckList Seccion Informacion Basica Cliente seleccionar las opciones del uno al siete")
    public void enLaVentanaCheckListSeccionInformacionBasicaDelClienteSeleccionarLasOpcionesDelUnoAlSiete() {
        anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
        anexarCheckListCreditos.Seleccionar_1TarjetaInformacion();
        anexarCheckListCreditos.Seleccionar_2CopiaFedatariaDOI();
        anexarCheckListCreditos.Seleccionar_3VigenciaPoderActualizada();
        anexarCheckListCreditos.Seleccionar_4ReciboLuz();
        anexarCheckListCreditos.Seleccionar_5CroquisDomicilio();
        anexarCheckListCreditos.Seleccionar_6GPSAgricolas();
        anexarCheckListCreditos.Seleccionar_7FotoDomicilio();

    }

    @And("en la ventana CheckList Seccion Información del Negocio seleccionar las opciones ocho al once")
    public void enLaVentanaCheckListSeccionInformaciónDelNegocioSeleccionarLasOpcionesOchoAlOnce() {
        anexarCheckListCreditos.Seleccionar_8ReciboSSBB();
        anexarCheckListCreditos.Seleccionar_9FotoNegocio();
        anexarCheckListCreditos.Seleccionar_10SustentoVigencia();
        anexarCheckListCreditos.Seleccionar_11InformeComercial();

    }

    @And("en la ventana CheckList Seccion Operaciones Propuestas seleccionar la opcion doce")
    public void enLaVentanaCheckListSeccionOperacionesPropuestasSeleccionarLaOpcionDoce() {
        anexarCheckListCreditos.Seleccionar_12SolicitudCredito();

    }

    @And("en la ventana CheckList Seccion Seguro del Cliente seleccionar la opcion trece")
    public void enLaVentanaCheckListSeccionSeguroDelClienteSeleccionarLaOpcionTrece() {
        anexarCheckListCreditos.Seleccionar_13CopiaDPS();
    }

    @And("en la ventana CheckList Seccion Seguro de Garantia seleccionar la opcion catorce")
    public void enLaVentanaCheckListSeccionSeguroDeGarantiaSeleccionarLaOpcionCatorce() {
        anexarCheckListCreditos.Seleccionar_14CopiaPolizaSeguro();
    }

    @And("en la ventana CheckList Seccion Informacion Economica Financiera seleccionar las opciones quince y dieciseis")
    public void enLaVentanaCheckListSeccionInformacionEconomicaFinancieraSeleccionarLasOpcionesQuinceYDieciseis() {
        anexarCheckListCreditos.Seleccionar_15EstadosFinancieros();
        anexarCheckListCreditos.Seleccionar_16FlujodeCaja();

    }

    @And("en la ventana CheckList Seccion Informe Verificacion Previa seleccionar la opcion diecisiete")
    public void enLaVentanaCheckListSeccionInformeVerificacionPreviaSeleccionarLaOpcionDiecisiete() {
        anexarCheckListCreditos.Seleccionar_17InformeVisitaSectorista();
    }

    @And("en la ventana CheckList Seccion Garantias No Inscribibles seleccionar las opciones dieciocho al veintidos")
    public void enLaVentanaCheckListSeccionGarantiasNoInscribiblesSeleccionarLasOpcionesDieciochoAlVeintidos() {
        anexarCheckListCreditos.Seleccionar_18BusquedaBienes();
        anexarCheckListCreditos.Seleccionar_19DocumentosSustentatorios();
        anexarCheckListCreditos.Seleccionar_20BoletaInformativa();
        anexarCheckListCreditos.Seleccionar_21ContratoPrestamo();
        anexarCheckListCreditos.Seleccionar_22DeclaracionJuradaBienes();
    }

    @And("en la ventana CheckList Seccion Garantias Con Deposicion seleccionar las opciones veintitres y veiniticuatro")
    public void enLaVentanaCheckListSeccionGarantiasConDeposicionSeleccionarLasOpcionesVeintitresYVeiniticuatro() {
        anexarCheckListCreditos.Seleccionar_23CopiaCertificadoTasacion();
        anexarCheckListCreditos.Seleccionar_24CopiaCertificadoPlazoFijo();

    }

    @And("en la ventana CheckList Seccion Garantias Inscribibles seleccionar las opciones veinticinco al treintaiuno")
    public void enLaVentanaCheckListSeccionGarantiasInscribiblesSeleccionarLasOpcionesVeinticincoAlTreintaiuno() {
        anexarCheckListCreditos.Seleccionar_25CertificadoLiteral();
        anexarCheckListCreditos.Seleccionar_26CertificadoLiteral();
        anexarCheckListCreditos.Seleccionar_27ValuacionDelBien();
        anexarCheckListCreditos.Seleccionar_28OpinionLegal();
        anexarCheckListCreditos.Seleccionar_29ContratoPrestamo();
        anexarCheckListCreditos.Seleccionar_30ContratoPrestamoPre();
        anexarCheckListCreditos.Seleccionar_31Testimonio();
    }

    @And("en la ventana CheckList Seccion Desembolso de credito con Inscripcion seleccionar las opciones treintaidos y treintaitres")
    public void enLaVentanaCheckListSeccionDesembolsoDeCreditoConInscripcionSeleccionarLasOpcionesTreintaidosYTreintaitres() {
        anexarCheckListCreditos.Seleccionar_32FichaIngresoRRPP();
        anexarCheckListCreditos.Seleccionar_33CopiaLiteralPartida();
    }

    @And("en la ventana CheckList doy clic en Guardar y Terminar finalmente acepto la alerta")
    public void enLaVentanaCheckListDoyClicEnGuardarYTerminarFinalmenteAceptoLaAlerta() {
        anexarCheckListCreditos.ClickGuardarTerminar();

        anexarCheckListCreditos.AceptarAlerta();

        anexarCheckListCreditos.CerrarVentanaAnexarCheckList();
    }

    @And("el sistema direcciona a la ventana Confirmar Checklist de Credito y doy click en cerrar")
    public void elSistemaDireccionaALaVentanaConfirmarChecklistDeCreditoYDoyClickEnCerrar() {
        confirmarCheckList.AbrirVentanaConfirmacionCheckList();
        confirmarCheckList.ClickCerrar();
        confirmarCheckList.CerrarVentanaConfirmacionCheckList();
    }

    @Then("el sistema direcciona a la ventana propuesta y se procede a ingresar los siguientes comentarios")
    public void elSistemaDireccionaALaVentanaPropuestaYSeProcedeAIngresarLosSiguientesComentarios(DataTable ComentariosJustificados) {
        List<Map<String,String>> listaComentarios = ComentariosJustificados.asMaps(String.class,String.class);
        for (Integer i = 0; i < listaComentarios.size() ;i++){
            propuesta.IngresarCaracteristicaNegocio(listaComentarios.get(i).get("CaracteristicaNegocio"));
            propuesta.IngresarClasificacionRiesgoCliente(listaComentarios.get(i).get("ClasificacionRiesgoNegocio"));
            propuesta.IngresarClasificacionRiesgoAval(listaComentarios.get(i).get("ClasificacionRiesgoAval"));
            propuesta.IngresarAnalisisUnidadF(listaComentarios.get(i).get("AnalisisUnidadFinanciera"));
        }

    }

    @And("en la ventana Propuesta doy click en Anexar Garantias Existentes")
    public void enLaVentanaPropuestaDoyClickEnAnexarGarantiasExistentes() {
        propuesta.ClickAnexarGarantias();

    }

    @And("en la ventana Seleccionar Garantias doy click en Registrar Garantias")
    public void enLaVentanaSeleccionarGarantiasDoyClickEnRegistrarGarantias() {
        seleccionarGarantia.AbrirVentanaGarantia();
        seleccionarGarantia.ClickRegistrarGarantia();
        seleccionarGarantia.CerrarVentanaGarantia();
    }

    @And("en la ventana Garantias Existentes seleccionar garantia correspondiente y doy click en Aceptar")
    public void enLaVentanaGarantiasExistentesSeleccionarGarantiaCorrespondienteYDoyClickEnAceptar() {
        seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
        seleccionarGarantiasExistentes.SeleccionarCheckGarantiaMaquinaria();
        seleccionarGarantiasExistentes.ClickbtnAceptar();
        seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();
    }

    @And("el sistema muestra una ventana de cancelacion de pagares y se cierra automaticamente")
    public void elSistemaMuestraUnaVentanaDeCancelacionDePagaresYSeCierraAutomaticamente() {
        cancelandoPagares.AbrirVentanaCancelandoPagares();
        cancelandoPagares.CerrarVentanaCancelandoPagares();

    }

    @And("en la ventana Propuesta doy click en Enlazar Estados Financieros")
    public void enLaVentanaPropuestaDoyClickEnEnlazarEstadosFinancieros() {
        propuesta.ClickEnlazarEEFF();
    }

    @Then("el sistema direcciona a la ventana Estados Financieros y doy click en Enlazar")
    public void elSistemaDireccionaALaVentanaEstadosFinancierosYDoyClickEnEnlazar() {
        enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
        enlazarEstadosFinancieros.ClickbtnEnlazar();
        enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

    }

    @And("en la ventana Propuesta doy click en Desenlazar el Informe de Visita precargado por defecto")
    public void enLaVentanaPropuestaDoyClickEnDesenlazarElInformeDeVisitaPrecargadoPorDefecto() {
        propuesta.ClickDesenlazarInformeVisita();
    }


    @Then("el sistema muestra la ventana Desenlazar Informe de Visita y doy click en el boton Realizar")
    public void elSistemaMuestraLaVentanaDesenlazarInformeDeVisitaYDoyClickEnElBotonRealizar() {
        desenlazarinformevisita.AbrirVentanaDesenlazarInformeVisita();
        desenlazarinformevisita.ClickBtnRealizar();
        desenlazarinformevisita.CerrarVentanaDesenlazarInformeVisita();
    }

    @And("el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar el nuevo Informe Visita")
    public void elSistemaRealizaLaAccionYDireccionaALaVentanaPropuestaYDoyClickEnEnlazarElNuevoInformeVisita() {
        propuesta.ClickEnlazarInformeVisita();
    }

    @Then("el sistema muestra la ventana Enlazar Informe de Visita y le doy click en el boton Realizar")
    public void elSistemaMuestraLaVentanaEnlazarInformeDeVisitaYLeDoyClickEnElBotonRealizar() {
        enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
        enlazarInformeVisita.ClickBtnRealizar();
        enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();
    }

    @And("el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar Informe Comercial Nuevo")
    public void elSistemaRealizaLaAccionYDireccionaALaVentanaPropuestaYDoyClickEnEnlazarInformeComercialNuevo() {
        propuesta.ClickEnlazarInformeComercialNuevo();
    }

    @Then("el sistema muestra la ventana Enlazar Informe Comercial y le doy click en el boton Realizar")
    public void elSistemaMuestraLaVentanaEnlazarInformeComercialYLeDoyClickEnElBotonRealizar() {
        enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
        enlazarInformeComercialNuevo.ClickBtnRealizar();
        enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();
    }

    @And("el sistema muestra la ventana Propuesta y debe ingresar comentarios de los principales ratios {string}")
    public void elSistemaMuestraLaVentanaPropuestaYDebeIngresarComentariosDeLosPrincipalesRatios(String ComentariosRatios) {
        propuesta.IngresarComentariosRatios(ComentariosRatios);
    }



    @And("el sistema direcciona a la ventana Propuesta y doy click en la opcion grabar")
    public void elSistemaDireccionaALaVentanaPropuestaYDoyClickEnLaOpcionGrabar() {

        propuesta.ClickMenuGrabarPropuesta();
    }

    @And("en la ventana Grabar Informacion doy click en el boton Cerrar")
    public void enLaVentanaGrabarInformacionDoyClickEnElBotonCerrar() {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        grabarPropuesta.ClickbtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @Then("en la ventana Propuesta doy click en el Menu Emitir Dictamen")
    public void enLaVentanaPropuestaDoyClickEnElMenuEmitirDictamen() {
        propuesta.AbrirOpcionesDictamen();
    }

    @And("en las opciones del menu Emitir Dictamen seleccionar el boton Aprobar")
    public void enLasOpcionesDelMenuEmitirDictamenSeleccionarElBotonAprobar() {
        propuesta.ClickBtnAprobarPropuesta();
    }


    @And("en la ventana Emitir Dictamen Propuesta ingresar observaciones y password del usuario asesor")
    public void enLaVentanaEmitirDictamenPropuestaIngresarObservacionesYPasswordDelUsuarioAsesor(DataTable DatosAprobacion) {
        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String,String>> lista = DatosAprobacion.asMaps(String.class,String.class);
        for (Integer i = 0; i < lista.size() ;i++){
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }

    }


    @And("en la ventana Emitir Dictamen Propuesta doy click en el boton Procesar")
    public void enLaVentanaEmitirDictamenPropuestaDoyClickEnElBotonProcesar() {
        aprobarDictamenPropuesta.ClickbtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();


    }

    @And("el sistema muestra la ventana Grabar Informacion y le doy click en el boton Cerrar")
    public void elSistemaMuestraLaVentanaGrabarInformacionYLeDoyClickEnElBotonCerrar() throws IOException {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        pantallazo();
        grabarPropuesta.ClickbtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();

    }

    @And("el sistema direcciona a la ventana listado propuesta y doy click en boton Regresar")
    public void elSistemaDireccionaALaVentanaListadoPropuestaYDoyClickEnBotonRegresar() {
        listadoPropuesta.ClickRegresar();

    }

    @And("el sistema direcciona al Menu Principal y seleccionar opcion Cerrar Sesion")
    public void elSistemaDireccionaAlMenuPrincipalYSeleccionarOpcionCerrarSesion() {
        menuPrincipal.ClickCerrarSesion();

    }

    @And("el sistema direcciona al login y doy click en boton Cerrar Sesion")
    public void elSistemaDireccionaAlLoginYDoyClickEnBotonCerrarSesion() {
        login.ClickCerrarSesion();
    }
}


