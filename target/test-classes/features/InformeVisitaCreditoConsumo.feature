Feature: Registrar informe de visita con el perfil Asesor de Negocios
  Yo como usuario Asesor de Negocios
  Quiero registrar un informe de visita
  Para enlazar a la creacion de propuestas


  Scenario Outline: Registrar informe de visita del cliente en el sistema SGCRED
    Given la pagina web SGCRED se encuentra disponible
    When ingreso usuario y password del perfil Asesor de Negocios
      | nombre | password |
      | CIYAZU | prueba   |
    And doy click en el boton ingresar al SGCRED
    And muestra home principal de SGCRED
    And doy click en la opcion informe visita
    And muestra la ventana busqueda de clientes y realizar la busqueda en el tab codigo
    And en la ventana busqueda de clientes digitar el codigo a buscar "<cliente>"
    And en la ventana busqueda de clientes y doy click en el boton buscar
    And en la ventana busqueda de clientes y doy click en el icono informe visita
    And muestra ventana seleccionar rubro y doy click en el boton cargar
    And muestra la ventana lista de informes y doy click en el boton crear informe
    And muestra la ventana informe e ingreso la fecha de visita
    And en la ventana informe de visita e ingresar datos de visita
      | HoraVisita | MinutoVisita | FranjaHora |
      | 09         | 30           | A.M        |
    And en la ventana informe de visita ingresar datos de verificacion domiciliaria
      | NumeroIntegrantes | Relacion | Habitos             | OtrosIngresos |
      | 3                 | Estable  | Dentro de lo Normal | NO            |
    And en la ventana informe de visita ingresar datos de verificacion del negocio
      | RelacionLaboral | DocumentoSustento                |
      | Buena           | Presentada en Regla (Originales) |
    And en la ventana informe de visita seleccionar el tipo de evaluacion
    And en la ventana informe de visita seleccionar la declaracion de SPLAFT
    And en la ventana informe de visita ingresar la observacion "Prueba informe visita"
    And en la ventana informe de visita doy clik en el boton grabar
    And muestra la ventana grabar informacion y doy click en el boton cerrar
    And el sistema direcciona a informe de visita y doy click en el boton regresar
    And muestra la ventana lista de informes y doy click en el boton regresar
    And el sistema direcciona a menu principal y doy click en la opcion cerrar sesion
    And direcciona en login y doy click en el boton cerrar sesion
    And cierro navegador

    Examples:
      |cliente|
      |23934914|


