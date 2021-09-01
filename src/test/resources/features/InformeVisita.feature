Feature: Registrar informe de visita con el perfil Asesor de Finanzas Empresariales
  Yo como usuario Analista de Negocio
  Quiero registrar informe de visitas
  Para enlazar a la creacion de propuestas

  @Prueba
  Scenario: Registrar informe de visitas de los clientes en el sistema SGCRED
    Given la web SGCRED esta disponible para usarla
    When ingreso usuario y password del perfil Asesor de Finanzas Empresariales
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en boton ingresar al SGCRED
    And Mostrar home principal de SGCRED
    And doy click en el menu informe visita
