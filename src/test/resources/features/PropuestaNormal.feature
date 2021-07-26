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
  And doy click en propuesta financiamiento
  And doy click en crear propuesta de la ventana Listado Propuesta
  And realizar busqueda de cliente para crear propuesta
  And ingresar operaciones de credito





