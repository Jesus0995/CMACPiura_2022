Feature: Crear una propuesta de Creditos de Consumo de tipo Normal en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una propuesta de Creditos de Consumo de tipo Normal mediante archivo Excel
  Para su aprobacion


  Scenario: Crear una propuesta de Creditos de Consumo de tipo Normal desde el Excel
    Given la pagina web SGCRED esta habilitado
    When completa el usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And se presiona el boton ingresar y muestra el SGCRED
    Then ejecutar los registros de propuestas de credito desde Excel "DatosCreditoConsumo.xlsx"