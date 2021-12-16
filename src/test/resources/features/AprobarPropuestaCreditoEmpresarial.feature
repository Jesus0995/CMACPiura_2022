Feature: Registrar Aprobacion de Propuestas con el perfil Jefe de Credito
  Yo como usuario Jefe de Credito de Agencia
  Quiero aprobar una propuesta de credito Empresarial
  Para que el cliente pueda desembolsar el credito


  Scenario Outline: Aprobar una propuesta de Credito Empresarial del cliente en el sistema SGCRED
    Given el sistema SGCRED se encuentra disponible
    When ingreso usuario y password del Perfil Jefe de Credito Agencia
      | usuario | password |
      | LARI    | prueba   |
    And en la ventana doy click en el boton Ingresar de la web SGCRED
    Then el sistema muestra el menu principal de SGCRED
    And en el menu doy click en la opcion propuesta de financiamiento
    And en la ventana Listado de Propuestas seleccionar el tipo de busqueda por numero de propuesta
    And en la ventana Listado de Propuestas ingresar el numero de propuesta "<propuesta>"
    And en la ventana Listado de Propuestas doy click en el boton Buscar
    And en la ventana Listado de Propuestas doy click en el boton Editar
    And el sistema muestra Comunicado y doy en cerrar
    And en la ventana principal de Propuesta doy click en el boton verificar checklist credito
    And en la ventana Anexar CheckList Credito seleccionar Aprobar e ingresar un comentario
    And en la ventana Anexar CheckList Credito doy click en el boton Guardar
    And en la ventana Anexar CheckList Credito doy click en el boton Cerrar
    And en la ventana principal de Propuesta doy click en el Menu Emitir Dictamen
    And en las opciones del Menu Emitir Dictamen seleccionar el boton Aprobar
    And en la ventana ventana Emitir Dictamen ingresar Observaciones y Clave
      | Observaciones     | Contrasena |
      | Aprobar propuesta | prueba     |
    And en la misma ventana doy click en el boton Procesar
    Then el sistema muestra la ventana Grabar Informacion y doy click en el boton Cerrar
    And el sistema direcciona al listado de propuestas y doy click en el boton Regresar
    And el sistema direcciona al menu principal y le doy click en Cerrar Sesion
    And el sistema direcciona al login y le doy click en el boton Cerrar Sesion
    And cerrar el navegador
    Examples:
      | propuesta |
      | 4899845   |