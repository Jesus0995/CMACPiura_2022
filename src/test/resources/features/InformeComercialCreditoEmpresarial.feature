Feature: Registrar Informe Comercial con el perfil Asesor de Negocio
  Yo como usuario Asesor de Negocio
  Quiero registrar Informe Comercial Nuevo Formato
  Para enlazar a la creacion de Propuestas

  @prueba
  Scenario Outline: Registrar Informe Comercial Nuevo Formato de los clientes en el sistema SGCRED
    Given el sistema SGCRED esta disponible para usarla
    When en la ventana login ingreso usuario y password del perfil Asesor de negocio
      | usuario | password |
      | ALPAMA  | prueba   |
    And en la ventana Login doy click en boton ingresar al SGCRED
    And el sistema muestra el home principal de SGCRED
    And en el menu principal seleccionar la opcion Informe Comercial Nuevo Formato
    And en la ventana Busqueda de Clientes seleccionar el tab por Codigo e ingresar el codigo "<cliente>"
    And en la ventana Busqueda de Clientes doy click en el boton Buscar
    And en la ventana Busqueda de Clientes doy click en el icono Ver Informe
    And el sistema direcciona a la ventana Defina el negocio y doy click en el boton Cargar
    And en la ventana Informes Comerciales doy click en el boton Crear Informe Comercial
    Then el sistema muestra la ventana principal Informe Comercial para ingresar el Patrimonio Personal "10000"
    And en la ventana principal Informe Comercial doy click en el boton grabar
    And en la ventana principal Informe Comercial doy click en el boton Regresar
    And el sistema direcciona a la ventana listado de informes comerciales y doy click en Regresar
    And el sistema direcciona al Menu Principal SGCRED y doy click en la opcion Cerrar Sesion
    And el sistema direcciona al Login y doy click en el boton Cerrar Sesion
    And finalmente cerrar el navegador

    Examples:
      | cliente |
      | 2095009  |
      | 3499790  |
      | 2228203  |
      | 11390269 |
      | 9707433  |
      | 25317866 |
      | 21838047 |
      | 8667250  |
      | 1489445  |
      | 25528670 |
