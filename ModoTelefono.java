import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ModoTelefono {
    private ArrayList<Contacto> contactos;
    private String contactoActual;

    public ModoTelefono() {
        contactos = new ArrayList<>();
        cargarContactos();
    }

    private void cargarContactos() {
        try (BufferedReader br = new BufferedReader(new FileReader("contactos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    contactos.add(new Contacto(datos[0], datos[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores en el archivo
        }
    }

    public void conectarTelefono() {
        // Implementación futura
    }

    public void desconectarTelefono() {
        // Implementación futura
    }

    public ArrayList<Contacto> obtenerContactos() {
        return contactos;
    }

    public void llamarContacto(String nombreContacto) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombreContacto)) {
                contactoActual = nombreContacto;
                break;
            }
        }
    }

    public void finalizarLlamada() {
        contactoActual = null;
    }

    public String getContactoActual() {
        return contactoActual;
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos disponibles.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos) {
                System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNumero());
            }
        }
    }
}
