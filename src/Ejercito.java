import java.util.ArrayList;

public class Ejercito {
    private String reino;
    private ArrayList<Soldado> soldados;

    public Ejercito(String reino, Tablero tablero, String tipoTerritorio) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
        generarSoldados(tablero, tipoTerritorio);
    }

    private void generarSoldados(Tablero tablero, String tipoTerritorio) {
        int cantidadSoldados = (int) (Math.random() * 10) + 1; // Entre 1 y 10 soldados
        for (int i = 0; i < cantidadSoldados; i++) {
            Soldado soldado;
            String tipoSoldado = generarTipoSoldado();
            String nombre = tipoSoldado + this.reino + "X" + (i + 1);
            int fila, columna;
    
            switch (tipoSoldado) {
                case "Espadachin":
                    soldado = new Espadachin(nombre, generarValor(8, 10), 10, 8, generarValor(80, 120));
                    break;
                case "Arquero":
                    soldado = new Arquero(nombre, generarValor(3, 5), 7, 3, generarValor(10, 20));
                    break;
                case "Caballero":
                    soldado = new Caballero(nombre, generarValor(10, 12), 13, 7);
                    break;
                case "Lancero":
                    soldado = new Lancero(nombre, generarValor(5, 8), 5, 10, generarValor(150, 200));
                    break;
                default:
                    continue;
            }
    
            // Buscar posición válida en el tablero
            do {
                fila = (int) (Math.random() * tablero.getFilas());
                columna = (int) (Math.random() * tablero.getColumnas());
            } while (!tablero.colocarSoldado(soldado, fila, columna));
    
            soldados.add(soldado);
        }
    
        // Aplicar bonus según el tipo de territorio
        if (esTerritorioFavorito(tipoTerritorio)) {
            for (Soldado s : soldados) {
                s.nivelVida += 1;
            }
        }
    }
    
    private String generarTipoSoldado() {
        String[] tipos = {"Espadachin", "Arquero", "Caballero", "Lancero"};
        return tipos[(int) (Math.random() * tipos.length)];
    }
    
    private int generarValor(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
    private boolean esTerritorioFavorito(String tipoTerritorio) {
        switch (reino) {
            case "Inglaterra":
            case "Sacro Imperio Romano Germánico":
                return tipoTerritorio.equals("bosque") || tipoTerritorio.equals("playa") || tipoTerritorio.equals("campo abierto");
            case "Francia":
                return tipoTerritorio.equals("campo abierto");
            case "Castilla-Aragon":
                return tipoTerritorio.equals("montaña");
            case "Moros":
                return tipoTerritorio.equals("desierto");
            default:
                return false;
        }
    }
    

    public boolean estaVacio() {
        return soldados.isEmpty();
    }

    public String getReino() {
        return reino;
    }
}

