# Respuestas – Patrón Bridge

## Lo que se implementó

- `Dispositivo` (con `printStatus()`), `Radio` y `TV` completas.
- `ControlRemotoBasico` y `ControlRemotoAvanzado` con todos los métodos; el avanzado agrega `mute()` y `record()`.
- `Main` prueba las cuatro combinaciones control–dispositivo.
- Extensiones: `Projector` (nuevo dispositivo) y `ControlRemotoVoz` (nuevo control con comandos de texto tipo voz). Ninguna de las dos obligó a modificar las clases existentes.

Compilar y ejecutar:

```bash
javac -d out *.java
java -cp out Bridge.Main
```

## Preguntas de análisis

**Explosión de clases.** Sin Bridge, cada combinación sería una clase: 3 controles × 4 dispositivos = **12 clases**. Con Bridge se necesitan 3 + 4 = **7 clases** (más la interfaz `Dispositivo` y la clase abstracta `ControlRemoto`). El crecimiento pasa de multiplicativo a aditivo.

**Acoplamiento.** Si `ControlRemotoBasico` heredara de `Radio`, el control quedaría atado a un único dispositivo: para usarlo con `TV` habría que duplicar la clase. Además, cualquier cambio en `Radio` afectaría al control, y no se podría cambiar de dispositivo en tiempo de ejecución. La herencia crea un acoplamiento fuerte y estático; la composición, uno débil y dinámico.

**Extensibilidad.** Para agregar `Projector` solo se crea una clase que implemente `Dispositivo`. No se modifica ningún control: todos funcionan con el proyector automáticamente (se comprobó en `Main`).

**Principios SOLID.**
- *Inversión de Dependencias:* los controles dependen de la abstracción `Dispositivo`, no de `Radio` o `TV`.
- *Abierto/Cerrado:* se agregan dispositivos o controles nuevos sin modificar los existentes.
- *Responsabilidad Única:* los dispositivos saben cómo funcionan; los controles, cómo se interactúa con ellos.
- *Sustitución de Liskov:* cualquier `Dispositivo` puede usarse donde se espera otro.

**Flexibilidad.** Como el control guarda una referencia a `Dispositivo`, se podría cambiar el dispositivo en tiempo de ejecución (por ejemplo, con un `setDispositivo()`), como un control universal que pasa de la TV a la radio sin crear un objeto nuevo.

## Ejercicios de extensión

- **Projector:** implementado en `Projector.java`.
- **ControlRemotoVoz:** implementado en `ControlRemotoVoz.java`; interpreta frases como "Enciende la tele" o "Sube el volumen".
- **Funcionalidad cruzada:** si algunas funciones solo sirven con ciertos dispositivos (por ejemplo, `record()` solo con TV), se puede definir una interfaz adicional, como `DispositivoGrabable extends Dispositivo` con `grabar()`. El control avanzado comprobaría `if (dispositivo instanceof DispositivoGrabable g)` y, si no lo es, informaría que la función no está disponible. Así la restricción queda en el tipo, sin romper la independencia de las jerarquías.
