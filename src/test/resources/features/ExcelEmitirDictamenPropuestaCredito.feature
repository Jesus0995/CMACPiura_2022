Feature: Emitir Dictamen de Propuesta con el perfil Asesor de Negocio
  Yo como usuario Asesor de Negocio de Caja Piura
  Quiero Emitir Dictamen de una propuesta
  Para su Aprobacion correspondiente


  Scenario: Emitir Dictamen de Propuesta
    Given el sistema SGCRED se encuentra disponible para su uso
    When el usuario y password del perfil ADN tengan las credenciales correctas
      | usuario | password |
      | CIYAZU  | prueba   |
    And hacer click en el boton ingresar y el sistema muestra el menu principal
    Then ejecutar todos los pasos para la emision de dictamen desde excel "DatosCreditoEmpresarialReprogramacionOtroPagare.xlsx";
