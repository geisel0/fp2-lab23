public class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin(String nombre, int nivelVida, int longitudEspada) {
        super(nombre, nivelVida, 10, 8);
        this.longitudEspada = longitudEspada;
    }

    @Override
    public void realizarAccionEspecial() {
        nivelDefensa += 2;
    }
}
