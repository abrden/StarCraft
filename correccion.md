## Carpeta

### Generalidades

###### ¿Son correctos los supuestos y extensiones?
**SI**

###### ¿Es prolija la presentación? (hojas del mismo tamaño, numeradas y con tipografía uniforme)
**SI**

### Modelo

###### ¿Está completo? ¿Contempla la totalidad del problema?
**SI**

###### ¿Respeta encapsulamiento?
**NO**
* Clases del modelo definen como se deben representar en la vista (ej: `Land.setDrawableView()`, interfaz `Drawable` definida en el paquete del modelo)
* Vista realiza validaciones (ej: `StartUpView.checkPlayerSetup()`). Esto debería ser responsabilidad **exclusiva** del modelo.
* Código de Vista y Controlador sin ninguna división (vistas implementan interfaz `MouseListener` efectuando las llamadas al modelo directamente)
* Información duplicada al poner a construir una estructura:
  1. Se setea la parcela en estado _en construcción_ (`Parcel.setConstruction()`)
  1. Se agrega una construcción a la cola (`ConstructionQueue.addStructure()`)
  1. Se agrega al mapa una estructura en construcción (`Map.addStructureInConstruction()`)

  El estado debería almacenarse en un único lugar para evitar inconsistencias por tener datos duplicados (ej: usando solo la cola de construcción)

###### ¿Hace un buen uso de excepciones?
**SI**
* Faltan validaciones (ej: `PlayerSetup.parseRace()` debería tener un default que arroje una excepción si el nombre de la raza pasada como string es inválido, idem para el color)

###### ¿Utiliza polimorfismo en las situaciones esperadas?
**SI**
* Casteo innecesario a `MuggleUnit` en `Player.update()`: si ya sé que la unidad tiene un ataque para que necesito saber de que tipo concreto es? Debería alcanzar con obtener el ataque de la unidad y aplicarselo a la unidad atacada

## Diagramas

### Diagrama de clases

###### ¿Está completo?
**SI**
* Faltan cardinalidades en asociaciones
* Falta asociación `StarCraft.activePlayer` en diagrama "DiagramaDeClasesMap.png"

###### ¿Está bien utilizada la notación?
**SI**

### Diagramas de secuencia

###### ¿Está completo?
**SI**
* Falta objeto ConstructionQueue en diagrama "SequenceBuildingOfBarraca.png"
* Diagramas duplicados: cuál vale "newStructure.png" ó "SequenceBuildingOfBarraca.png"? Y "newUnit.png" ó "SequenceCreatingUnitScout.png"?

###### ¿Es consistente con el diagrama de clases?
**SI**
* Mensaje `Player.attack()` no se envía desde `Player.move()` (diagrama "move.png")

###### ¿Está bien utilizada la notación?
**SI**
* Mensajes deben ponerse en secuencia alineados verticalmente (ej: mensaje 1.2.2 se envía _luego_ que mensaje 1.3 en diagrama "embark.png")
* Nombres de objetos deben seguir la convención _<nombre de la instancia>:<nombre de la clase>_ (ej: diagrama "SequenceBuildingOfBarraca.png")

## Código

### Generalidades

###### ¿Respeta estándares de codificación?
**SI**
* Entregan con 90 warnings de PMD (ver archivo `pmd_report.html` generado al buildear con ant)

###### ¿Está correctamente documentado?
**SI**
* Métodos sin tests (ej: `ConstructionStructure.getActions()`)


**NOTA: 7**