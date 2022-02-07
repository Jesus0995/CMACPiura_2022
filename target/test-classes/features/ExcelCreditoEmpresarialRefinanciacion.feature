Feature: Registrar propuesta de credito empresarial de tipo Refinanciacion
  Yo como usuario Analista de Negocio
  Quiero registrar propuesta de credito empresarial de tipo refinanciacion
  Para su posterior aprobacion


  Scenario: Registrar propuesta de credito empresarial de tipo Refinanciacion
    Given la web SGCRED esta disponible para su uso optimo
    When se ingresa las credencial del usuario correspondiente
      | usuario | password |
      | CIYAZU  | prueba   |
    And hacemos click en ingresar para mostrar el menu principal
    Then se ejecuta todos los pasos corresondientes al flujo Refinanciacion desde excel "DatosCreditoEmpresarialRefinanciacion.xlsx";

