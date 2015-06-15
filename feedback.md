## 10/6

* Qué decidieron finalmente sobre los puntos dentro de las parcelas?
* Idem singletons para templates
* Números mágicos todavía presentes
* Uso de atributos protegidos aún presente
* `MuggleUnit.canFly()` todavía chequea atributo `transportationQuota` para decidir si puede o no volar
* Usar método de setup para inicializar atributos en las pruebas (ej: `MapTest`)
* Debería validarse los parámetros de construcción de objetos (ej: no se debería permitir construir edificios con posición `null`)
* No deberían usarse atributos para valores calculables para evitar duplicar información (ej: `Player.populationQuota`)
* Muchas pruebas para testear lo mismo (ej: `MarineTest` - si se estan probando escenarios distintos los nombres de los tests deberían ser más claros)
* Objeto `StarCraft` responsable de mover unidades
* Objeto `Unit` conoce el daño de ataques especiales (`Unit.TORMENTA_PSIONICA_DAMAGE` / `Unit.RADIACION_DAMAGE`)

### Estado entregables:

* Faltan tests de integración para construcción de unidades y edificios utilizando todos los objetos del modelo (ej: en un mapa definido, con una posición dada, etc.)
* Faltan tests de integración para movimiento de unidades
* Faltan tests de ataque normal
* Faltan tests de integración de ataque mágico
* Faltan tests de transporte para asegurarse que desembarca en nueva posición

## 3/6

* Por ahora no avancen con la UI
* Encapsulamiento de coordenadas en `Map`? (todos los métodos tienen que ser públicos?)
* Constantes van en mayúsculas (ej: `Player.resourcesProducedPerTurn`, etc.)
* Cuál es el uso que piensan darle a las unidades / estructuras _muertas_?
* Usar interfaz o generic para `Construction.construction`
* No romper el encapsulamiento pasando referencias de atributos de tipo colección, usar una interfaz menos _intrusiva_ como `Iterable` (ej: `Builder.create`)
* No abusar del patrón singleton, hace más complejo el código y más difícil de testear y en algunos casos no es necesario (ej: templates)
* Usar constantes para _números mágicos_ (ej: `CentroMineralTemplate`)
* Evitar en lo posible usar atributos `protected`, ej: `Builder.dependsOn` podría reemplazarse con métodos protegidos en Builder para agregar y consultar dependencias y así se baja el acoplamiento entre esta clase y sus sub-clases
* Reglas de negocio obscuras (ej: `MuggleUnit.canFly()` unidades pueden volar si `transportationQuota == 0`)
* Para que se usa `StructureID`?
* Pruebas:
  * Faltan pruebas unitarias
  * Diferenciar pruebas de integración de pruebas unitarias
  * Debe haber una clase con pruebas unitarias por cada clase del modelo
  * La estructura de carpetas / paquetes para las pruebas tiene que ser idéntica a la del modelo
  * Nombres de test (ej: `ProtossGasExploiterTest`)

### Estado entregables:

* Pruebas unitarias al mapa, que pueda generar escenarios para que empiecen los jugadores **OK**
  - Pruebas para setear posición inicial del jugador en el mapa (?)
* Pruebas de recolección de minerales y gas con los edificios correspondientes. **OK**
* Pruebas de creación de unidades:
  * Haber construido primero el edificio que me habilite a construirla **FALTA**
  * Contar con recursos (mineral y/o gas) necesarios **FALTA**
  * Contar con límite de población para crearla **FALTA**

### Otros comentarios

* Agregar badge de Travis (http://docs.travis-ci.com/user/status-images/)
* Acceso al repositorio
