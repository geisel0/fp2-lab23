import java.util.Arrays;

public class Tablero {
    private String[][] tablero;

    public Tablero(int filas, int columnas) {
        tablero = new String[filas][columnas];
        for (String[] fila : tablero) {
            Arrays.fill(fila, "_");
        }
    }

    public boolean colocarSoldado(Soldado soldado, int fila, int columna) {
        if (tablero[fila][columna].equals("_")) {
            tablero[fila][columna] = soldado.getNombre();
            return true;
        }
        return false;
    }

    public boolean moverSoldado(int filaActual, int colActual, int nuevaFila, int nuevaColumna) {
        if (tablero[nuevaFila][nuevaColumna].equals("_")) {
            tablero[nuevaFila][nuevaColumna] = tablero[filaActual][colActual];
            tablero[filaActual][colActual] = "_";
            return true;
        }
        return false;
    }

    public boolean estaDentroDelLimite(int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
    }

    public boolean haySoldado(int fila, int columna) {
        return !tablero[fila][columna].equals("_");
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        for (String[] fila : tablero) {
            for (String celda : fila) {
                sb.append(celda).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getFilas() {
        return tablero.length;
    }

    public int getColumnas() {
        return tablero[0].length;
    }
}
