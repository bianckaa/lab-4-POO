public class ModoReproduccion {
    private String[] listaReproduccion;
    private String cancionActual;
    private String autor;
    private int duracion; // en segundos
    private String genero;
    private int indiceCancionActual;

    // Método para seleccionar una lista de reproducción completa    
    public void seleccionarLista(String[] lista) {
        this.listaReproduccion = lista;
        if (lista.length > 0) {
            indiceCancionActual = 0;
            actualizarCancionActual();
        }
    }

    // Método para cambiar a la siguiente o anterior canción
    public void cambiarCancion(String direccion) {
        if (listaReproduccion != null && listaReproduccion.length > 0) {
            if ("adelante".equals(direccion)) {
                indiceCancionActual = (indiceCancionActual + 1) % listaReproduccion.length;
            } else if ("atras".equals(direccion)) {
                indiceCancionActual = (indiceCancionActual - 1 + listaReproduccion.length) % listaReproduccion.length;
            }
            actualizarCancionActual();
        }
    }

    // Método privado para actualizar la información de la canción actual
    private void actualizarCancionActual() {
        if (listaReproduccion != null && listaReproduccion.length > 0) {
            this.cancionActual = listaReproduccion[indiceCancionActual];
            // Ejemplo: Se deberían asociar los metadatos reales de cada canción.
            // Aquí se ponen valores de ejemplo:
            this.autor = "Autor Desconocido";
            this.duracion = 180; // Ejemplo: 180 segundos (3 minutos)
            this.genero = "Género Desconocido";
        }
    }

    public String getCancionActual() {
        return cancionActual;
    }

    // Método para escuchar la canción actual 
    public void escucharCancion() {
        if (cancionActual != null) {
            System.out.println("Reproduciendo...");
            System.out.println("Canción: " + cancionActual);
            System.out.println("Autor: " + autor);
            System.out.println("Duración: " + duracion + " segundos");
            System.out.println("Género: " + genero);
        } else {
            // Si no hay una canción seleccionada, muestra un mensaje
            System.out.println("No hay ninguna canción seleccionada.");
        }
    }
}
