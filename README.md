# CRUD App


## Descripción:
___
Esta es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) 
desarrollada  con Spring Boot.  Permite gestionar  usuarios con 
información   básica   como   nombre,   edad,   género,  correo 
electrónico y fecha de registro.


## Tecnologías Utilizadas:
___
* Java 21
* Spring Boot 3.3.4
* Hibernate
* PostgreSQL ( cualquier   otra   base  de   datos  que elijas, 
  recomecomiendo revisar el apartado application.properties)
* Maven

## Requisitos Previos:
___
* JDK 21
* Plugin Lombok
* Maven
* PostgreSQL (u otra base de datos)


# Configuración

## Clona el repositorio:
___
git clone <URL_DEL_REPOSITORIO>
cd App
___

## Configura la base de datos:
___
Asegúrate  de  tener  PostgreSQL instalado y en funcionamiento.
Crea   una   base   de   datos y  actualiza las credenciales en  
application.properties.

## Construye el proyecto:
___
mvn clean install
___

## Ejecuta la aplicación:
___
java -jar target/App-0.0.1-SNAPSHOT.jar
___

# Endpoints

## Crear un Usuario:
___
* Método: POST
  URL: /api/users
  
  Body:
___
{
  "name": "John Doe",
  "age": 30,
  "gender": "Male",
  "email": "john.doe@example.com",
  "date": "2024-10-02"
}
___

## Obtener Todos los Usuarios:
___
* Método: GET
  URL: /api/users

* Obtener Usuario por ID
  Método: GET
  URL: /api/users/{id}

* Actualizar Usuario
  Método: PUT
  URL: /api/users/{id}

  Body:
  ___
{
  "name": "John Doe",
  "age": 30,
  "gender": "Male",
  "email": "john.doe@example.com",
  "date": "2024-10-02"
}
___

* Eliminar Usuario
  Método: DELETE
  URL: /api/users/{id}




# MIT License

## Copyright (c) [2024] [Y0i7] [https://github.com/Y0i7]

Se concede permiso, de forma gratuita, a cualquier topic que obtenga una copia de este software y de los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricciones, incluyendo, sin limitación, los derechos a usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del Software, y a permitir a las personas a quienes se les proporcione el Software a hacerlo, sujeto a las siguientes condiciones:

...

El software se proporciona "tal cual", sin garantía de ningún tipo, expresa o implícita, incluyendo pero no limitado a las garantías de comerciabilidad, idoneidad para un propósito particular y no infracción. En ningún caso los autores o titulares de derechos de autor serán responsables de cualquier reclamación, daños u otras responsabilidades, ya sea en una acción de contrato, agravio o de otro tipo, que surja de, o en conexión con, el software o el uso u otros tratos en el software.
