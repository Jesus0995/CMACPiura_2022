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
    And en la ventana cliente ingresar el codigo a buscar
    And en la ventana cliente doy click en el boton buscar
    And en la ventana cliente hacer click en el icono propuesta
    And el sistema muestra la ventana de servicio e ingresamos la informacion
      | TipoServicio        | ServicioCredito | TipoPropuesta | SubTipoPropuesta | Promocion     | Negocio                                  | TipoOperacion |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | NORMAL        | NORMAL           | SIN PROMOCION | VENTA AL POR MENOR DE PRENDAS DE VESTIR, | SIMPLE        |
    And validar el mensaje del popup Comunicado
    And ingresar comentario crediticio














