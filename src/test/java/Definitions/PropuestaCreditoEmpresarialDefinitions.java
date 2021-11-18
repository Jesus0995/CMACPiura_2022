package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import Support.screenshot;

import static Support.screenshot.pantallazo;

public class PropuestaCreditoEmpresarialDefinitions {

    LoginPage login;
    MenuPrincipalPage menuPrincipal;
    ListadoPropuestaPage listadoPropuesta;
    ListadoClientesPage listadoClientes;
    SeleccionarServicioPage seleccionarServicio;
    PopUpComunicadoPage popUpComunicado;
    PropuestaPage propuesta;
    SeleccionarOperacionCreditoPage seleccionarOperacionCredito;
    OperacionCreditoPage operacionCredito;
    SeleccionarSegurosPage seleccionarSeguros;
    CambioTasaCreditoPage cambioTasaCredito;
    RegistrarSegurosPage registrarSeguros;
    ConfirmarSegurosSeleccionadosPage confirmarSeguros;
    AnexarChecklistPage anexarCheckListCreditos;
    ConfirmacionChecklistPage confirmarCheckList;
    SeleccionarGarantiaPage seleccionarGarantia;
    SeleccionarGarantiasExistentesPage seleccionarGarantiasExistentes;
    CancelandoPagaresPage cancelandoPagares;
    GrabarInformacionDocumentoPage grabarPropuesta;
    EnlazarEstadosFinancierosPage enlazarEstadosFinancieros;
    DesenlazarInformeVisitaPage desenlazarInformeVisita;
    EnlazarInformeVisitaPage enlazarInformeVisita;
    EnlazarInformeComercialNuevoPage enlazarInformeComercialNuevo;
    InformeEEFFConsolidadoGrupoVinculadoPage informeEEFFConsolidadoGrupoVinculado;
    AprobarDictamenPropuestaPage aprobarDictamenPropuesta;


    public PropuestaCreditoEmpresarialDefinitions() {

        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
        cambioTasaCredito = new CambioTasaCreditoPage(Hooks.driver);
        seleccionarSeguros = new SeleccionarSegurosPage(Hooks.driver);
        registrarSeguros = new RegistrarSegurosPage(Hooks.driver);
        confirmarSeguros = new ConfirmarSegurosSeleccionadosPage(Hooks.driver);
        anexarCheckListCreditos = new AnexarChecklistPage(Hooks.driver);
        confirmarCheckList = new ConfirmacionChecklistPage(Hooks.driver);
        seleccionarGarantia = new SeleccionarGarantiaPage(Hooks.driver);
        seleccionarGarantiasExistentes = new SeleccionarGarantiasExistentesPage(Hooks.driver);
        cancelandoPagares = new CancelandoPagaresPage(Hooks.driver);
        grabarPropuesta = new GrabarInformacionDocumentoPage(Hooks.driver);
        enlazarEstadosFinancieros = new EnlazarEstadosFinancierosPage(Hooks.driver);
        desenlazarInformeVisita = new DesenlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeVisita = new EnlazarInformeVisitaPage(Hooks.driver);
        enlazarInformeComercialNuevo = new EnlazarInformeComercialNuevoPage(Hooks.driver);
        informeEEFFConsolidadoGrupoVinculado = new InformeEEFFConsolidadoGrupoVinculadoPage(Hooks.driver);
        aprobarDictamenPropuesta = new AprobarDictamenPropuestaPage(Hooks.driver);
    }

