# language: es
Característica:
  Yo como usuario certificado capitalbank
  Quiero ingresar en la página theinternetherokuapp
  Para obtener un elemento de referencia y validar el logueo exitoso

  Esquema del escenario: Logueo en webpage
    Dado que soy un usuario certificado capitalbank con un '<testCase>'
    Cuando ingreso con el usuario '<user>' y contraseña '<pass>'
    Entonces valido que el logueo fue exitoso

    Ejemplos:
      | testCase  | user       | pass                 |
      | exitoso   | tomsmith   | SuperSecretPassword! |
      | passWrong | tomsmith   | incorrecta           |
      | passBlank | tomsmith   |                      |
      | usrWrong  | incorrecto | SuperSecretPassword! |
      | usrBlank  |            | SuperSecretPassword! |