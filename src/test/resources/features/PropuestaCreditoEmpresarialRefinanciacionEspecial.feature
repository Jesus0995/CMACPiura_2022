Feature: Registrar Propuesta de Credito empresarial por tipo Refinanciacion Especial en SGCRED
  Yo como Asesor de Negocio
  Quiero Registrar una propuesta credito empresarial por tipo propuesta Refinanciacion Especial
  Para su aprobacion

  Scenario Outline: Registrar propuesta credito empresarial de tipo Refinanciacion Especial con el perfil Asesor de Negocio
    Given Cuando el sistema SGCRED este disponible
    When ingrese el usuario y contraseña en SGCRED
      | Usuario | Password |
      | ALPAMA  | prueba   |
    And seleccionar el boton ingresar
    Then el sistema SGCRED muestra el menu principal
    And en el menu principal seleccionar PROPUESTA DE FINANCIAMIENTO
    And en Listado de propuestas seleccionar el boton crear nueva propuesta
    And en Busqueda de clientes seleccionar el tab CODIGO
    And en Busqueda de clientes ingresar el codcli "<cliente>"
    And en Busqueda de clientes hacer click en el boton buscar
    And en Busqueda de clientes seleccionar el icono informacion desactualizada
    Then en la ventana Requisitos propuesta seleccionar los siguientes campos:
      | TipoServicio        | ServicioCredito | TipoPropuesta           | SubTipoPropuesta | Promocion     | TipoOperacion |
      | CREDITO EMPRESARIAL | CREDITOS PYMES  | REFINANCIACION ESPECIAL | NORMAL           | SIN PROMOCION | SIMPLE        |
    And en la ventana Requisitos hacer click en el boton seleccionar pagare
    And en la ventana Requisitos hacer click en el boton cargar
    Then el sistema muestra ventana propuesta y doy cierro el comunicado
    And en la ventana propuesta seccion cancelar pagare seleccionar condiciones a refinanciar
    And en la ventana condiciones a refinanciar ingresar el siguiente dato
      | MontoAmortizar | InteresRefinanciar |
      | 100            | 100                |
    And en la ventana condiciones a refinanciar hacer click en grabar
    And en la ventana Propuesta doy click en el boton nueva operacion
    And en la ventana Seleccionar Operacion Credito doy click en aceptar
    And en la ventana Operacion Credito seleccionar el boton calcular tasa
    And en la ventana Operacion Credito ingresar el campo plan de pagos "Fija Vencida"
    And en la ventana Operacion Credito seleccionar el campo modalidad "Cronograma Pagos"
    And en la ventana Operacion Credito seleccionar el campo opcion "Fecha Fija"
    And en la ventana Operacion Credito seleccionar el campo dias de pago "5"
    And en la ventana Operacion Credito seleccionar el numero de cuotas "12"
    And en la ventana Operacion Credito ingresar el campo tasa preferencial "30.00"
    And en la ventana Operacion Credito seleccionar el la forma de desembolso "EFECTIVO"
    And en la ventana Operacion Credito ingresar el campo fecha de desembolso
    And en la ventana Operacion Credito ingresar el campo Notas "prueba"
    And en la ventana Operacion Credito hacer click en boton grabar
    And en la ventana Operacion Credito hacer click en alerta y cerrar ventana
    And en la ventana principal propuesta seleccionar el boton seguros
    And en la ventana Selecionar seguros hacer click en confirmar
    And en la ventana Seguros ingresar informacion correspondiente y hacer click en confirmar
    And en la ventana confirmar seguros click en confirmar y cerrar ventana





    Examples:
      | cliente |
      | 3534375 |