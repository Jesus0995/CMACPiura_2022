package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.messages.Messages;

import java.util.List;
import java.util.Map;

public class PropuestaCreditoEmpresarialGrupoVinculadoDefinitions {

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

    public PropuestaCreditoEmpresarialGrupoVinculadoDefinitions() {
        login = new LoginPage(Hooks.driver);
        menuPrincipal = new MenuPrincipalPage(Hooks.driver);
        listadoPropuesta = new ListadoPropuestaPage(Hooks.driver);
        listadoClientes = new ListadoClientesPage(Hooks.driver);
        seleccionarServicio = new SeleccionarServicioPage(Hooks.driver);
        popUpComunicado = new PopUpComunicadoPage(Hooks.driver);
        propuesta = new PropuestaPage(Hooks.driver);
        seleccionarOperacionCredito = new SeleccionarOperacionCreditoPage(Hooks.driver);
        operacionCredito = new OperacionCreditoPage(Hooks.driver);
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

    @Given("web SGCRED esta disponible")
    public void web_sgcred_esta_disponible() {
        Hooks.driver.get("http://10.0.203.12:8081/propuesta/");

    }
    @When("ingresar el usuario y password")
    public void ingresar_el_usuario_y_password(DataTable usuario) {
        List<Map<String,String>> lista = usuario.asMaps(String.class,String.class);
        for (int i=0; i < lista.size();i++ ) {
            login.IngresarUsuario(lista.get(i).get("usuario"));
            login.IngresarPassword(lista.get(i).get("password"));
        }

    }
    @Then("hacer click en boton ingresar")
    public void hacer_click_en_boton_ingresar() {
        login.ClickSubmit();

    }
    @And("mostrar pagina principal de SGCRED")
    public void mostrar_pagina_principal_de_sgcred() {

    }
    @And("en el menu principal doy click en link propuesta financiamiento")
    public void en_el_menu_principal_doy_click_en_link_propuesta_financiamiento() {
        menuPrincipal.ClickPropuestaFinanciamiento();

    }
    @And("en la ventana listado de propuestas hacer click en el boton crear propuesta")
    public void en_la_ventana_listado_de_propuestas_hacer_click_en_el_boton_crear_propuesta() {
        listadoPropuesta.ClickBtnCrearPropuesta();
    }
    @And("en la ventana cliente seleccionar el tab codigo para realizar la busqueda")
    public void en_la_ventana_cliente_seleccionar_el_tab_codigo_para_realizar_la_busqueda() {
        listadoClientes.SeleccionarTabCodigo();

    }
    @And("en la ventana cliente ingresar codigo a buscar {string}")
    public void en_la_ventana_cliente_ingresar_codigo_a_buscar(String CodCliente) {
        listadoClientes.IngresarCodigoCliente(CodCliente);

    }
    @And("en la ventana cliente hacer click en el boton buscar")
    public void en_la_ventana_cliente_hacer_click_en_el_boton_buscar() {
        listadoClientes.ClickBuscarCliente();

    }
    @And("en la ventana cliente hacer click en el icon propuesta")
    public void en_la_ventana_cliente_hacer_click_en_el_icon_propuesta() {
        listadoClientes.SeleccionarIconoPropuesta();

    }
    @And("en la ventana servicio ingresar informacion y hacer click en el boton cargar")
    public void en_la_ventana_servicio_ingresar_informacion_y_hacer_click_en_el_boton_cargar(DataTable servicio) {
        seleccionarServicio.AbrirVentanaServicio();
        List<Map<String,String>> lista = servicio.asMaps(String.class,String.class);
        for (int i = 0; i < lista.size();i++){
            seleccionarServicio.SeleccionarServicio(lista.get(i).get("TipoServicio"));
            seleccionarServicio.SeleccionarServicioCredito(lista.get(i).get("ServicioCredito"));
            seleccionarServicio.SeleccionarTipoPropuesta(lista.get(i).get("TipoPropuesta"));
            seleccionarServicio.SeleccionarSubTipoPropuesta(lista.get(i).get("SubTipoPropuesta"));
            seleccionarServicio.SeleccionarPromocion(lista.get(i).get("Promocion"));

        }
        try{
            seleccionarServicio.ClickBtnCargar();
        }catch (Exception Error){
            Error.printStackTrace();
            System.out.println("Error al hacer click en el boton cargar" +Error.getMessage());
        }
        seleccionarServicio.CerrarVentanaServicio();

    }
    @And("en la ventana propuesta validar el mensaje del popup Comunicado")
    public void en_la_ventana_propuesta_validar_el_mensaje_del_popup_comunicado() {
        popUpComunicado.ValidarComunicado();

    }
    @And("en la ventana propuesta hacer click en el boton nueva operacion")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_nueva_operacion() {
        propuesta.ClickBtnOperacion();
    }
    @And("en la ventana operacion credito hacer click en boton aceptar")
    public void en_la_ventana_operacion_credito_hacer_click_en_boton_aceptar() {
        seleccionarOperacionCredito.AbrirVentanaSeleccionarOP();
        try {
            seleccionarOperacionCredito.ValidarVentanaOP();
        } catch (Exception Error) {
            System.out.println("Error al hacer click en el boton aceptar"+Error.getMessage());

        }
        seleccionarOperacionCredito.CerrarVentanaSeleccionarOP();
    }

    @And("en la ventana operacion credito ingresar datos de la operacion y hacer click en boton calcular")
    public void en_la_ventana_operacion_credito_ingresar_datos_de_la_operacion_y_hacer_click_en_boton_calcular(DataTable OperacionCredito) {
        operacionCredito.AbrirVentanaOperacionCredito();
        List<Map<String, String>> lista = OperacionCredito.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacionCredito.SeleccionarMoneda(lista.get(i).get("Moneda"));
            operacionCredito.IngresarMonto(lista.get(i).get("Monto"));
            operacionCredito.IngresarTasaInicial(lista.get(i).get("TasaInicial"));
        }
        operacionCredito.ClickBtnCalcular();
    }
    @And("en la ventana operacion credito seleccionar plan de pagos {string}")
    public void en_la_ventana_operacion_credito_seleccionar_plan_de_pagos(String PlanPagos) {
        operacionCredito.SeleccionarPlanPagos(PlanPagos);
    }
    @And("en la ventana operacion credito seleccionar modalidad {string}")
    public void en_la_ventana_operacion_credito_seleccionar_modalidad(String Modalidad) {
        operacionCredito.SeleccionarModalidad(Modalidad);
    }
    @And("en la ventana operacion credito ingresar dias {string}")
    public void en_la_ventana_operacion_credito_ingresar_dias(String Dias) {
        operacionCredito.IngresarDias(Dias);

    }
    @And("en la ventana operacion credito ingresar porcentaje de Tasa Preferencial {string}")
    public void en_la_ventana_operacion_credito_ingresar_porcentaje_de_tasa_preferencial(String TasaPreferencial) {
        operacionCredito.IngresarTasaPreferencial(TasaPreferencial);
    }
    @And("en la ventana operacion credito seleccionar forma de desembolso {string}")
    public void en_la_ventana_operacion_credito_seleccionar_forma_de_desembolso(String FormaDesembolso) {
        operacionCredito.SeleccionarFormaDesembolso(FormaDesembolso);

    }
    @And("en la ventana operacion credito seleccionar plaza de desembolso")
    public void en_la_ventana_operacion_credito_seleccionar_plaza_de_desembolso(DataTable PlazaDesembolso) {

        List<Map<String, String>> lista = PlazaDesembolso.asMaps(String.class, String.class);
        for (int i = 0; i < lista.size(); i++) {
            operacionCredito.SeleccionarDepartamento(lista.get(i).get("Departamento"));
            operacionCredito.SeleccionarProvincia(lista.get(i).get("Provincia"));
            operacionCredito.SeleccionarDistrito(lista.get(i).get("Distrito"));
        }
    }
    @And("en la ventana operacion credito ingresar fecha probable del desembolso")
    public void en_la_ventana_operacion_credito_ingresar_fecha_probable_del_desembolso() {
        operacionCredito.ObtenerFechaDesembolso();
    }
    @And("en la ventana operacion credito Ingresar notas {string}")
    public void en_la_ventana_operacion_credito_ingresar_notas(String Notas) {
        operacionCredito.IngresarNotas(Notas);

    }
    @And("en la ventana operacion credito hacer click en el boton grabar")
    public void en_la_ventana_operacion_credito_hacer_click_en_el_boton_grabar() {
        operacionCredito.ClickBtnGrabar();
    }
    @And("en la ventana operacion credito hacer click en la alerta")
    public void en_la_ventana_operacion_credito_hacer_click_en_la_alerta() {
        operacionCredito.ObtenerAlerta();
        operacionCredito.CerrarVentanaOperacionCredito();
    }
    @And("en la ventana propuesta hacer click al boton registro de seguros")
    public void en_la_ventana_propuesta_hacer_click_al_boton_registro_de_seguros() {
        propuesta.ClickBtnRegistrarSeguro();
    }
    @And("en la ventana seleccion de seguros hacer click en boton confirmar")
    public void en_la_ventana_seleccion_de_seguros_hacer_click_en_boton_confirmar() {
        seleccionarSeguros.AbrirVentanaSeleccionarSeguros();
        seleccionarSeguros.ClickbtnConfirmar();
        seleccionarSeguros.CerrarVentanaSeleccionarSeguros();
    }
    @And("en la ventana registro seguros hacer check en seguro desgravamen flat MN")
    public void en_la_ventana_registro_seguros_hacer_check_en_seguro_desgravamen_flat_mn() {
        registrarSeguros.AbrirVentanaRegistrarSeguros();
        registrarSeguros.ClickCheckSeguroDesgravamenMN();

    }
    @And("en la ventana registro seguros ingresar el numero DPS seguro desgravamen")
    public void en_la_ventana_registro_seguros_ingresar_el_numero_dps_seguro_desgravamen() {
        registrarSeguros.ObtenerNumeroAleatorioDPSSeguroDesgravamen();
    }
    @And("en la ventana registro seguros hacer check en seguro todo riesgo Plan Pymes")
    public void en_la_ventana_registro_seguros_hacer_check_en_seguro_todo_riesgo_plan_pymes() {
        registrarSeguros.ClickCheckSeguroRiesgoPlanPymes();
    }
    @And("en la ventana registro seguros ingresar el numero DPS Seguro Plan Pymes")
    public void en_la_ventana_registro_seguros_ingresar_el_numero_dps_seguro_plan_pymes() {
        registrarSeguros.ObtenerNumeroAleatorioDPSeguroRiesgoPlanPymes();
    }
    @And("en la ventana registro seguros hacer click en el boton confirmar")
    public void en_la_ventana_registro_seguros_hacer_click_en_el_boton_confirmar() {
        registrarSeguros.ClickBtnConfirmar();
        registrarSeguros.CerrarVentanaRegistrarSeguros();
    }
    @And("en la ventana seguros seleccionados validar la informacion y hacer click en el boton cerrar")
    public void en_la_ventana_seguros_seleccionados_validar_la_informacion_y_hacer_click_en_el_boton_cerrar() {
        confirmarSeguros.AbrirVentanaConfirmacionSeguros();
        confirmarSeguros.ClickCerrar();
        confirmarSeguros.CerrarVentanaConfirmacionSeguros();
    }
    @And("en la ventana propuesta hacer click en el boton anexar CheckList creditos")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_anexar_check_list_creditos() {
        propuesta.ClickAnexarCheckListCreditos();
    }
    @And("en la ventana checkList credito seleccionar todas las opciones de los expedientes")
    public void en_la_ventana_check_list_credito_seleccionar_todas_las_opciones_de_los_expedientes() {
        anexarCheckListCreditos.AbrirVentanaAnexarCheckList();
        anexarCheckListCreditos.SeleccionarOpcionesCheckListCredito();
        anexarCheckListCreditos.Seleccionar_37opinionLegal();
    }
    @And("en la ventana checkList hacer click en el boton guardar y terminar finalmente aceptar la alerta")
    public void en_la_ventana_check_list_hacer_click_en_el_boton_guardar_y_terminar_finalmente_aceptar_la_alerta() {
        anexarCheckListCreditos.ClickBtnGuardarTerminar();
        anexarCheckListCreditos.AceptarAlerta();
        anexarCheckListCreditos.CerrarVentanaAnexarCheckList();
    }
    @And("en la ventana confirmar checklist de Credito hacer click en el boton cerrar")
    public void en_la_ventana_confirmar_checklist_de_credito_hacer_click_en_el_boton_cerrar() {
        confirmarCheckList.AbrirVentanaConfirmacionCheckList();
        confirmarCheckList.ClickCerrar();
        confirmarCheckList.CerrarVentanaConfirmacionCheckList();
    }
    @And("en la ventana propuesta ingresar todos los comentarios de la propuesta")
    public void en_la_ventana_propuesta_ingresar_todos_los_comentarios_de_la_propuesta() {
        propuesta.IngresarComentariosPropuesta();
    }
    @And("en la ventana propuesta hacer click en el boton anexar garantias existentes")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_anexar_garantias_existentes() {
        propuesta.ClickAnexarGarantias();
    }
    @And("en la ventana seleccionar garantias hacer click en el boton registrar garantias")
    public void en_la_ventana_seleccionar_garantias_hacer_click_en_el_boton_registrar_garantias() {
        seleccionarGarantia.AbrirVentanaGarantia();
        seleccionarGarantia.ClickRegistrarGarantia();
        seleccionarGarantia.CerrarVentanaGarantia();
    }
    @And("en la ventana garantias existentes seleccionar todas las garantias existentes")
    public void en_la_ventana_garantias_existentes_seleccionar_todas_las_garantias_existentes() {
        seleccionarGarantiasExistentes.AbrirVentanaGarantiasExistentes();
        seleccionarGarantiasExistentes.SeleccionarCheckGarantiasExistentesMaquinayEquipo();
    }
    @And("en la ventana garantias existentes hacer click en el boton aceptar")
    public void en_la_ventana_garantias_existentes_hacer_click_en_el_boton_aceptar() {
        seleccionarGarantiasExistentes.ClickBtnAceptar();
        seleccionarGarantiasExistentes.CerrarVentanaGarantiasExistentes();
    }
    @And("en la ventana cancelacion de pagares se cierra automaticamente")
    public void en_la_ventana_cancelacion_de_pagares_se_cierra_automaticamente() {
        cancelandoPagares.AbrirVentanaCancelandoPagares();
        cancelandoPagares.CerrarVentanaCancelandoPagares();
    }
    @And("en la ventana propuesta hacer click en el boton enlazar estados financieros")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_enlazar_estados_financieros() {
        propuesta.ClickEnlazarEEFF();
    }
    @And("en la ventana estados financieros hacer click en el boton enlazar")
    public void en_la_ventana_estados_financieros_hacer_click_en_el_boton_enlazar() {
        enlazarEstadosFinancieros.AbrirVentanaEnlazarEstadosFinancieros();
        enlazarEstadosFinancieros.ClickbtnEnlazar();
        enlazarEstadosFinancieros.CerrarVentanaEnlazarEstadosFinancieros();
    }
    @And("en la ventana propuesta hacer click en el boton desenlazar el informe de visita precargado por defecto")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_desenlazar_el_informe_de_visita_precargado_por_defecto() {
        propuesta.ClickDesenlazarInformeVisita();
    }
    @And("en la ventana desenlazar informe de Visita y hacer click en el boton realizar")
    public void en_la_ventana_desenlazar_informe_de_visita_y_hacer_click_en_el_boton_realizar() {
        desenlazarInformeVisita.AbrirVentanaDesenlazarInformeVisita();
        desenlazarInformeVisita.ClickBtnRealizar();
        desenlazarInformeVisita.CerrarVentanaDesenlazarInformeVisita();
    }
    @And("en la ventana propuesta y hacer click en el boton enlazar informe comercial nuevo")
    public void en_la_ventana_propuesta_y_hacer_click_en_el_boton_enlazar_informe_comercial_nuevo() {
        propuesta.ClickEnlazarInformeVisita();
    }
    @And("en la ventana enlazar informe comercial hacer click en el boton realizar")
    public void en_la_ventana_enlazar_informe_comercial_hacer_click_en_el_boton_realizar() {
        enlazarInformeVisita.AbrirVentanaEnlazarInformeVisita();
        enlazarInformeVisita.ClickBtnRealizar();
        enlazarInformeVisita.CerrarVentanaEnlazarInformeVisita();
    }
    @And("en la ventana propuesta hacer click en el boton enlazar informe visita")
    public void en_la_ventana_propuesta_hacer_click_en_el_boton_enlazar_informe_visita() {
        propuesta.ClickEnlazarInformeComercialNuevo();
    }
    @And("en la ventana enlazar informe de visita hacer click en el boton realizar")
    public void en_la_ventana_enlazar_informe_de_visita_hacer_click_en_el_boton_realizar() {
        enlazarInformeComercialNuevo.AbrirVentanaEnlazarInformeComercialNuevo();
        enlazarInformeComercialNuevo.ClickBtnRealizar();
        enlazarInformeComercialNuevo.CerrarVentanaEnlazarInformeComercialNuevo();
    }
    @And("en la ventana propuesta ingresar comentarios de los principales ratios {string}")
    public void en_la_ventana_propuesta_ingresar_comentarios_de_los_principales_ratios(String ComentariosRatios) {
        propuesta.IngresarComentariosRatios(ComentariosRatios);
    }
    @And("en la ventana propuesta doy click en el boton enlazar informe de estados financieros grupo vinculado")
    public void en_la_ventana_propuesta_doy_click_en_el_boton_enlazar_informe_de_estados_financieros_grupo_vinculado() {
        propuesta.ClickBtnEnlazarEEFFGrupoVinculadO();
    }
    @And("en la ventana informe de estados financieros grupo vinculado ingresar comentarios y hacer click en el boton grabar")
    public void en_la_ventana_informe_de_estados_financieros_grupo_vinculado_ingresar_comentarios_y_hacer_click_en_el_boton_grabar() {
        informeEEFFConsolidadoGrupoVinculado.AbrirVentanaInformeEstadoFinancieroConsolidadoGrupo();
        informeEEFFConsolidadoGrupoVinculado.IngresarComentarios();
        informeEEFFConsolidadoGrupoVinculado.ClickBtnGrabar();
    }
    @And("en la ventana informe de estados financieros grupo vinculado hacer click en el boton finalizar y finalmente cerrar la ventana")
    public void en_la_ventana_informe_de_estados_financieros_grupo_vinculado_hacer_click_en_el_boton_finalizar_y_finalmente_cerrar_la_ventana() {
        informeEEFFConsolidadoGrupoVinculado.ClickBtnFinalizar();
        informeEEFFConsolidadoGrupoVinculado.ClickBtnCerrar();
        informeEEFFConsolidadoGrupoVinculado.CerrarVentanaInformeEstadoFinancieroConsolidadoGrupo();
    }
    @And("en la ventana propuesta hacer click en el menu grabar")
    public void en_la_ventana_propuesta_hacer_click_en_el_menu_grabar() {
        propuesta.ClickMenuGrabarPropuesta();
    }
    @And("en la ventana grabar informacion hacer click en el menu cerrar")
    public void en_la_ventana_grabar_informacion_hacer_click_en_el_menu_cerrar() {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        grabarPropuesta.ClickBtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();
    }
    @And("en la ventana propuesta hacer click en el menu emitir dictamen")
    public void en_la_ventana_propuesta_hacer_click_en_el_menu_emitir_dictamen() {
        propuesta.AbrirOpcionesDictamen();
    }
    @And("en la opcion del menu emitir dictamen seleccionar el boton aprobar")
    public void en_la_opcion_del_menu_emitir_dictamen_seleccionar_el_boton_aprobar() {
        propuesta.ClickBtnAprobarPropuesta();
    }
    @And("en la ventana emitir dictamen propuesta ingresar observaciones y password del usuario asesor")
    public void en_la_ventana_emitir_dictamen_propuesta_ingresar_observaciones_y_password_del_usuario_asesor(DataTable DatosAprobacion) {
        aprobarDictamenPropuesta.AbrirVentanaAprobarDictamenPropuesta();
        List<Map<String, String>> lista = DatosAprobacion.asMaps(String.class, String.class);
        for (Integer i = 0; i < lista.size(); i++) {
            aprobarDictamenPropuesta.IngresarObservaciones(lista.get(i).get("Observaciones"));
            aprobarDictamenPropuesta.IngresarContrasena(lista.get(i).get("Contrasena"));
        }
    }

