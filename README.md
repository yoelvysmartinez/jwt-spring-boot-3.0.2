
<h1 align="center"> jwt-spring-boot-3.0.2 </h1>
Proyecto básico para la implementación de Autenticación y Autorización con Spring Boot + Spring Security + JWT + MySql

## Acceso Base Datos
* Recuerde crear su base de datos antes de ejecutar el proyecto y actualizar el nombre de la misma en el archivo **configuration.properties**. 
* El proyecto esta configurado para conectarse a una base de datos MYSQL pero puede cambiar en el **configuration.properties** las propiedades de conexión que se ajusten a su base de datos. 

## Tablas

Al ejecutar el proyecto por primera vez se crearan dos tablas en tu base de datos
* Rol - En esta tabla es necesario insertar los dos roles que maneja el ejemplo, estos roles son **ADMINISTRADOR, USUARIO_RESTRINGIDO**, los nombres de usuarios los puede adaptar a sus necesidades
* Usuario - En esta tabla el sistema guardara el nuevo usuario con una referencia al ROL al que pertenece el usuario. La entidad usuario implementa la interfaz UserDetails de spring security que le ayuda a saber como obtener la informacion del usuario por ejemplo el **username** y si el usuario esta activo o no. 

## Rutas Sin Proteccion
* Puede revisar en la clase **ConfiguracionSeguridad** las rutas permitidas como usuario anónimo. Las demas rutas es obligatorio enviar el token en la peticion y en dependencia del ROL permitido para el metodo podremos o no acceder al recurso. 
## EndPoint o URL

* POST http://127.0.0.1:8080/usuario/crear se usa para crear el usuario. Puede crear un usuario de cada tipo de rol para que pruebe el funcionamiento de la autorizacion.

**JSON ENTRADA**
```json
{
    "nombreUsuario": "administrador",
    "clave" : "123",
    "rol": "ADMINISTRADOR"
}
```

**JSON SALIDA**
```json
{
    "id": 1,
    "nombreUsuario": "administrador",
    "rol": "ADMINISTRADOR",
    "token": null
}
```

* POST http://127.0.0.1:8080/usuario/login se usa para hacer login y nos devolveró el jwt que usaremos para acceder a los recursos protegidos de nuestra aplicacion.

**JSON ENTRADA**
```json
{
    "nombreUsuario": "administrador",
    "clave" : "123"
}
```

**JSON SALIDA**
```json
{
    "id": 1,
    "nombreUsuario": "administrador",
    "rol": "ADMINISTRADOR",
    "token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbmlzdHJhZG9yIiwiZXhwIjoxNjc1NTcwOTkzfQ.TdjXBEVgSxsPvScrQwhs3Fuwj-bTo_KO3LYckXJ0Fsoi_rDfA9KHPf9w0wdFEA7a"
}
```
**Cada vez que se ejecute el método login se genera un token que tendrá una validez de 1h**

* GET http://127.0.0.1:8080/usuario/area/usuario-logueado Podras acceder siempre que la petición contenga el token válido, no importa el rol del usuario.
* GET http://127.0.0.1:8080/usuario/area/administrador  Solo podras acceder si la petición contiene un token válido y de un usuario con rol ADMINISTRADOR
* GET http://127.0.0.1:8080/usuario/area/usuario-restringido Solo podras acceder si la petición contiene un token válido y de un usuario con rol USUARIO_RESTRINGIDO
* Observacion: Las rutas tienen nombres de los roles solo como demostración del ejercicio, el nombre de cada ruta dependerá de las necesidades de sus proyectos

## Bono

No es una buena practica exponer en nuestros endpoint nuestras entidades, esto es algo comun en la mayoria de los cursos de programacion que se encuentran en la red. Es por eso que aqui les dejo tambien un pequeño ejemplo de como podemos
recibir y devolver DTO sin exponer nuestra entidad.

Para este ejemplo se uso **mapstruct** para convertir el **UsuarioDTO -> Usuario** y **Usuario -> UsuarioDTO**.

