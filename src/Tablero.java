public class Tablero {
    private Soldado[][] celdas;

    public Tablero(int filas, int columnas) {
        celdas = new Soldado[filas][columnas];
    }

    public boolean colocarSoldado(Soldado soldado, int fila, int columna) {
        if (celdas[fila][columna] == null) {
            celdas[fila][columna] = soldado;
            return true;
        }
        return false;
    }

    public boolean moverSoldado(int fila, int columna, String direccion) {
        if (celdas[fila][columna] == null) return false;
        int[] nuevaPos = calcularNuevaPosicion(fila, columna, direccion);
        int nuevaFila = nuevaPos[0], nuevaColumna = nuevaPos[1];

        if (nuevaFila < 0 || nuevaFila >= celdas.length || nuevaColumna < 0 || nuevaColumna >= celdas[0].length) {
            return false;
        }

        if (celdas[nuevaFila][nuevaColumna] != null) {
            Soldado ganador = batallar(celdas[fila][columna], celdas[nuevaFila][nuevaColumna]);
            celdas[nuevaFila][nuevaColumna] = ganador;
        } else {
            celdas[nuevaFila][nuevaColumna] = celdas[fila][columna];
        }
        celdas[fila][columna] = null;
        return true;
    }

    public void mostrar() {
        for (Soldado[] fila : celdas) {
            for (Soldado celda : fila) {
                System.out.print(celda == null ? " _ " : " " + celda.getRepresentacion() + " ");
            }
            System.out.println();
        }
    }

    private int[] calcularNuevaPosicion(int fila, int columna, String direccion) {
        switch (direccion.toLowerCase()) {
            case "arriba": return new int[]{fila - 1, columna};
            case "abajo": return new int[]{fila + 1, columna};
            case "izquierda": return new int[]{fila, columna - 1};
            case "derecha": return new int[]{fila, columna + 1};
        }
        return new int[]{fila, columna};
    }

    private Soldado batallar(Soldado s1, Soldado s2) {
        double probabilidad1 = (double) s1.getNivelVida() / (s1.getNivelVida() + s2.getNivelVida());
        return Math.random() < probabilidad1 ? s1 : s2;
    }
}
