Feature: Ingresar a la pagina principal del sistema SGCRED de Caja Piura
  Yo como usuario asesor de finanzas de la aplicación SGCRED
  Quiero ingresar a la aplicación SGCRED
  Para visualizar el Home

  Scenario: Loguearse a la aplicación SGCRED
    Given La web esta disponible
    When ingrese usuario y password
      | nombre | password |
      | CIYAZU   | prueba   |
      | JURO   | prueba   |
      | NISI   | prueba   |
    And  doy click en boton ingresar
    And me muestra el home page
    Then doy click en cerrar sesion



