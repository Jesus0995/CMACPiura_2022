Feature: Crear una propuesta de Creditos de Consumo de tipo Normal en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una propuesta de Creditos de Consumo de tipo Normal
  Para su aprobacion

  @Prueba
  Scenario: Crear una propuesta de Creditos de Consumo de tipo Normal
    Given la pagina web SGCRED esta disponible
    When se completa el usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en el boton ingresar
    And muestra el home de SGCRED
    And doy click en el link propuesta financiamiento
    And doy click en el boton Crear_Propuesta de la ventana Listado Propuesta
    And muestra la ventana cliente para realizar la busqueda en el tab codigo
    And el codigo de cliente se lee del archivo excel
    And para el registro de la operacion de credito se leera del archivo excel

