public class Arquero extends Soldado {
    private int flechasDisponibles;

    public Arquero(String nombre, int nivelVida, int flechasDisponibles) {
        super(nombre, nivelVida, 7, 3);
        this.flechasDisponibles = flechasDisponibles;
    }

    @Override
    public void realizarAccionEspecial() {
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
        }
    }
}
