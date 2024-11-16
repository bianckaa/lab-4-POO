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

    private static void mostrarModoRadio(Scanner scanner, ModoRadio radio) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║            Modo Radio                 ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  1. Cambiar frecuencia (AM/FM)        ║");
        System.out.println("║  2. Cambiar emisora                  ║");
        System.out.println("║  3. Guardar emisora                  ║");
        System.out.println("║  4. Cargar emisora guardada          ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");

        int opcionRadio = scanner.nextInt();
        switch (opcionRadio) {
            case 1:
                radio.cambiarFrecuencia();
                System.out.println("Frecuencia cambiada a: " + radio.getFrecuencia());
                break;
            case 2:
                System.out.print("Ingrese la nueva frecuencia: ");
                double frecuencia = scanner.nextDouble();
                radio.cambiarEmisora(frecuencia);
                System.out.println("Emisora cambiada a: " + frecuencia);
                break;
            case 3:
                radio.guardarEmisora(radio.getEmisoraActual());
                System.out.println("Emisora guardada.");
                break;
            case 4:
                System.out.print("Ingrese la posición de la emisora guardada: ");
                int posicion = scanner.nextInt();
                radio.cargarEmisora(posicion);
                System.out.println("Emisora cargada desde la posición " + posicion);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void mostrarModoReproduccion(Scanner scanner, ModoReproduccion reproduccion) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        Modo Reproducción              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  1. Seleccionar lista de reproducción ║");
        System.out.println("║  2. Cambiar canción (adelante/atrás)  ║");
        System.out.println("║  3. Escuchar canción actual          ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");        
        int opcionReproduccion = scanner.nextInt();

        switch (opcionReproduccion) {
            case 1:
                String[] lista = {"Cancion1", "Cancion2", "Cancion3"};
                reproduccion.seleccionarLista(lista);
                System.out.println("Lista de reproducción seleccionada.");
                break;
            case 2:
                System.out.print("Ingrese dirección ('adelante' o 'atrás'): ");
                String direccion = scanner.next();
                reproduccion.cambiarCancion(direccion);
                System.out.println("Canción cambiada.");
                break;
            case 3:
                reproduccion.escucharCancion();
                System.out.println("Escuchando canción: " + reproduccion.getCancionActual());
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void mostrarModoTelefono(Scanner scanner, ModoTelefono telefono) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║           Modo Teléfono               ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  1. Conectar teléfono                 ║");
        System.out.println("║  2. Desconectar teléfono              ║");
        System.out.println("║  3. Mostrar contactos                 ║");
        System.out.println("║  4. Llamar a un contacto              ║");
        System.out.println("║  5. Finalizar llamada                 ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");

        int opcionTelefono = scanner.nextInt();
        switch (opcionTelefono) {
            case 1:
                telefono.conectarTelefono();
                System.out.println("Teléfono conectado.");
                break;
            case 2:
                telefono.desconectarTelefono();
                System.out.println("Teléfono desconectado.");
                break;
            case 3:
                telefono.mostrarContactos();
                break;
            case 4:
                System.out.print("Ingrese el nombre del contacto: ");
                String nombreContacto = scanner.next();
                telefono.llamarContacto(nombreContacto);
                System.out.println("Llamando a " + nombreContacto);
                break;
            case 5:
                telefono.finalizarLlamada();
                System.out.println("Llamada finalizada.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void mostrarModoProductividad(Scanner scanner, ModoProductividad productividad) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        Modo Productividad             ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  1. Ver pronóstico del tiempo        ║");
        System.out.println("║  2. Activar modo espera              ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");

        int opcionProductividad = scanner.nextInt();
        switch (opcionProductividad) {
            case 1:
                productividad.verPronostico();
                break;
            case 2:
                productividad.modoEspera();
                break;
            default:
                System.out.println("Opción no válida.");
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
