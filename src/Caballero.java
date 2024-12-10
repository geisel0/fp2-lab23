public class Caballero extends Soldado {
    private boolean montado;

    public Caballero(String nombre, int nivelVida) {
        super(nombre, nivelVida, 13, 7);
        this.montado = true;
    }

    @Override
    public void realizarAccionEspecial() {
        if (montado) {
            nivelAtaque += 5;
        } else {
            nivelDefensa += 3;
        }
    }

    public void alternarMontura() {
        montado = !montado;
        nivelAtaque = montado ? 13 : 10;
    }
}
