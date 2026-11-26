package Bridge;

public class TV implements Dispositivo {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() { return on; }

    @Override
    public void enable() {
        on = true;
        System.out.println("TV encendida");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV apagada");
    }

    @Override
    public int getVolume() { return volume; }

    @Override
    public void setVolume(int percent) {
        // El volumen se mantiene entre 0 y 100
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("TV: volumen en " + volume + "%");
    }

    @Override
    public int getChannel() { return channel; }

    @Override
    public void setChannel(int channel) {
        // No se permiten canales menores a 1
        this.channel = Math.max(1, channel);
        System.out.println("TV: canal " + this.channel);
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Soy una TV");
        System.out.println("| Estoy " + (on ? "encendido" : "apagado"));
        System.out.println("| Volumen actual: " + volume + "%");
        System.out.println("| Canal actual: " + channel);
        System.out.println("------------------------------------");
    }
}
