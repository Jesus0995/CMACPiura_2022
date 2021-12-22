Feature: Aprobar propuesta de credito empresarial con el perfil Jefe de Credito
  Yo como usuario Jefe de credito
  Quiero Aprobar propuestas de credito empresarial
  Para remitir al siguiente aprobador

  Scenario: Registrar la Aprobación de propuesta credito empresarial
    Given la URL del sistema SGCRED este disponible
    When se ingresa las credenciales correspondientes del aprobador
      | usuario | password |
      | LARI    | prueba   |
    And hacer click en el boton ingresar para que nos muestre el menu principal
    Then se ejecuta los siguientes pasos para aprobar desde archivo excel "DatosCreditoEmpresarialRefinanciacion.xlsx"
