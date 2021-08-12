Feature: Registrar informe de visita
  Yo como usuario Analista de Negocio
  Quiero registrar informe de visitas
  Para enlazar a la creacion de propuestas

  Scenario: Registrar informe de visitas de los clientes en el sistema SGCRED
    Given la web SGCRED esta disponible
    When ingreso usuario y password
      | nombre | password |
      | ALPAMA | prueba   |
    And doy click en boton ingresar
    And Mostrar home de SGCRED
    And doy click en el menu informe visita
