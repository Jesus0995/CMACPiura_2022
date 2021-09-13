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
    And en la ventana cliente digitar el codigo a buscar "25356918"
    And en la ventana cliente se da click en el boton buscar
    And en la ventana cliente se da click en el icono propuesta
    And el sistema muestra la ventana de requisitos de propuesta e ingresamos la informacion
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     | Negocio                                  | TipoOperacion |
      | CREDITOS DE CONSUMO | CREDIPERSONAS   | NORMAL        | NORMAL           | SIN PROMOCION | ADMINISTRACION DE SERVICIOS DE PLANIFICA | SIMPLE        |
    And en la ventana requisitos de propuesta se da click en el boton cargar
    And validar el popup Comunicado
    And en la ventana propuesta de financiamiento ingresar la clasificacion crediticia "prueba"
    And en la ventana propuesta de financiamiento ingresar el objetivo de credito "prueba"
    And en la ventana propuesta de financiamiento ingresar la justificacion de credito "prueba"
    And en la ventana propuesta de financiamiento doy clik al boton nueva operacion
    And muestra la ventana seleccionar operacion credito doy click en el boton aceptar
    And muestra la ventana operacion credito ingresar el monto, la tasa inicial luego click en el boton calcular
      |Monto|TasaInicial|
      |3000 |1          |
    And en la ventana operacion credito seleccionar el plan de pagos "Fija Vencida"
    And en la ventana operacion credito seleccionar la modalidad de amortizacion "Cronograma Pagos"
    And en la ventana operacion credito seleccionar la opcion de pago "Fecha Fija"
    And en la ventana operacion credito ingresar el dia de pago "20"
    And en la ventana operacion credito seleccionar el numero de cuotas "18"
    And en la ventana operacion credito ingresar la tasa preferencial "30"
    And en la ventana operacion credito seleccionar la forma desembolso "ABONO EN CUENTA"
    And en la ventana operacion credito seleccionar el codigo de cuenta "210-01-1624829"
    And en la ventana operacion credito seleccionar la fecha desembolso "13/09/2021"
    And en la ventana operacion credito ingresar una nota "prueba de nueva propuesta"
    And en la ventana operacion credito doy click en el boton grabar
    And en la ventana operacion credito aceptar la alerta
    And el sistema direcciona a la ventana propuesta y doy clik en el boton registro de seguro
    And muestra la ventana seleccionar seguros y doy click en el boton confirmar
    And muestra la ventana registrar seguros y doy check en el seguro desgravamen al saldo capital
    And en la ventana registrar seguros ingresar el numero DPS "1223" del seguro desgravamen
    And en la ventana registrar seguros doy check en el seguro vida plan1
    And en la ventana registrar seguros ingresar el numero DPS "2231" del seguro vida plan1
    And en la ventana registrar seguros doy click en el boton confirmar
    And muestra la ventana seguros seleccionados y doy click en el boton cerrar
    And el sistema direcciona a la ventana propuesta y doy click en el boton anexar garantias
    And muestra la ventana seleccionar garantia y doy click en el boton registrar garantia
    And muestra la ventana garantias existentes y doy check a garantia personal
    And en la ventana garantias existentes doy click al boton aceptar
    And el sistema direcciona a la venta propuesta y doy clik en el boton enlazar de la hoja de trabajo
    And muestra la ventana evaluacion economica y doy click en el boton realizar
    And el sistema direcciona a la ventana propuesta y doy click en boton desenlazar informe visita
    And muestra la ventana desenlazar informe visita y doy click en el boton realizar
    And el sistema direcciona a la ventana propuesta y doy clik en el boton enlazar informe visita
    And muestra la ventana enlazar informe visita y doy click en el boton realizar
    And el sistema direcciona a la ventana propuesta y doy clik en el boton enlazar informe comercial
    And muestra la ventana enlazar informe comercial y doy click en el boton realizar
    And el sistema direcciona a la ventana propuesta y doy clik en el boton grabar
    And muestra ventana grabar informacion y doy click en el boton cerrar
    And en la ventana propuesta seleccionar la opcion aprobar
    And muestra la ventana emitir dictamen propuesta ingresar observaciones y contraseña del usuario
      |Observaciones|Contrasena|
      |Aprobar      |prueba    |
    And en la ventana emitir dictamen propuesta doy click en el boton procesar
    And en la ventana propuesta de financiamiento aceptar la alerta