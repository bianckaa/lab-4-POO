public class ModoRadio {
    private boolean estado;
    private int volumen;
    private String frecuencia = "FM";
    private double emisoraActual;
    private double[] emisorasGuardadas = new double[50];

    //Método para encender el radio
    public void encender() {
        estado = true;
    }
    //Método para apagar el radio
    public void apagar() {
        estado = false;
    }

    // Método para cambiar el volumen del radio y se asegura de que el volumen no sea menor a 0
    public void cambiarVolumen(int nivel) {
        if (estado) {
            volumen = Math.max(0, volumen + nivel);
        }
    }
    // Método para cambiar entre las frecuencias AM y FM
    public void cambiarFrecuencia() {
        if (estado) {
            frecuencia = frecuencia.equals("FM") ? "AM" : "FM";
        }
    }

    // Método para cambiar la emisora actual, dado un valor de frecuencia
    public void cambiarEmisora(double frecuencia) {
        if (estado) {
            emisoraActual = frecuencia;
        }
    }

    // Método para guardar la emisora actual en el array de emisoras guardadas
    public void guardarEmisora(double frecuencia) {
        for (int i = 0; i < emisorasGuardadas.length; i++) {
            if (emisorasGuardadas[i] == 0) {
                emisorasGuardadas[i] = frecuencia;
                break;
            }
        }
    }

    // Método para cargar una emisora guardada desde una posición específica
    public void cargarEmisora(int posicion) {
        if (estado && posicion < emisorasGuardadas.length) {
            emisoraActual = emisorasGuardadas[posicion];
        }
    }

    // Getters para que el Main pueda acceder a la frecuencia y emisora actual
    public String getFrecuencia() {
        return frecuencia;
    }

    public double getEmisoraActual() {
        return emisoraActual;
    }
}
