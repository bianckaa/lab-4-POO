public class Climatizacion implements InterfaceClimatizacion{
    private int temperatura;
    private String modoVentilacion;
    private boolean aireAcondicionado;

    @Override
    public void ajustarTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public void cambiarModoVentilacion(String modo) {
        this.modoVentilacion = modo;
    }

    @Override
    public void activarAireAcondicionado(boolean estado) {
        this.aireAcondicionado = estado;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public String getModoVentilacion() {
        return modoVentilacion;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }
}
