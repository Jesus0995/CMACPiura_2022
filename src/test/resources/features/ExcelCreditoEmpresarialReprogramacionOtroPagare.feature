Feature: Crear una propuesta de Reprogramación de Creditos de Empresarial en el sistema SGCCRED de Caja Piura
  Yo como usuario asesor de creditos de Caja Piura
  Quiero registrar una Reprogramación de Creditos Empresarial en otro Pagare mediante archivo Excel
  Para su aprobacion

  @Prueba
  Scenario: Crear una propuesta de de Reprogramación de Creditos de Empresarial en Otro Pagare desde el Excel
    Given la pagina web SGCRED es correcto
    When digita el usuario y password
      | nombre | password |
      | CIYAZU | prueba   |
    And se da click en el boton ingresar y muestra el SGCRED
    Then registrar las propuestas de reprogramacion de creditos desde Excel "DatosCreditoEmpresarialReprogramacionOtroPagare.xlsx"
