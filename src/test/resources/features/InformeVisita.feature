Feature: Registrar informe de visita con el perfil Asesor de Finanzas Empresariales
  Yo como usuario Analista de Negocio
  Quiero registrar informe de visitas
  Para enlazar a la creacion de propuestas

  @Prueba
  Scenario Outline: : Registrar informe de visitas de los clientes en el sistema SGCRED
    Given la web SGCRED esta disponible para usarla
    When ingreso usuario y password del perfil Asesor de Finanzas Empresariales
      | nombre | password |
      | ALPAMA | prueba   |
    And doy click en boton ingresar al SGCRED
    And Mostrar home principal de SGCRED
    And doy click en el menu informe visita
    And en la ventana busqueda de clientes seleccionar el tab por Codigo e ingresar el codigo "<cliente>"
    And en la ventana busqueda de clientes doy click en el boton buscar
    And en la grilla de la ventana seleccionar el icono informe visita
    Then el sistema direcciona a la ventana SeleccionarRubroNegocio y doy click en boton Cargar



    Examples:
    |cliente|
    |23397676|