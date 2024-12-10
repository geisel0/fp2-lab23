public class Lancero extends Soldado {
    private int longitudLanza;

    public Lancero(String nombre, int nivelVida, int longitudLanza) {
        super(nombre, nivelVida, 5, 10);
        this.longitudLanza = longitudLanza;
    }

    @Override
    public void realizarAccionEspecial() {
        nivelDefensa++;
    }
}
