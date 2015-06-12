### 3/6
* Encapsulamiento de coordenadas en `Map`? (todos los métodos tienen que ser públicos?)

* No abusar del patrón singleton, hace más complejo el código y más difícil de testear y en algunos casos no es necesario (ej: templates)

* Evitar en lo posible usar atributos `protected`, ej: `Builder.dependsOn` podría reemplazarse con métodos protegidos en Builder para agregar y consultar dependencias y así se baja el acoplamiento entre esta clase y sus sub-clases

* Reglas de negocio obscuras (ej: `MuggleUnit.canFly()` unidades pueden volar si `transportationQuota == 0`)

* Pruebas:
  * Faltan pruebas unitarias
  * Diferenciar pruebas de integración de pruebas unitarias
  * Debe haber una clase con pruebas unitarias por cada clase del modelo
  * La estructura de carpetas / paquetes para las pruebas tiene que ser idéntica a la del modelo

### Estado entregables:

  - Pruebas para setear posición inicial del jugador en el mapa (?)
* Pruebas de creación de unidades:
  * Haber construido primero el edificio que me habilite a construirla **FALTA**
  * Contar con recursos (mineral y/o gas) necesarios **FALTA**
  * Contar con límite de población para crearla **FALTA**
