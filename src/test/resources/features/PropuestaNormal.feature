Feature: Crear una propuesta de financiamiento de tipo NORMAL en SGCRED
  Yo como usuario asesor de creditos
  Quiero registrar una propuesta de tipo Normal
  Para que aprueben la propuesta

Scenario:  Crear una propuesta de financiamiento Normal
  Given la web SGCRED esta disponible
  When ingreso usuario y password
    |nombre | password|
    | ALPAMA  | prueba  |
  And doy click en boton ingresar
  And Mostrar home de SGCRED
  And doy click en link propuesta financiamiento
  And doy click en el boton crear_propuesta de la ventana Listado Propuesta
  And mostrar la ventana cliente para realizar la busqueda en el tab codigo
  And en la ventana cliente ingresar el codigo a buscar
  And en la ventana cliente doy click en el boton buscar
  And en la ventana cliente hacer click en el icono propuesta
  And SGCRED muestra la ventana servicio y seleccionamos el servicio para generar la propuesta
  And en la ventana servicio seleccionar el Servicio credito
  And en la ventana servicio seleccionar tipo de propuesta
  And en la ventana servicio seleccionar subtipo de propuesta
  And en la ventana servicio seleccionar promocion
  And en la ventana servicio doy click en el boton cargar







