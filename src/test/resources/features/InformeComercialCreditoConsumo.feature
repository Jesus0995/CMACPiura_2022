Feature: Registrar informe comercial nuevo con el perfil Asesor de Negocios
  Yo como usuario Asesor de Negocios
  Quiero registrar un informe comercial nuevo
  Para enlazar a la creacion de propuestas


  Scenario Outline: Registrar informe comercial nuevo del cliente en el sistema SGCRED
    Given la pagina web del SGCRED se encuentra disponible
    When ingreso usuario y password del Asesor de Negocios
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en el boton ingresar del login
    And muestra el home principal de SGCRED
    And doy click en la opcion informe comercial
    And muestra la busqueda de clientes y realizar la busqueda en el tab codigo
    And en la ventana busqueda de clientes digitar el codigo "<cliente>"
    And en la ventana busqueda de clientes y doy click en boton buscar
    And en la ventana busqueda de clientes y doy click en el icono informe comercial
    And muestra ventana definir negocio y doy click en el boton cargar
    And muestra la ventana informes comerciales y doy click en el boton crear informe
    And muestra la ventana nuevo informe comercial e ingresar datos el patrimonio "40000"
    And en la ventana nuevo informe comercial doy clik en el boton grabar
    And en la ventana nuevo informe comercial doy clik en el boton regresar
    And muestra la ventana informes comerciales y doy click en el boton regresar
    And posiciona en menu principal y doy click en la opcion cerrar sesion
    And posiciona en login y doy click en el boton cerrar sesion
    And se cierra el navegador

    Examples:
      |cliente|
      |23934914|
