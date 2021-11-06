Feature: Crear una propuesta de Credito Empresarial de tipo NORMAL en el Sistema SGCRED
  Yo como usuario asesor de creditos de Caja Piura SAC
  Quiero registrar una propuesta de credito Empresarial de tipo Normal
  Para su aprobacion correspondiente

  @Prueba
  Scenario Outline:Crear una propuesta de Credito Empresarial de tipo propuesta Normal con el Perfil "Asesor de Negocio"
    Given la web SGCRED esta disponible
    When ingresar usuario y password
      | usuario | password |
      | ALPAMA  | prueba   |
    Then hacer click en el boton ingresar
    And mostrar home de SGCRED
    And en el menu principal hacer click en el link propuesta financiamiento
    And en la ventana Listado de Propuestas hacer click en el boton crear propuesta
    And en la ventana Cliente seleccionar el tab codigo para realizar la busqueda
    And en la ventana Cliente ingresar el codigo a buscar "<cliente>"
    And en la ventana Cliente hacer click en el boton buscar
    And en la ventana Cliente hacer click en el icono propuesta
    And en la ventana Servicio ingresar informacion luego hacer click en el boton cargar
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | NORMAL        | NORMAL           | SIN PROMOCION |
    And en la ventana Propuesta validar y cerrar el mensaje del popup Comunicado
    And en la ventana Propuesta hacer click en el boton nueva operacion
    And en la ventana Operacion Credito hacer click en boton aceptar
    And en la ventana Operacion Credito ingresar datos de la operacion luego hacer click en el boton calcular
      | Moneda | Monto | TasaInicial |
      | S/     | 3000  | 1           |
    And en la ventana Operacion Credito seleccionar plan de pagos "Fija Vencida"
    And en la ventana Operacion Credito seleccionar modalidad "Libre Amortizacion"
    And en la ventana Operacion Credito Ingresar los dias "90"
    And en la ventana Operacion Credito ingresar porcentaje de Tasa Preferencial "30.00"
    And en la ventana Operacion Credito seleccionar forma de desembolso "GIRO BANCO DE LA NACION"
    And en la ventana Operacion Credito seleccionar plaza de desembolso
      | Departamento | Provincia | Distrito |
      | LIMA         | LIMA      | LIMA     |
    And en la ventana Operacion Credito ingresar fecha probable del desembolso
    And en la ventana Operacion Credito Ingresar notas "Prueba"
    And en la ventana Operacion Credito hacer click en el boton grabar
    And en la ventana Operacion Credito hacer click en aceptar la alerta
    And en la ventana Propuesta hacer click en el boton registro de seguros
    And en la ventana Seleccion de seguros hacer click en el boton confirmar
    And en la ventana Registro Seguros hacer check en seguro desgravamen flat MN
    And en la ventana Registro Seguros ingresar el numero DPS del seguro desgravamen
    And en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes
    And en la ventana Registro Seguros ingresar el numero DPS del Seguro Plan Pymes
    And en la ventana Registro Seguros hacer click en el boton confirmar
    And en la ventana Seguros seleccionados visualizar informacion y hacer click en el boton cerrar
    And en la ventana Propuesta hacer click en el boton anexar checkList creditos
    And en la ventana CheckList Credito seleccionar todas las opciones de la columna Expedientes
    And en la ventana CheckList Credito hacer click en el boton guardar y terminar finalmente aceptar la alerta
    And en la ventana Confirmar Checklist Credito hacer click en el boton cerrar
    And en la ventana Propuesta ingresar todos los comentarios de la propuesta
    And en la ventana Propuesta hacer click en el boton anexar garantias existentes
    And en la ventana Seleccionar Garantias hacer click en el boton registrar garantias
    And en la ventana Garantias Existentes seleccionar todas las garantias existentes
    And en la ventana Garantias Existentes hacer click en el boton aceptar
    And en la ventana Cancelacion de pagares se cierra automaticamente
    And en la ventana Propuesta hacer click en el boton enlazar estados financieros
    And en la ventana Estados Financieros hacer click en el boton enlazar
    And en la ventana Propuesta hacer click en el boton desenlazar el informe de visita
    And en la ventana Desenlazar Informe de Visita hacer click en el boton realizar
    And en la ventana Propuesta hacer click en el boton enlazar informe comercial nuevo
    And en la ventana Enlazar Informe Comercial Nuevo hacer click en el boton realizar
    And en la ventana Propuesta hacer click en el boton enlazar informe visita
    And en la ventana Enlazar Informe de Visita hacer click en el boton realizar
    And en la ventana Propuesta ingresar comentarios de los principales ratios "Comentarios positivos"
    And en la ventana Propuesta hacer click en el menu grabar propuesta
    And en la ventana Grabar Informacion hacer click en el boton cerrar
    And en la ventana Propuesta hacer click en el menu emitir dictamen
    And en la opcion del Menu Emitir Dictamen seleccionar el boton aprobar
    And en la ventana Emitir Dictamen Propuesta ingresar observaciones e ingresar password del usuario asesor de negocio
      | Observaciones     | Contrasena |
      | Aprobar propuesta | prueba     |
    And en la ventana Emitir Dictamen Propuesta hacer click en el boton procesar
    And en la ventana Grabar Informacion hacer click en el boton cerrar ventana
    And en la ventana Listado propuesta hacer click en boton regresar
    And en la ventana Menu Principal hacer click en la opcion cerrar sesion
    And en la ventana Login hacer click en boton cerrar sesion
    And finalmente cerrar el navegador para iniciar nuevamente

    Examples:
      | cliente |
      | 238     |
      | 629     |
      | 967     |
      | 1145    |
      | 1443    |
      | 1487    |
      | 2028    |
      | 2240    |
      | 2266    |
      | 2363    |
      | 2379    |






























































