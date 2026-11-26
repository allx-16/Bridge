package Bridge;

public class Main {
    public static void main(String[] args) {
        // Combinación 1: Control básico con Radio
        System.out.println("=== Control Básico con Radio ===");
        ControlRemoto control1 = new ControlRemotoBasico(new Radio());
        probarControlRemoto(control1);

        // Combinación 2: Control avanzado con TV
        System.out.println("\n=== Control Avanzado con TV ===");
        ControlRemotoAvanzado control2 = new ControlRemotoAvanzado(new TV());
        probarControlRemoto(control2);
        control2.mute(); // Funcionalidad exclusiva del control avanzado

        // Combinación 3: Control básico con TV
        System.out.println("\n=== Control Básico con TV ===");
        ControlRemoto control3 = new ControlRemotoBasico(new TV());
        probarControlRemoto(control3);

        // Combinación 4: Control avanzado con Radio
        System.out.println("\n=== Control Avanzado con Radio ===");
        ControlRemotoAvanzado control4 = new ControlRemotoAvanzado(new Radio());
        probarControlRemoto(control4);
        control4.record();

        // Extensión: nuevo dispositivo (Projector) con un control existente
        System.out.println("\n=== Control Básico con Proyector ===");
        Dispositivo proyector = new Projector();
        ControlRemoto control5 = new ControlRemotoBasico(proyector);
        probarControlRemoto(control5);
        proyector.printStatus();

        // Extensión: nuevo control (voz) con un dispositivo existente
        System.out.println("\n=== Control de Voz con TV ===");
        TV tv = new TV();
        ControlRemotoVoz control6 = new ControlRemotoVoz(tv);
        control6.comando("Enciende la tele");
        control6.comando("Sube el volumen");
        control6.comando("Canal siguiente");
        control6.comando("Pon música");
        tv.printStatus();
    }

    public static void probarControlRemoto(ControlRemoto control) {
        control.togglePower(); // Encender
        control.volumeUp();
        control.channelUp();
        control.volumeDown();
        control.togglePower(); // Apagar
    }
}
