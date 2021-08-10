Feature: Ingresar a la pagina principal del sistema SGCRED de Caja Piura SAC
  Yo como usuario asesor de finanzas de Caja Piura
  Quiero ingresar a la aplicación SGCRED
  Para visualizar el Home Principal

  Scenario: Login de la aplicación Sistema SGCRED
    Given La web esta disponible
    When ingrese usuario y password
      | nombre | password |
      | xxxxx  | prueba   |
      | xxxxx  | prueba   |
    And  doy click en boton ingresar
    And me muestra el home page
    Then doy click en cerrar sesion
    And confirmo el cierre de sesion




