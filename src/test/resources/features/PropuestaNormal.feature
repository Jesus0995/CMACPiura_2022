Feature: Crear una propuesta de Credito Empresarial de tipo NORMAL en el Sistema SGCRED
  Yo como usuario asesor de creditos de Caja Piura SAC
  Quiero registrar una propuesta de credito Empresarial de tipo Normal
  Para su aprobacion correspondiente

  @Prueba
  Scenario Outline:Crear una propuesta de Credito Empresarial de tipo propuesta Normal con el Perfil "Asesor de Negocio"
    Given la web SGCRED esta disponible
    When ingreso usuario y password
      | nombre | password |
      | ALPAMA | prueba   |
    And doy click en boton ingresar
    And Mostrar home de SGCRED
    And doy click en link propuesta financiamiento
    And doy click en el boton crear_propuesta de la ventana Listado Propuesta
    And mostrar la ventana cliente para realizar la busqueda en el tab codigo
    And en la ventana cliente ingresar el codigo a buscar "<cliente>"
    And en la ventana cliente doy click en el boton buscar
    And en la ventana cliente hacer click en el icono propuesta
    And el sistema muestra la ventana de servicio e ingresamos la informacion y doy click en el boton cargar
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | NORMAL        | NORMAL           | SIN PROMOCION |
    And validar el mensaje del popup Comunicado
    And en la ventana propuesta doy click en el boton nueva operacion
    And validar la ventana seleccionar operacion de credito luego doy click en boton aceptar
    And posicionarse en la ventana Operacion Credito e ingresar la Operacion y doy click en Calcular
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
    And en la ventana Operacion Credito doy click en grabar
    And en la ventana Operacion Credito aceptar la alerta
    Then el sistema direcciona a la ventana propuesta y doy click al boton Registro de seguros
    And en la ventana Seleccion de seguros doy click en boton Confirmar
    And el sistema direcciona a la ventana Registro Seguros y check en seguro desgravamen flat MN
    And en la ventana Registro Seguros ingresar el numero DPS Seguro Desgravamen
    And en la ventana Registro Seguros hacer check en seguro todo riesgo Plan Pymes
    And en la ventana Registro Seguros ingresar el numero DPS Seguro Plan Pymes
    And en la ventana Registro Seguros doy click en Confirmar
    And en la ventana seguros seleccionados visualizar información y doy click en cerrar
    Then el sistema direcciona a la ventana propuesta y doy click en Anexar CheckList creditos
    And en la ventana CheckList Credito seleccionar todas las opciones de Expedientes
    And en la ventana CheckList doy clic en Guardar y Terminar finalmente acepto la alerta
    And el sistema direcciona a la ventana Confirmar Checklist de Credito y doy click en cerrar
    Then el sistema direcciona a la ventana propuesta y se procede a ingresar comentarios en la propuesta
    And en la ventana Propuesta doy click en Anexar Garantias Existentes
    And en la ventana Seleccionar Garantias doy click en Registrar Garantias
    And en la ventana Garantias Existentes seleccionar todas las garantias existentes
    And en la ventana Garantias Existentes doy click en el boton Aceptar
    And el sistema muestra una ventana de cancelacion de pagares y se cierra automaticamente
    And en la ventana Propuesta doy click en Enlazar Estados Financieros
    Then el sistema direcciona a la ventana Estados Financieros y doy click en Enlazar
    And en la ventana Propuesta doy click en Desenlazar el Informe de Visita precargado por defecto
    Then el sistema muestra la ventana Desenlazar Informe de Visita y doy click en el boton Realizar
    And el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar Informe Comercial Nuevo
    Then el sistema muestra la ventana Enlazar Informe Comercial y le doy click en el boton Realizar
    And el sistema realiza la accion y direcciona a la ventana Propuesta y doy click en Enlazar el nuevo Informe Visita
    Then el sistema muestra la ventana Enlazar Informe de Visita y le doy click en el boton Realizar
    And el sistema muestra la ventana Propuesta y debe ingresar comentarios de los principales ratios "Comentarios positivos"
    And en la ventana Propuesta doy click en el boton Enlazar Informe de Estados Financieros Grupo Vinculado
    And en la ventana Informe de Estados Financieros Grupo Vinculado ingresar comentarios y doy click en el boton Grabar
    And en la ventana Informe Estados Financieros Grupo Vinculado doy click en el boton Finalizar y finalmente Cerrar la ventana
    And el sistema direcciona a la ventana Propuesta y doy click en la opcion grabar
    And en la ventana Grabar Informacion doy click en el boton Cerrar
    Then en la ventana Propuesta doy click en el Menu Emitir Dictamen
    And en las opciones del menu Emitir Dictamen seleccionar el boton Aprobar
    And en la ventana Emitir Dictamen Propuesta ingresar observaciones y password del usuario asesor
      | Observaciones     | Contrasena |
      | Aprobar propuesta | prueba     |
    And en la ventana Emitir Dictamen Propuesta doy click en el boton Procesar
    And el sistema muestra la ventana Grabar Informacion y le doy click en el boton Cerrar
    And el sistema direcciona a la ventana listado propuesta y doy click en boton Regresar
    And el sistema direcciona al Menu Principal y seleccionar opcion Cerrar Sesion
    And el sistema direcciona al login y doy click en boton Cerrar Sesion
    And finalmente cerrar el navegador para iniciar nuevamente

    Examples:
      | cliente |
      | 1487    |
      | 1692    |
      | 2028    |
      | 2172    |
      | 2240    |
      | 2266    |
      | 2363    |
      | 2379    |
      | 2517    |
      | 2601    |



























































