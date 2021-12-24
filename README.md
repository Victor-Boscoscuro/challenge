# API PERSONA
_Basic API REST with Spring Boot and MySQL_
-------------

## Rutas :twisted_rightwards_arrows:


**/persona/new**

_Crea una nueva persona_

Ejemplo de body esperado:
```
{
  "nombre":"Victor",
  "apellido":"Boscoscuro",
  "es_empleado":true,
  "dni",:12345678
}
```
_aclaracion: el dni es único por persona_

-----

**/persona/delete**

_Elimina una persona ya existente_

Se espera el dni de la persona a eliminar como un **param**. Ejemplo:
```
../persona/delete?dni=12345678
```
-------

**/persona/update**

_Actualiza los datos de una persona existente_

Ejemplo de body esperado:
```
{
  "nombre":"Victor",
  "apellido":"Boscoscuro",
  "es_empleado":false,
  "dni",:12345678
}
```
_aclaracion: el dni es requerido para identificar la persona y debe coincidir con uno ya existente_

------

## Swagger

**/swagger**

_Devuelve json con los métodos definidos_

**/swagger-ui.html

_Swagger UI básico_