    @And("en la ventana emitir dictamen propuesta hacer click en el boton procesar")
    public void en_la_ventana_emitir_dictamen_propuesta_hacer_click_en_el_boton_procesar() {
        aprobarDictamenPropuesta.ClickBtnProcesar();
        aprobarDictamenPropuesta.CerrarVentanaAprobarDictamenPropuesta();
    }
    @And("en la ventana grabar informacion hacer click en el boton cerrar")
    public void en_la_ventana_grabar_informacion_hacer_click_en_el_boton_cerrar() {
        grabarPropuesta.AbrirVentanaGrabarPropuesta();
        grabarPropuesta.ClickBtnCerrarInformacion();
        grabarPropuesta.CerrarVentanaGrabarPropuesta();
    }
    @And("en la ventana listado propuesta hacer click en boton regresar")
    public void en_la_ventana_listado_propuesta_hacer_click_en_boton_regresar() {
        listadoPropuesta.ClickBtnRegresar();
    }
    @And("en la ventana menu principal seleccionar la opcion cerrar sesion")
    public void en_la_ventana_menu_principal_seleccionar_la_opcion_cerrar_sesion() {
        menuPrincipal.ClickCerrarSesion();
    }
    @And("en la ventana login hacer click en boton cerrar sesion")
    public void en_la_ventana_login_hacer_click_en_boton_cerrar_sesion() {
        login.ClickBtnCerrarSesion();
    }
    @And("en la ventana final cerrar el navegador")
    public void en_la_ventana_final_cerrar_el_navegador() {
        Hooks.driver.close();
    }
}
