Feature: Registrar propuesta de credito empresarial de tipo Refinanciaciono
  Yo como usuario Analista de Negocio
  Quiero registrar propuesta de credito empresarial de tipo Refinanciacion Mismo Pagare
  Para su posterior aprobacion


  Scenario: Registrar propuesta de credito empresarial de tipo Refinanciacion Mismo Pagare
    Given la web SGCRED esta disponible para su uso
    When se ingresa las credencial correspondiente
      | usuario | password |
      | CIYAZU | prueba   |
    And da click en ingresar para mostrar el menu principal
    Then se ejecuta todos los pasos corresondientes al flujo Refinanciacion Mismo Pagare desde excel "DatosCreditoEmpresarialRefinanciacionMismoPagare.xlsx";
