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

    Examples:
      | cliente |
      | 5802202 |