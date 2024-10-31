Antes de nada, quiero agradeceros la oportunidad de haber formado parte de este proceso.

Es la primera vez que monto algo de este estilo desde cero, ya que siempre he trabajado en proyectos ya iniciados, donde he sido un engranaje más en el equipo. Esta experiencia me ha permitido enfrentarme a nuevos retos, como la implementación de cachés y aspectos (@Aspect), lo cual me ha ayudado a desarrollarme aún más en este campo.

He desarrollado la aplicación utilizando una arquitectura hexagonal en Java 17 con el SDK 17. La aplicación usa Spring Boot, Spring Security, JPA, y JUnit. Como base de datos, he utilizado H2 en memoria, he habilitado Lombok para simplificar el código y, para la caché, he integrado Redis (es necesario que el servidor Redis esté activo en el puerto 6379 para que funcione correctamente).

La aplicación, una vez configurada con el SDK 17, se inicia y genera un token en consola en este formato: 0856084b-e644-42f6-b819-734d6f7a36fd. Este token se debe introducir en Postman en la sección de "Authorization", configurado como "Basic Auth":

Username: user
Password: el token generado, en este caso 0856084b-e644-42f6-b819-734d6f7a36fd.

Una vez configurada la petición, se puede acceder a cualquiera de los endpoints que la aplicación tiene disponibles:

GET http://localhost:8080/spaceShip/search/all
- Entrada: dos parámetros opcionales en la petición (por defecto page = 0 y size = 10).
- int page: número de la página que se desea visualizar (empezando desde 0).
- int size: cantidad de elementos que queremos en la página.
- Salida: Todas las naves de la base de datos, paginadas.

GET http://localhost:8080/spaceShip/search/{spaceShipId}
- Entrada: parametro de ruta obligatorio
- int spaceShipId: id de la nave a buscar
- Salida: Datos de la nave con el ID especificado.

GET http://localhost:8080/spaceShip/search/byName (cacheado)
- Entrada: parametro opcional en la petición.
- String name: nombre de las naves a buscar
- Salida: Naves cuyo nombre contiene el valor proporcionado.

POST http://localhost:8080/spaceShip/crud/create (cacheado)
- Entrada: parametro opcional en la petición
- String name: nombre de la nave a crear
- Salida: Nave espacial creada.

PUT http://localhost:8080/spaceShip/crud/update/{spaceShipId} (cacheado)
- Entrada: 2 parametros en la petición.
- int spaceShipId: id de la nave espacial a actualizar
- SpaceShipUpdateRequest request: nuevos datos de la nave espacial
- Salida: Nave espacial actualizada.

DELETE http://localhost:8080/spaceShip/crud/delete/{spaceShipId} (cacheado)
- Entrada: parametro en la petición.
- int spaceShipId: id de la nave espacial a eliminar
- Salida: Confirmación de eliminación.

Si cualquiera de los endpoints cacheados emite un error, es posible que el servidor Redis no esté disponible. En ese caso, si no se tiene un servidor Redis instalado, es tan sencillo como comentar la línea con la anotación @Cacheable o @CacheEvict.

Para correr los test es tan simple como hacer click derecho en la carpeta src\test\java\com\paniagua\tecnica\domain\service y hacer click en la opción "Run Tests"

Me habría gustado profundizar más en los puntos opcionales de la prueba, pero, como mencioné a Micaela, estoy pasando por un momento personal difícil y no he tenido todo el tiempo que me habría gustado dedicarle. Por ello, pido disculpas de antemano.

Creo que no me dejo nada. Estoy a la espera de vuestro feedback y, como siempre, dispuesto a aprender y mejorar. ¡Gracias de nuevo!