Feature: Registrar informe de visita con el perfil Administrador
  Yo como usuario Administrador
  Quiero aprobar una propuesta de credito
  Para que el cliente pueda desembolsar

  @Prueba
  Scenario: Aprobar una propuesta de credito del cliente en el sistema SGCRED
    Given la web SGCRED se encuentra disponible
    When ingreso usuario y password del perfil Administrador
      | nombre | password |
      | NISI   | prueba   |
    And doy click en el boton ingresar de la web SGCRED
    And muestra el menu principal de SGCRED
    And doy click en la opcion propuesta de financiamiento
    And muestra el listado de propuestas y seleciono el tipo de busqueda por numero de propuesta
    And en la ventana listado de propuestas ingresar el numero de propuesta "4787691"
    And en la ventana listado de propuestas doy click en el boton buscar
    And en la ventana listado de propuestas doy click en el boton editar propuesta
    And doy cerrar el comunicado
    And muestra la propuesta de financiamiento y doy click en el menu emitir dictamen
    And de la tabla de emitir dictamen selecciono la opcion aprobar
    And muestra la ventana emitir dictamen ingresar observaciones y clave
      |Observaciones  |Contrasena|
      |Aprobar credito|prueba  |
    And en la ventana emitir dictamen doy click en el boton procesar
    And muestra la ventana de grabar informacion y doy click en cerrar
    And direcciona a la ventana listado de propuestas y doy click en el boton regresar
    And direcciona a menu principal y doy click en la opcion cerrar sesion
    And direcciona a login y doy click en el boton cerrar sesion
