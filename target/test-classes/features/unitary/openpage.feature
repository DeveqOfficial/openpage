# language: es
Característica:
  Yo como usuario certificado capitalbank
  Quiero ingresar en la página theinternetherokuapp
  Para obtener un elemento de referencia y validar el logueo exitoso

  Esquema del escenario: Logueo en webpage
    Dado que soy un usuario certificado capitalbank
    Cuando ingreso con el usuario '<user>' y contraseña '<pass>'
    Entonces valido que el logueo fue exitoso

    Ejemplos:
      | user       | pass                 |
      | tomsmith   | SuperSecretPassword! |
      | tomsmith   | incorrecto           |
      | tomsmith   |                      |
      | incorrecto | SuperSecretPassword! |
      |            | SuperSecretPassword! |