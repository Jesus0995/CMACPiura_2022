Feature: Crear una propuesta de Credito Empresarial de tipo Normal en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una propuesta de Credito Empresarial de tipo Normal mediante archivo Excel
  Para su aprobacion


  Scenario: Crear una propuesta de Creditos Empresarial de tipo Normal desde el Excel
    Given la pagina web SGCRED lista para utilizar
    When se ingresa el usuario y password
      | usuario | password |
      | CIYAZU   | prueba   |
    And hacer click en el boton ingresar y muestra el Home SGCRED
    Then ejecutar los registros de propuestas de Credito Empresarial desde Excel "DatosCreditoEmpresarial.xlsx"