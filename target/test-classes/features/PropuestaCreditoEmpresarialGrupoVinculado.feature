Feature: Crear una propuesta de Credito Empresarial de tipo NORMAL con informe EEFF grupo vinculado en el Sistema SGCRED
  Yo como usuario asesor de creditos de Caja Piura SAC
  Quiero registrar una propuesta de credito Empresarial de tipo Normal
  Para su aprobacion correspondiente

  @Prueba
  Scenario Outline:Crear una propuesta de Credito Empresarial de tipo propuesta Normal con informe EEFF grupo vinculado Perfil "Asesor de Negocio"
    Given web SGCRED esta disponible
    When ingresar el usuario y password
      | usuario | password |
      | ALPAMA  | prueba   |
    Then hacer click en boton ingresar
    And mostrar pagina principal de SGCRED
    And en el menu principal doy click en link propuesta financiamiento
    And en la ventana listado de propuestas hacer click en el boton crear propuesta
    And en la ventana cliente seleccionar el tab codigo para realizar la busqueda
    And en la ventana cliente ingresar codigo a buscar "<cliente>"
    And en la ventana cliente hacer click en el boton buscar
    And en la ventana cliente hacer click en el icon propuesta
    And en la ventana servicio ingresar informacion y hacer click en el boton cargar
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | NORMAL        | NORMAL           | SIN PROMOCION |
    And en la ventana propuesta validar el mensaje del popup Comunicado
    And en la ventana propuesta hacer click en el boton nueva operacion
    And en la ventana operacion credito hacer click en boton aceptar
    And en la ventana operacion credito ingresar datos de la operacion y hacer click en boton calcular
      | Moneda | Monto | TasaInicial |
      | S/     | 3000  | 1           |
    And en la ventana operacion credito seleccionar plan de pagos "Fija Vencida"
    And en la ventana operacion credito seleccionar modalidad "Libre Amortizacion"
    And en la ventana operacion credito ingresar dias "90"
    And en la ventana operacion credito ingresar porcentaje de Tasa Preferencial "30.00"
    And en la ventana operacion credito seleccionar forma de desembolso "GIRO BANCO DE LA NACION"
    And en la ventana operacion credito seleccionar plaza de desembolso
      | Departamento | Provincia | Distrito |
      | LIMA         | LIMA      | LIMA     |
    And en la ventana operacion credito ingresar fecha probable del desembolso
    And en la ventana operacion credito Ingresar notas "Prueba"
    And en la ventana operacion credito hacer click en el boton grabar
    And en la ventana operacion credito hacer click en la alerta
    And en la ventana propuesta hacer click al boton registro de seguros
    And en la ventana seleccion de seguros hacer click en boton confirmar
    And en la ventana registro seguros hacer check en seguro desgravamen flat MN
    And en la ventana registro seguros ingresar el numero DPS seguro desgravamen
    And en la ventana registro seguros hacer check en seguro todo riesgo Plan Pymes
    And en la ventana registro seguros ingresar el numero DPS Seguro Plan Pymes
    And en la ventana registro seguros hacer click en el boton confirmar
    And en la ventana seguros seleccionados validar la informacion y hacer click en el boton cerrar
    And en la ventana propuesta hacer click en el boton anexar CheckList creditos
    And en la ventana checkList credito seleccionar todas las opciones de los expedientes
    And en la ventana checkList hacer click en el boton guardar y terminar finalmente aceptar la alerta
    And en la ventana confirmar checklist de Credito hacer click en el boton cerrar
    And en la ventana propuesta ingresar todos los comentarios de la propuesta
    And en la ventana propuesta hacer click en el boton anexar garantias existentes
    And en la ventana seleccionar garantias hacer click en el boton registrar garantias
    And en la ventana garantias existentes seleccionar todas las garantias existentes
    And en la ventana garantias existentes hacer click en el boton aceptar
    And en la ventana cancelacion de pagares se cierra automaticamente
    And en la ventana propuesta hacer click en el boton enlazar estados financieros
    And en la ventana estados financieros hacer click en el boton enlazar
    And en la ventana propuesta hacer click en el boton desenlazar el informe de visita precargado por defecto
    And en la ventana desenlazar informe de Visita y hacer click en el boton realizar
    And en la ventana propuesta y hacer click en el boton enlazar informe comercial nuevo
    And en la ventana enlazar informe comercial hacer click en el boton realizar
    And en la ventana propuesta hacer click en el boton enlazar informe visita
    And en la ventana enlazar informe de visita hacer click en el boton realizar
    And en la ventana propuesta ingresar comentarios de los principales ratios "Comentarios positivos"
    And en la ventana propuesta doy click en el boton enlazar informe de estados financieros grupo vinculado
    And en la ventana informe de estados financieros grupo vinculado ingresar comentarios y hacer click en el boton grabar
    And en la ventana informe de estados financieros grupo vinculado hacer click en el boton finalizar y finalmente cerrar la ventana
    And en la ventana propuesta hacer click en el menu grabar
    And en la ventana grabar informacion hacer click en el menu cerrar
    And en la ventana propuesta hacer click en el menu emitir dictamen
    And en la opcion del menu emitir dictamen seleccionar el boton aprobar
    And en la ventana emitir dictamen propuesta ingresar observaciones y password del usuario asesor
      | Observaciones     | Contrasena |
      | Aprobar propuesta | prueba     |
    And en la ventana emitir dictamen propuesta hacer click en el boton procesar
    And en la ventana grabar informacion hacer click en el boton cerrar
    And en la ventana listado propuesta hacer click en boton regresar
    And en la ventana menu principal seleccionar la opcion cerrar sesion
    And en la ventana login hacer click en boton cerrar sesion
    And en la ventana final cerrar el navegador

    Examples:
      | cliente |
      | 1487    |



























































