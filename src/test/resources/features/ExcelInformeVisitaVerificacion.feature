Feature: Registrar informe de visita verificacion con el perfil Jefe de Credito
  Yo como usuario Jefe de Credito
  Quiero registrar el informe de visita verificacion de la propuesta registrada
  Para continuar con el proceso de registro de la propuesta credito

  @prueba
  Scenario: Registrar el informe visita verificacion con el perfil Jefe de credito
    Given la URL del SGCRED este disponible para su uso
    When se ingresa las credenciales del jefe de credito para registrar
      | usuario | password |
      | NISI    | prueba   |
    And hacemos click en el boton ingresar para visualizar el menu principal para empezar
    Then ejecutamos los pasos definidos desde el archivo excel definido "DatosRegistrarInformeVisitaVerificacion.xlsx"