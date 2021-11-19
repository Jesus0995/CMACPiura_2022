Feature: Ingresar a la pagina principal del sistema SGCRED de Caja Piura SAC
  Yo como usuario asesor de finanzas de Caja Piura
  Quiero ingresar a la aplicación SGCRED
  Para visualizar el Home Principal


  Scenario Outline: Login de la aplicación Sistema SGCRED
    Given La web esta disponible
    When ingrese Usuario como "<usuario>" y Password como "<password>"
    And  doy click en boton ingresar
    And me muestra el home page
    Then doy click en cerrar sesion
    And confirmo el cierre de sesion
    Then puedo iniciar nueva sesion

    Examples:
      | usuario | password |
      | lari    | prueba   |




