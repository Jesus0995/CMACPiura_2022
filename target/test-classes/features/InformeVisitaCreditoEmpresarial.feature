Feature: Registrar informe de visita con el perfil Asesor de Negocio
  Yo como usuario Asesor de Finanzas Empresariales
  Quiero registrar informe de visitas
  Para enlazar a la creacion de Propuestas

  @Prueba
  Scenario Outline: Registrar informe de visitas de los clientes en el sistema SGCRED
    Given la web SGCRED esta disponible para usarla
    When ingreso usuario y password del perfil Asesor de Negocio
      | nombre | password |
      | ALPAMA | prueba   |
    And doy click en boton ingresar al SGCRED
    And Mostrar home principal de SGCRED
    And doy click en el menu informe visita
    And en la ventana busqueda de clientes seleccionar el tab por Codigo e ingresar el codigo "<cliente>"
    And en la ventana busqueda de cliente doy click en el boton Buscar
    And en la grilla de la ventana seleccionar el icono informe visita
    Then el sistema direcciona a la ventana SeleccionarRubroNegocio y doy click en boton Cargar
    And en la ventana lista de informes visita doy click en el boton crear informe visita
    And el sistema muestra la ventana principal informe de visita e ingresar datos de visita
      | HoraVisita | MinutoVisita | FranjaHora |
      | 09         | 00           | A.M        |
    And en la ventana principal informe de visita ingresar datos de verificacion domiciliaria
      | NumeroIntegrantes | Relacion | Habitos             | OtrosIngresos |
      | 3                 | Estable  | Dentro de lo Normal | NO            |
    And en la ventana principal informe de visita ingresar datos de verificacion del negocio
      | DireccionNegocio | EstadoGarantia | DocumentoGarantia                |
      | SI               | Operativo      | Presentada en Regla (Originales) |
    And en la ventana principal informe de visita la evaluacion del perito es:
    And en la ventana principal informe de visita seleccionar declaracion Prevencion de Lavado de Activo
    And en la ventana principal informe de visita seleccionar Senales de Alerta
    And en la ventana principal informe de visita seleccionar Actividad economica del cliente tiene fundamento legal
    And en la ventana principal informe de visita registrar observaciones "Prueba"
    And en la ventana principal informe de visita doy click en el boton grabar
    And en la ventana Grabar Documento doy click en el boton Cerrar
    And en la ventana principal informe de visita doy click en el boton regresar
    And el sistema direcciona a ventana listado informe de visita y doy click en el boton regresar
    And el sistema direcciona a menu principal y doy click al menu cerrar sesion
    And direcciona a la ventana login y doy click en el boton cerrar sesion
    And finalmente cerramos el navegador

    Examples:
      | cliente  |
      | 7993234  |
      | 22296442 |







