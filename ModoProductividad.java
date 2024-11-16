import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ModoProductividad implements InterfaceCarC{
    private ArrayList<String> pronosticos;

    public ModoProductividad() {
        pronosticos = new ArrayList<>();
        cargarPronosticos();
    }

    private void cargarPronosticos() {
        try (BufferedReader br = new BufferedReader(new FileReader("pronostico.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                pronosticos.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores en el archivo
        }
    }

    @Override
    public void modoEspera() {
        // Esta lógica se manejará desde Main
    }

    @Override
    public String verPronostico() {
        Random random = new Random();
        return pronosticos.get(random.nextInt(pronosticos.size()));
    }
}
