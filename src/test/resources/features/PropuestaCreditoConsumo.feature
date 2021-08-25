Feature: Crear una propuesta de Creditos de Consumo de tipo Normal en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una propuesta de Creditos de Consumo de tipo Normal
  Para su aprobacion

  @Prueba
  Scenario:  Crear una propuesta de Creditos de Consumo de tipo Normal
    Given la pagina web SGCRED esta disponible
    When se ingresa usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en boton ingresar
    And muestra el home de SGCRED
    And doy click en link propuesta financiamiento
    And doy click en el boton crear_propuesta de la ventana Listado Propuesta
    And mostrar la ventana cliente para realizar la busqueda en el tab codigo
    And en la ventana cliente ingresar el codigo a buscar "240316510"
    And en la ventana cliente doy click en el boton buscar
    And en la ventana cliente hacer click en el icono propuesta
    And el sistema muestra la ventana de servicio e ingresamos la informacion
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     | Negocio                               | TipoOperacion |
      | CREDITOS DE CONSUMO | CREDIPERSONAS   | NORMAL        | NORMAL           | SIN PROMOCION | PRESTACION DE SERVICIOS PROFESIONALES | SIMPLE        |
    And en la ventana servicio doy click en el boton cargar
    And validar el mensaje del popup Comunicado
    And en la ventana propuesta de financiamiento ingresar la clasificacion crediticia
    And en la ventana propuesta de financiamiento ingresar el objetivo de credito
    And en la ventana propuesta de financiamiento ingresar la justificacion de credito
