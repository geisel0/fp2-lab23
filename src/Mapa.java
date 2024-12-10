import java.util.ArrayList;

public class Mapa {
    private Tablero tablero;
    private String tipoTerritorio;
    private Ejercito ejercito1;
    private Ejercito ejercito2;

    public Mapa(int filas, int columnas, String tipoTerritorio) {
        this.tablero = new Tablero(filas, columnas);
        this.tipoTerritorio = tipoTerritorio;
    }

    public void generarEjercitos(String reino1, String reino2) {
        this.ejercito1 = new Ejercito(reino1, tablero, tipoTerritorio);
        this.ejercito2 = new Ejercito(reino2, tablero, tipoTerritorio);
    }

    public boolean moverSoldado(int fila, int columna, String direccion) {
        return tablero.moverSoldado(fila, columna, direccion);
    }

    public void mostrarTablero() {
        tablero.mostrar();
    }

    public boolean hayGanador() {
        return ejercito1.estaVacio() || ejercito2.estaVacio();
    }

    public Ejercito getEjercitoGanador() {
        return ejercito1.estaVacio() ? ejercito2 : ejercito1;
    }
}
