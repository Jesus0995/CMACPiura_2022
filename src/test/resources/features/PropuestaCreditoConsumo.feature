Feature: Crear una propuesta de Creditos de Consumo de tipo Normal en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una propuesta de Creditos de Consumo de tipo Normal
  Para su aprobacion

  @Prueba
  Scenario:  Crear una propuesta de Creditos de Consumo de tipo Normal
    Given la pagina web SGCRED esta disponible
    When se completa el usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en el boton ingresar
    And muestra el home de SGCRED
    And doy click en el link propuesta financiamiento
    And doy click en el boton Crear_Propuesta de la ventana Listado Propuesta
    And muestra la ventana cliente para realizar la busqueda en el tab codigo
    And en la ventana cliente digitar el codigo a buscar "240316510"
    And en la ventana cliente se da click en el boton buscar
    And en la ventana cliente se da click en el icono propuesta
    And el sistema muestra la ventana de requisitos de propuesta e ingresamos la informacion
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     | Negocio                               | TipoOperacion |
      | CREDITOS DE CONSUMO | CREDIPERSONAS   | NORMAL        | NORMAL           | SIN PROMOCION | PRESTACION DE SERVICIOS PROFESIONALES | SIMPLE        |
    And en la ventana requisitos de propuesta se da click en el boton cargar
    And validar el popup Comunicado
    And en la ventana propuesta de financiamiento ingresar la clasificacion crediticia "prueba"
    And en la ventana propuesta de financiamiento ingresar el objetivo de credito "prueba"
    And en la ventana propuesta de financiamiento ingresar la justificacion de credito "prueba"
    And en la ventana propuesta de financiamiento doy clik al botón nueva operacion
    And el sistema muestra la ventana seleccionar operacion credito
    And en la ventana seleccionar operacion credito doy click en el boton aceptar
    And el sistema muestra la ventana operacion credito
    And en la ventana operacion credito ingresar el monto, la tasa inicial luego click en el boton calcular
      |Monto|TasaInicial|
      |7000 |1          |
    And en la ventana operacion credito seleccionar el plan de pagos "Fija Vencida"
    And en la ventana operacion credito seleccionar la modalidad de amortizacion "Cronograma Pagos"
    And en la ventana operacion credito seleccionar la opcion de pago "Fecha Fija"
    And en la ventana operacion credito ingresar el dia de pago "20"
    And en la ventana operacion credito seleccionar el numero de cuotas "18"
    And en la ventana operacion credito ingresar la tasa preferencial "30"
    And en la ventana operacion credito seleccionar la forma desembolso "ABONO EN CUENTA"
    And en la ventana operacion credito seleccionar el codigo de cuenta "210-01-6139179"
    And en la ventana operacion credito seleccionar la fecha desembolso "01/09/2021"
    And en la ventana operacion credito ingresar una nota "prueba de nueva propuesta"
    And en la ventana operacion credito doy click en el boton grabar
    And en la ventana operacion credito aceptar la alerta
