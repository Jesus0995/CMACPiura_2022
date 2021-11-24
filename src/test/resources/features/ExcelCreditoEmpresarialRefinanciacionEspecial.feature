Feature: Crear una propuesta de Credito Empresarial de tipo Refinanciacion Especial en el sistema SGCCRED de Caja Piura
  Yo como usuario Asesor de Negocios de Caja Piura
  Quiero registrar una propuesta de Credito Empresarial de tipo Refinanciacion Especial mediante archivo Excel
  Para su aprobacion


  Scenario: Crear una propuesta de Creditos Empresarial de tipo Refinanciacion Especial desde el Excel
    Given la pagina web SGCRED esta disponible para su uso
    When el usuario y password tengan lo siguiente
      | usuario | password |
      | ALPAMA | prueba   |
    And hacer click en el boton ingresar y muestra el menu principal
    Then ejecutar los registros de propuestas de Credito Empresarial Refinanciacion Especial desde Excel "DatosCreditoEmpresarialRefinanciacionEspecial.xlsx"