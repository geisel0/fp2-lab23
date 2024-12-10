public abstract class Soldado {
    protected int nivelVida;
    protected int ataque;
    protected int defensa;
    protected String nombre;

    public Soldado(String nombre, int nivelVida, int ataque, int defensa) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public String getRepresentacion() {
        return nombre.charAt(0) + "";
    }
}
