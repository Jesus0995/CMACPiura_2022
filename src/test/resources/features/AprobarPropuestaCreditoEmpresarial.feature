Feature: Registrar Aprobacion de Propuestas con el perfil Jefe de Credito
  Yo como usuario Jefe de Credito de Agencia
  Quiero aprobar una propuesta de credito Empresarial
  Para que el cliente pueda desembolsar el credito

  @Prueba
  Scenario: Aprobar una propuesta de Credito Empresarial del cliente en el sistema SGCRED
    Given el sistema SGCRED se encuentra disponible
    When ingreso usuario y password del Perfil Jefe de Credito Agencia
      | nombre | password |
      | osal   | prueba   |
    And en la ventana doy click en el boton Ingresar de la web SGCRED
    And el sistema muestra el menu principal de SGCRED
    And en el menu doy click en la opcion propuesta de financiamiento
    And en la ventana Listado de Propuestas seleccionar el tipo de busqueda por numero de propuesta
    And en la ventana Listado de Propuestas ingresar el numero de propuesta "4787593"
    And en la ventana Listado de Propuestas doy click en el boton Buscar
    And en la ventana Listado de Propuestas doy click en el boton Editar
    And el sistema muestra Comunicado y doy en cerrar
    And en la ventana Propuesta doy click en el menu Emitir Dictamen y seleccionar Aprobar
    And en la ventana ventana Emitir Dictamen ingresar Observaciones y Clave
      |Observaciones  |Contrasena|
      |Aprobar credito|prueba  |