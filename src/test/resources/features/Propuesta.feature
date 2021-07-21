Feature: Crear una propuesta de financiamiento de tipo NORMAL en SGCRED
  Yo como usuario asesor de creditos
  Quiero registrar una propuesta de tipo Normal
  Para que aprueben la propuesta

Scenario:  Crear una propuesta de financiamiento Normal
  Given la web SGCRED esta disponible
  When ingreso usuario y password
    |nombre | password|
    |   | prueba  |
  And doy click en boton ingresar
  And seleccionar link propuesta de financiamiento
  And seleccionar boton crear propuesta de financiamiento
  And Ingresar codigo de cliente a buscar
  And doy click en boton buscar
  And doy clic en crear nueva propuesta



