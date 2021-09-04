Feature: Crear una propuesta de Credito Empresarial de tipo NORMAL en el Sistema SGCRED
  Yo como usuario asesor de creditos de Caja Piura SAC
  Quiero registrar una propuesta de credito Empresarial de tipo Normal
  Para su aprobacion correspondiente

  @Prueba
  Scenario:  Crear una propuesta de Credito Empresarial de tipo propuesta Normal con el Perfil "Asesor de Finanzas Empresariales"
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
    And en la ventana propuesta ingresar comentarios en clasificacion, objetivo y justificacion
      | clasificacion | objetivo | justificacion |
      | prueba        | prueba   | prueba        |
    And en la ventana propuesta doy click en el boton nueva operacion
    And validar la ventana seleccionar operacion de credito luego doy click en boton aceptar
    And posicionarse en la ventana Operacion Credito e ingresar la Operacion y doy click en Calcular
      | Moneda | Monto | TasaInicial |
      | S/     | 5000  | 10           |
    And en la ventana Operacion Credito seleccionar plan de pagos "Fija Vencida"
    And en la ventana Operacion Credito seleccionar modalidad "Libre Amortizacion"
    And en la ventana Operacion Credito Ingresar los dias "90"
    And en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial "11.45"
    And en la ventana Operacion Credito seleccionar forma de desembolso "GIRO BANCO DE LA NACION"
    And en la ventana Operacion Credito seleccionar plaza de desembolso
      | Departamento | Provincia | Distrito |
      | LIMA         | LIMA      | LIMA     |
    And en la ventana Operacion Credito ingresar fecha probable del desembolso "03/09/2021"
    And en la ventana Operacion Credito Ingresar notas "Prueba"
    And en la ventana Operacion Credito doy click en grabar
    And en la ventana Operacion Credito aceptar la alerta
    Then el sistema direcciona a ventana Propuesta y doy click icono cambio de tasa
    And en la ventana Cambio Tasa de credito registro el comentario de solicitud "se aprueba el cambio de tasa de credito"
    And en la ventana Cambio Tasa de Credito doy click en boton Grabar
    Then el sistema direcciona a la ventana propuesta y doy click al boton Registro de seguros
    And en la ventana Seleccion de seguros doy click en boton Confirmar
    And el sistema direcciona a la ventana Registro Seguros y check en seguro desgravamen flat MN
    And en la ventana Registro Seguros ingresar el numero DPS "12345"
    And en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes
    And en la ventana Registro Seguros ingresar el numero DPS "6789" del seguro Plan Pymes
    And en la ventana Registro Seguros doy click en Confirmar
    And en la ventana seguros seleccionados visualizar información y doy click en cerrar
    Then el sistema direcciona a la ventana propuesta y doy click en Anexar CheckList creditos
    And en la ventana CheckList Seccion Informacion Basica Cliente seleccionar las opciones del uno al siete
    And en la ventana CheckList Seccion Información del Negocio seleccionar las opciones ocho al once
    And en la ventana CheckList Seccion Operaciones Propuestas seleccionar la opcion doce
    And en la ventana CheckList Seccion Seguro del Cliente seleccionar la opcion trece
    And en la ventana CheckList Seccion Seguro de Garantia seleccionar la opcion catorce
    And en la ventana CheckList Seccion Informacion Economica Financiera seleccionar las opciones quince y dieciseis
    And en la ventana CheckList Seccion Informe Verificacion Previa seleccionar la opcion diecisiete
    And en la ventana CheckList Seccion Garantias No Inscribibles seleccionar las opciones dieciocho al veintidos
    And en la ventana CheckList Seccion Garantias Con Deposicion seleccionar las opciones veintitres y veiniticuatro
    And en la ventana CheckList Seccion Garantias Inscribibles seleccionar las opciones veinticinco al treintaiuno
    And en la ventana CheckList Seccion Desembolso de credito con Inscripcion seleccionar las opciones treintaidos y treintaitres
    And en la ventana CheckList doy clic en Guardar y Terminar finalmente acepto la alerta
    And el sistema direcciona a la ventana Confirmar Checklist de Credito y doy click en cerrar
    Then el sistema direcciona a la ventana propuesta y se procede a ingresar los siguientes comentarios
      | CaracteristicaNegocio | ClasificacionRiesgoNegocio | ClasificacionRiesgoAval | AnalisisUnidadFinanciera |
      | prueba                | prueba                     | prueba                  | prueba                   |
    And en la ventana Propuesta doy click en Anexar Garantias Existentes
    And en la ventana Seleccionar Garantias doy click en Registrar Garantias
    And en la ventana Garantias Existentes seleccionar garantia correspondiente y doy click en Aceptar
    And el sistema muestra una ventana de cancelacion de pagares y se cierra automaticamente
    And en la ventana Propuesta doy click en Enlazar Estados Financieros
    Then el sistema direcciona a la ventana Estados Financieros y doy click en Enlazar
    And en la ventana Propuesta doy click en Desenlazar el Informe de Visita precargado por defecto
    Then el sistema muestra la ventana Desenlazar Informe de Visita y doy click en el boton Realizar
    And el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar el nuevo Informe Visita
    Then el sistema muestra la ventana Enlazar Informe de Visita y le doy click en el boton Realizar
    And el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar Informe Comercial Nuevo
    Then el sistema muestra la ventana Enlazar Informe Comercial y le doy click en el boton Realizar
    And el sistema direcciona a la ventana Propuesta y doy click en la opcion grabar
    And en la ventana Grabar documento doy click en el boton Cerrar
    And el sistema muestra la ventana Propuesta y debe ingresar comentarios de los principales ratios "Comentarios positivos"
    And en la ventana Propuesta seleccionar la opcion Aprobar para Emitir Dictamen de Propuesta
























































