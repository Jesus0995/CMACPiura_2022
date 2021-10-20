Feature: Crear una Hoja de Trabajo en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una hoja de trabajo del cliente
  Para que se anexe en la propuesta de Créditos de Consumo


  @Prueba
  Scenario Outline: Crear una Hoja de Trabajo del cliente
    Given la pagina SGCRED esta disponible
    When se ingresa usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And se da click en boton ingresar
    And me muestra el home de SGCRED
    And doy click en link Hoja de Trabajo
    And me muestra la ventana listado de hojas de trabajo para realizar la busqueda en el tab codigo
    And en la ventana listado de hojas de trabajo ingresar el codigo a buscar "<cliente>"
    And en la ventana listado de hojas de trabajo doy click en el boton buscar
    And en la ventana listado de hojas de trabajo hacer click en el icono hoja de trabajo
    And me muestra la ventana hojas de trabajo
    And en la ventana hojas de trabajo doy click en el boton crear hoja de trabajo
    And me muestra la ventana Hoja de Trabajo
    And en la ventana Hoja de Trabajo se ingresa los datos de trabajo
      |TiempoLaboral|IngresosBoleta|IngresosReciboHonorario|GastosAlimentacion|GastosTransporte|GastosEducacion|GastosVivienda|GastosObligacionesTerceros|DescuentoBoleta|DescuentoReciboHonorario|
      | 48          |2500          | 0                     |600               |200             |300            |0             |0                         |400            |0                       |
    And en la ventana Hoja de Trabajo doy click en el boton grabar
    And en la ventana Hoja de Trabajo doy click en aceptar la alerta
    And en la ventana Hoja de Trabajo doy click en el boton finalizar
    And en la ventana Hoja de Trabajo doy click en aceptar la alerta
    And en la ventana grabar documento hoja de trabajo doy click en el botón cerrar
    And en la ventana hojas de trabajo doy click en el boton regresar
    And se posiciona en menu principal y doy click en la opcion cerrar sesion
    And se posiciona en login y doy click en el boton cerrar sesion
    And cierro sesion del navegador

    Examples:
      |cliente|
      |22466895|
      |24361969|
      |2536846|
      |17854720|
      |17075292|
      |16711829|
      |9161627|
      |20347368|
      |17138243|
      |15793|