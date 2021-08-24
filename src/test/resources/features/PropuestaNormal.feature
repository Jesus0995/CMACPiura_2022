Feature: Crear una propuesta de Credito Empresarial de tipo NORMAL en el Sistema SGCRED
  Yo como usuario asesor de creditos de Caja Piura SAC
  Quiero registrar una propuesta de credito Empresarial de tipo Normal
  Para su aprobacion correspondiente


  Scenario:  Crear una propuesta de Credito Empresarial de tipo Normal
    Given la web SGCRED esta disponible
    When ingreso usuario y password
      | nombre | password |
      | ALPAMA | prueba   |
    And doy click en boton ingresar
    And Mostrar home de SGCRED
    And doy click en link propuesta financiamiento
    And doy click en el boton crear_propuesta de la ventana Listado Propuesta
    And mostrar la ventana cliente para realizar la busqueda en el tab codigo
    And en la ventana cliente ingresar el codigo a buscar "97941041"
    And en la ventana cliente doy click en el boton buscar
    And en la ventana cliente hacer click en el icono propuesta
    And el sistema muestra la ventana de servicio e ingresamos la informacion
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | NORMAL        | NORMAL           | SIN PROMOCION |
    And validar el mensaje del popup Comunicado
    And en la ventana propuesta ingresar clasificacion crediticia "prueba"
    And en la ventana propuesta ingresar objetivo del credito "prueba"
    And en la ventana propuesta ingresar justificacion del credito "prueba"
    And en la ventana propuesta doy click en el boton nueva operacion
    And validar la ventana seleccionar operacion de credito luego doy click en boton aceptar
    And posicionarse en la ventana Operacion Credito e ingresar la Operacion y doy click en Calcular
      | Moneda | Monto | TasaInicial |
      | S/     | 5000  | 1           |
    And en la ventana Operacion Credito seleccionar plan de pagos "Fija Vencida"
    And en la ventana Operacion Credito seleccionar modalidad "Libre Amortizacion"
    And en la ventana Operacion Credito Ingresar los dias "90"
    And en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial "11.45"
    And en la ventana Operacion Credito seleccionar forma de desembolso "GIRO BANCO DE LA NACION"
    And en la ventana Operacion Credito seleccionar plaza de desembolso
      | Departamento | Provincia | Distrito |
      | LIMA         | LIMA      | LIMA     |
    And en la ventana Operacion Credito ingresar fecha probable del desembolso "23/08/2021"
    And en la ventana Operacion Credito Ingresar notas "Prueba"
    And en la ventana Operacion Credito doy click en grabar
    And en la ventana Operacion Credito aceptar la alerta
    Then el sistema direcciona a ventana Propuesta y doy click icono cambio de tasa
    And en la ventana Cambio Tasa de credito registro el comentario de solicitud "se aprueba el cambio de tasa de credito"
    And en la ventana Cambio Tasa de Credito doy click en boton Grabar
    Then el sistema direcciona a la propuesta y doy click al boton Registro de seguros
    And en la ventana Seleccion de seguros doy click en boton Confirmar
    And el sistema direcciona a la ventana Registro Seguros y check en seguro desgravamen flat MN
    And en la ventana Registro Seguros ingresar el numero DPS "12345"
    And en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes
    And en la ventana Registro Seguros ingresar el numero DPS "6789" del seguro Plan Pymes
    And en la ventana Registro Seguros doy click en Confirmar
    And el sistema muestra la ventana seguros seleccionados y doy click en cerrar
    Then el sistema direcciona a la propuesta y doy click en Anexar CheckList Creditos
    And en la ventana CheckList Creditos seleccionar en Informacion Basica_Tarjeta de Informacion






























