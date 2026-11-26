package Bridge;

/**
 * Ejercicio de extensión: control que responde a comandos de voz.
 * Es una nueva abstracción refinada; funciona con cualquier Dispositivo
 * sin modificar las clases de dispositivos.
 */
public class ControlRemotoVoz extends ControlRemoto {
    public ControlRemotoVoz(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void comando(String texto) {
        System.out.println("Control de Voz: \"" + texto + "\"");
        String c = texto.toLowerCase();
        if (c.contains("enciende") || c.contains("apaga")) {
            togglePower();
        } else if (c.contains("sube")) {
            volumeUp();
        } else if (c.contains("baja")) {
            volumeDown();
        } else if (c.contains("siguiente")) {
            channelUp();
        } else if (c.contains("anterior")) {
            channelDown();
        } else {
            System.out.println("Control de Voz: comando no reconocido");
        }
    }

    @Override
    public void togglePower() {
        if (dispositivo.isEnabled()) {
            dispositivo.disable();
        } else {
            dispositivo.enable();
        }
    }

    @Override
    public void volumeDown() {
        dispositivo.setVolume(dispositivo.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        dispositivo.setVolume(dispositivo.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        dispositivo.setChannel(dispositivo.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        dispositivo.setChannel(dispositivo.getChannel() + 1);
    }
}