    @Given("la web SGCRED esta disponible")
    public void la_web_sgcred_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");
    }

    @When("ingresar usuario y password")
    public void ingresar_usuario_y_password(DataTable user) {
        List<Map<String, String>> lista = user.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }
    }

    @Then("hacer click en el boton ingresar")
    public void hacer_click_en_el_boton_ingresar() {
        login.ClickSubmit();
    }

    @And("mostrar home de SGCRED")
    public void mostrarHomeDeSGCRED() {
    }

    @And("en el menu principal hacer click en el link propuesta financiamiento")
    public void en_el_menu_principal_hacer_click_en_el_link_propuesta_financiamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();

    }

    @And("en la ventana Listado de Propuestas hacer click en el boton crear propuesta")
    public void en_la_ventana_Listado_de_Propuestas_hacer_click_en_el_boton_crear_propuesta() {
        listadoPropuesta.ClickBtnCrearPropuesta();
       }

    @And("en la ventana Cliente seleccionar el tab codigo para realizar la busqueda")
    public void en_la_ventana_Cliente_seleccionar_el_tab_codigo_para_realizar_la_busqueda() {
          listadoClientes.SeleccionarTabCodigo();
    }

    @And("en la ventana Cliente ingresar el codigo a buscar {string}")
    public void en_la_ventana_Cliente_ingresar_el_codigo_a_buscar(String CodCliente) {
        listadoClientes.IngresarCodigoCliente(CodCliente);
    }


    @And("en la ventana Cliente hacer click en el boton buscar")
    public void en_la_ventana_Cliente_hacer_click_en_el_boton_buscar() {
        listadoClientes.ClickBuscarCliente();

    }

    @And("en la ventana Cliente hacer click en el icono propuesta")
    public void en_la_ventana_Cliente_hacer_click_en_el_icono_propuesta() {
        listadoClientes.SeleccionarIconoPropuesta();

    }

    @And("en la ventana Servicio ingresar informacion luego hacer click en el boton cargar")
    public void en_la_ventana_Servicio_ingresar_informacion_luego_hacer_click_en_el_boton_cargar(DataTable tipoServicio) throws IOException {

        seleccionarServicio.AbrirVentanaServicio();
        List<Map<String, String>> lista = tipoServicio.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            seleccionarServicio.SeleccionarServicio(lista.get(i).get("TipoServicio"));
            seleccionarServicio.SeleccionarServicioCredito(lista.get(i).get("ServicioCredito"));
            seleccionarServicio.SeleccionarTipoPropuesta(lista.get(i).get("TipoPropuesta"));
            seleccionarServicio.SeleccionarSubTipoPropuesta(lista.get(i).get("SubTipoPropuesta"));
            seleccionarServicio.SeleccionarPromocion(lista.get(i).get("Promocion"));
            //Servicio.SeleccionarNegocio(lista.get(i).get("Negocio"));
            //Servicio.SeleccionarTipoOperacion(lista.get(i).get("TipoOperacion"));
        }

        try {
            seleccionarServicio.ClickBtnCargar();
        } catch (Exception Error) {
            Error.printStackTrace();
            System.out.println("Error al hacer click en el boton cargar" + Error.getMessage());
        }

        seleccionarServicio.CerrarVentanaServicio();
    }

    @And("en la ventana Propuesta validar y cerrar el mensaje del popup Comunicado")
    public void en_la_ventana_Propuesta_validar_y_cerrar_el_mensaje_del_popup_Comunicado() {
        popUpComunicado.ValidarComunicado();
    }

    @And("en la ventana Propuesta hacer click en el boton nueva operacion")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_nueva_operacion() {
        propuesta.ClickBtnOperacion();
    }

    @And("en la ventana Operacion Credito hacer click en boton aceptar")
    public void en_la_ventana_Operacion_Credito_hacer_click_en_boton_aceptar() {
        seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOperacionCredito.ValidarVentanaOP();
        } catch (Exception Error) {
            System.out.println("Error al hacer click en el boton aceptar"+Error.getMessage());

        }
        seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();
    }

    @And("en la ventana Operacion Credito ingresar datos de la operacion luego hacer click en el boton calcular")
    public void en_la_ventana_Operacion_Credito_ingresar_datos_de_la_operacion_luego_hacer_click_en_el_boton_calcular(DataTable OperacionCredito) throws InterruptedException {
        operacionCredito.AbrirVentanaOperacionCredito();
        List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacionCredito.SeleccionarMoneda(lista.get(i).get("Moneda"));
            operacionCredito.IngresarMonto(lista.get(i).get("Monto"));
            operacionCredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));
        }
        operacionCredito.ClickBtnCalcular();
    }

    @And("en la ventana Operacion Credito seleccionar plan de pagos {string}")
    public void en_la_ventana_Operacion_Credito_seleccionar_plan_de_pagos(String PlanPagos) {
        operacionCredito.SeleccionarPlanPagos(PlanPagos);

    }

    @And("en la ventana Operacion Credito seleccionar modalidad {string}")
    public void en_la_ventana_Operacion_Credito_seleccionar_modalidad(String Modalidad) {
        operacionCredito.SeleccionarModalidad(Modalidad);

    }

    @And("en la ventana Operacion Credito Ingresar los dias {string}")
    public void en_la_ventana_Operacion_Credito_Ingresar_los_dias(String Dias) {

        operacionCredito.IngresarDias(Dias);
    }

    @And("en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial {string}")
    public void en_la_ventana_Operacion_Credito_ingresar_porcentaje_de_Tasa_Preferencial(String TasaPreferencial) {
        operacionCredito.IngresarTasaPreferencial(TasaPreferencial);

    }

    @And("en la ventana Operacion Credito seleccionar forma de desembolso {string}")
    public void enLaVentanaOperacionCreditoSeleccionarFormaDeDesembolso(String FormaDesembolso) {
        operacionCredito.SeleccionarFormaDesembolso(FormaDesembolso);

    }

    @And("en la ventana Operacion Credito seleccionar plaza de desembolso")
    public void enLaVentanaOperacionCreditoSeleccionarPlazaDeDesembolso(DataTable PlazaDesembolso) {

        List<Map<String, String>> lista = PlazaDesembolso.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacionCredito.SeleccionarDepartamento(lista.get(i).get("Departamento"));
            operacionCredito.SeleccionarProvincia(lista.get(i).get("Provincia"));
            operacionCredito.SeleccionarDistrito(lista.get(i).get("Distrito"));
        }
    }

    @And("en la ventana Operacion Credito ingresar fecha probable del desembolso")
    public void enLaVentanaOperacionCreditoIngresarFechaProbableDelDesembolso() {
        operacionCredito.ObtenerFechaDesembolso();

    }

    @And("en la ventana Operacion Credito Ingresar notas {string}")
    public void enLaVentanaOperacionCreditoIngresarNotas(String Notas) {
        operacionCredito.IngresarNotas(Notas);

    }

    @And("en la ventana Operacion Credito hacer click en el boton grabar")
    public void en_la_ventana_Operacion_Credito_hacer_click_en_el_boton_grabar() {
        operacionCredito.ClickBtnGrabar();

    }

    @And("en la ventana Operacion Credito hacer click en aceptar la alerta")
    public void en_la_ventana_Operacion_Credito_hacer_click_en_aceptar_la_alerta() {
        operacionCredito.ObtenerAlerta();
        operacionCredito.CerrarVentanaOperacionCredito();
    }

    @And("el sistema direcciona a ventana Propuesta y doy click icono cambio de tasa")
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

    @And("en la ventana Propuesta hacer click en el boton registro de seguros")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_registro_de_seguros() {
        propuesta.ClickBtnRegistrarSeguro();

    }

    @And("en la ventana Seleccion de seguros hacer click en el boton confirmar")
    public void en_la_ventana_Seleccion_de_seguros_hacer_click_en_el_boton_confirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();

    }

    @And("en la ventana Registro Seguros hacer check en seguro desgravamen flat MN")
    public void en_la_ventana_Registro_Seguros_hacer_check_en_seguro_desgravamen_flat_MN() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenMN();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS del seguro desgravamen")
    public void en_la_ventana_Registro_Seguros_ingresar_el_numero_DPS_del_seguro_desgravamen() {
        registrarSeguros.ObtenerNumeroAleatorioDPSSeguroDesgravamen();
    }

    @And("en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes")
    public void enLaVentanaRegistroSegurosHacerCheckEnSeguroTodoRiesgoPlanPymes() {
        registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
    }

    @And("en la ventana Registro Seguros ingresar el numero DPS del Seguro Plan Pymes")
    public void en_la_ventana_Registro_Seguros_ingresar_el_numero_DPS_del_Seguro_Plan_Pymes() {
        registrarSeguros.ObtenerNumeroAleatorioDPSeguroRiesgoPlanPymes();
    }

    @And("en la ventana Registro Seguros hacer click en el boton confirmar")
    public void en_la_ventana_Registro_Seguros_hacer_click_en_el_boton_confirmar() {
        registrarSeguros.ClickBtnConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();

    }

    @And("en la ventana Seguros seleccionados visualizar informacion y hacer click en el boton cerrar")
    public void en_la_ventana_Seguros_seleccionados_visualizar_informacion_y_hacer_click_en_el_boton_cerrar() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickBtnCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();

    }

    @And("en la ventana Propuesta hacer click en el boton anexar checkList creditos")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_anexar_checkList_creditos() {
        propuesta.ClickAnexarCheckListCreditos();
    }

    @And("en la ventana CheckList Credito seleccionar todas las opciones de la columna Expedientes")
    public void en_la_ventana_CheckList_Credito_seleccionar_todas_las_opciones_de_la_columna_Expedientes() {
        anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
        anexarCheckListCreditos.SeleccionarOpcionesCheckListCredito();
        anexarCheckListCreditos.Seleccionar_37opinionLegal();
    }

    @And("en la ventana CheckList Credito hacer click en el boton guardar y terminar finalmente aceptar la alerta")
    public void en_la_ventana_CheckList_Credito_hacer_click_en_el_boton_guardar_y_terminar_finalmente_aceptar_la_alerta() {
        anexarCheckListCreditos.ClickBtnGuardarTerminar();
        anexarCheckListCreditos.AceptarAlerta();
        anexarCheckListCreditos.CerrarVentanaAnexarCheckList();
    }

    @And("en la ventana Confirmar Checklist Credito hacer click en el boton cerrar")
    public void en_la_ventana_Confirmar_Checklist_Credito_hacer_click_en_el_boton_cerrar() {
        confirmarCheckList.AbrirVentanaConfirmacionCheckList();
        confirmarCheckList.ClickBtnCerrar();
        confirmarCheckList.CerrarVentanaConfirmacionCheckList();
    }

    @And("en la ventana Propuesta ingresar todos los comentarios de la propuesta")
    public void en_la_ventana_Propuesta_ingresar_todos_los_comentarios_de_la_propuesta() {
        propuesta.IngresarComentariosPropuesta();
        propuesta.IngresarCaracteristicaNegocio();

    }

    @And("en la ventana Propuesta hacer click en el boton anexar garantias existentes")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_anexar_garantias_existentes() {
        propuesta.ClickAnexarGarantias();

    }

    @And("en la ventana Seleccionar Garantias hacer click en el boton registrar garantias")
    public void en_la_ventana_Seleccionar_Garantias_hacer_click_en_el_boton_registrar_garantias() {
        seleccionarGarantia.AbrirVentanaGarantia();
        seleccionarGarantia.ClickRegistrarGarantia();
        seleccionarGarantia.CerrarVentanaGarantia();
    }

    @And("en la ventana Garantias Existentes seleccionar todas las garantias existentes")
    public void enLaVentanaGarantiasExistentesSeleccionarTodasLasGarantiasExistentes() {
        seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
        seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesMaquinayEquipo();
    }


    @And("en la ventana Garantias Existentes hacer click en el boton aceptar")
    public void en_la_ventana_Garantias_Existentes_hacer_click_en_el_boton_aceptar() {
        seleccionarGarantiasExistentes.ClickBtnAceptar();
        seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();
    }

    @And("en la ventana Cancelacion de pagares se cierra automaticamente")
    public void en_la_ventana_Cancelacion_de_pagares_se_cierra_automaticamente() {
        cancelandoPagares.AbrirVentanaCancelandoPagares();
        cancelandoPagares.CerrarVentanaCancelandoPagares();

    }

    @And("en la ventana Propuesta hacer click en el boton enlazar estados financieros")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_enlazar_estados_financieros() {
        propuesta.ClickEnlazarEEFF();
    }

    @And("en la ventana Estados Financieros hacer click en el boton enlazar")
    public void en_la_ventana_Estados_Financieros_hacer_click_en_el_boton_enlazar() {
        enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
        enlazarEstadosFinancieros.ClickbtnEnlazar();
        enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();

    }

    @And("en la ventana Propuesta hacer click en el boton desenlazar el informe de visita")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_desenlazar_el_informe_de_visita() {
        propuesta.ClickDesenlazarInformeVisita();
    }


    @And("en la ventana Desenlazar Informe de Visita hacer click en el boton realizar")
    public void en_la_ventana_Desenlazar_Informe_de_Visita_hacer_click_en_el_boton_realizar() {
        desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
        desenlazarInformeVisita.ClickBtnRealizar();
        desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();
    }

    @And("en la ventana Propuesta hacer click en el boton enlazar informe comercial nuevo")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_enlazar_informe_comercial_nuevo() {
        propuesta.ClickEnlazarInformeComercialNuevo();
    }

    @And("en la ventana Enlazar Informe Comercial Nuevo hacer click en el boton realizar")
    public void en_la_ventana_Enlazar_Informe_Comercial_Nuevo_hacer_click_en_el_boton_realizar() {
        enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
        enlazarInformeComercialNuevo.ClickBtnRealizar();
        enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();
    }

    @And("en la ventana Propuesta hacer click en el boton enlazar informe visita")
    public void en_la_ventana_Propuesta_hacer_click_en_el_boton_enlazar_informe_visita() {
        propuesta.ClickEnlazarInformeVisita();
    }

    @And("en la ventana Enlazar Informe de Visita hacer click en el boton realizar")
    public void en_la_ventana_Enlazar_Informe_de_Visita_hacer_click_en_el_boton_realizar() {
        enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
        enlazarInformeVisita.ClickBtnRealizar();
        enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();
    }

    @And("en la ventana Propuesta ingresar comentarios de los principales ratios {string}")
    public void en_la_ventana_Propuesta_ingresar_comentarios_de_los_principales_ratios(String ComentariosRatios) {
        propuesta.IngresarComentariosRatios(ComentariosRatios);
    }

    @And("en la ventana Propuesta hacer click en el menu grabar propuesta")
    public void en_la_ventana_Propuesta_hacer_click_en_el_menu_grabar_propuesta() {
        propuesta.ClickMenuGrabarPropuesta();
    }

    @And("en la ventana Grabar Informacion hacer click en el boton cerrar")
    public void en_la_ventana_Grabar_Informacion_hacer_click_en_el_boton_cerrar() {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        grabarPropuesta.ClickBtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @And("en la ventana Propuesta hacer click en el menu emitir dictamen")
    public void en_la_ventana_Propuesta_hacer_click_en_el_menu_emitir_dictamen() {

        propuesta.AbrirOpcionesDictamen();
    }

    @And("en la opcion del Menu Emitir Dictamen seleccionar el boton aprobar")
    public void en_la_opcion_del_Menu_Emitir_Dictamen_seleccionar_el_boton_aprobar() {
        propuesta.ClickBtnAprobarPropuesta();
    }

    @And("en la ventana Emitir Dictamen Propuesta ingresar observaciones e ingresar password del usuario asesor de negocio")
    public void en_la_ventana_Emitir_Dictamen_Propuesta_ingresar_observaciones_e_ingresar_password_del_usuario_asesor_de_negocio(DataTable DatosAprobacion) {
        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = DatosAprobacion.asMaps(String.class, String.class);
        for (Integer i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }
    }

    @And("en la ventana Emitir Dictamen Propuesta hacer click en el boton procesar")
    public void en_la_ventana_Emitir_Dictamen_Propuesta_hacer_click_en_el_boton_procesar() throws IOException {
        pantallazo();
        aprobarDictamenPropuesta.ClickBtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }

    @And("en la ventana Grabar Informacion hacer click en el boton cerrar ventana")
    public void en_la_ventana_Grabar_Informacion_hacer_click_en_el_boton_cerrar_ventana() {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        grabarPropuesta.ClickBtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();
    }

    @And("en la ventana Listado propuesta hacer click en boton regresar")
    public void en_la_ventana_Listado_propuesta_hacer_click_en_boton_regresar() {
        listadoPropuesta.ClickBtnRegresar();
    }

    @And("en la ventana Menu Principal hacer click en la opcion cerrar sesion")
    public void en_la_ventana_Menu_Principal_hacer_click_en_la_opcion_cerrar_sesion() {
        menuPrincipal.ClickBtnCerrarSesion();
    }

    @And("en la ventana Login hacer click en boton cerrar sesion")
    public void en_la_ventana_Login_hacer_click_en_boton_cerrar_sesion() {
        login.ClickBtnCerrarSesion();
    }

    @And("finalmente cerrar el navegador para iniciar nuevamente")
    public void finalmenteCerrarElNavegadorParaIniciarNuevamente() {
        Hooks.driver.close();

    }
}






