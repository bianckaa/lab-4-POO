import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModoRadio radio = new ModoRadio();
        ModoReproduccion reproduccion = new ModoReproduccion();
        ModoTelefono telefono = new ModoTelefono();
        ModoProductividad productividad = new ModoProductividad();
        Climatizacion climatizacion = new Climatizacion();
        Scanner scanner = new Scanner(System.in);

        boolean encendido = false;
        int opcion = -1; // Inicializamos con un valor distinto de 0 para entrar en el bucle

        while (opcion != 0) {
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║                Radio                  ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║  1. Encender Radio                    ║");
            if (encendido) {
                System.out.println("║  2. Apagar Radio                      ║");
                System.out.println("║  3. Cambiar Volumen                   ║");
                System.out.println("║  4. Modo Radio                        ║");
                System.out.println("║  5. Modo Reproducción                 ║");
                System.out.println("║  6. Modo Teléfono                     ║");
                System.out.println("║  7. Modo Productividad                ║");
                System.out.println("║  8. Ajustar Climatización             ║");
            }
            System.out.println("║  0. Salir                             ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (!encendido) {
                        encendido = true;
                        radio.encender();
                        System.out.println("Encendiendo Radio...");
                    } else {
                        System.out.println("El radio ya está encendido.");
                    }
                    break;
                case 2:
                    if (encendido) {
                        encendido = false;
                        radio.apagar();
                        System.out.println("Radio apagado.");
                    } else {
                        System.out.println("El radio ya está apagado.");
                    }
                    break;
                case 3:
                    if (encendido) {
                        System.out.print("Ingrese el nivel de volumen (+1 o -1): ");
                        int volumen = scanner.nextInt();
                        radio.cambiarVolumen(volumen);
                        System.out.println("Volumen ajustado.");
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 4:
                    if (encendido) {
                        mostrarModoRadio(scanner, radio);
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 5:
                    if (encendido) {
                        mostrarModoReproduccion(scanner, reproduccion);
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 6:
                    if (encendido) {
                        mostrarModoTelefono(scanner, telefono);
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 7:
                    if (encendido) {
                        mostrarModoProductividad(scanner, productividad);
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 8:
                    if (encendido) {
                        mostrarClimatizacion(scanner, climatizacion);
                    } else {
                        System.out.println("El radio está apagado.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarClimatizacion(Scanner scanner, Climatizacion climatizacion) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║     Ajustes de Climatización          ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  1. Ajustar temperatura               ║");
        System.out.println("║  2. Cambiar modo de ventilación       ║");
        System.out.println("║  3. Activar/desactivar aire acondicionado ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");

        int opcionClima = scanner.nextInt();
        switch (opcionClima) {
            case 1:
                System.out.print("Ingrese la temperatura deseada: ");
                int temperatura = scanner.nextInt();
                climatizacion.ajustarTemperatura(temperatura);
                System.out.println("Temperatura ajustada a " + temperatura + "°C");
                break;
            case 2:
                System.out.print("Ingrese el modo de ventilación (ej. 'Auto', 'Manual'): ");
                String modo = scanner.next();
                climatizacion.cambiarModoVentilacion(modo);
                System.out.println("Modo de ventilación cambiado a: " + modo);
                break;
            case 3:
                climatizacion.isAireAcondicionado();
                String estadoAC = climatizacion.isAireAcondicionado() ? "encendido" : "apagado";
                System.out.println("Aire acondicionado " + estadoAC + ".");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
