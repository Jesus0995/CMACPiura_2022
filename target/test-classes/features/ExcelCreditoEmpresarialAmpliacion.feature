Feature: Crear una propuesta de Ampliación de Crédito Empresarial en el sistema SGCRED de Caja Piura
  Yo como usuario asesor de créditos de Caja Piura
  Quiero registrar una Ampliación de Créditos Empresarial mediante archivo Excel
  Para su aprobacion

  Scenario: Crear una propuesta de Ampliación de Crédito Empresarial desde el Excel
    Given que la pagina web deL SGCRED está disponible
    When ingreso el usuario y clave del asesor
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en el botón Ingresar y muestra el menu principal
    Then registrar las propuestas de ampliación de créditos desde Excel "DatosCreditoEmpresarialAmpliacion.xlsx"
