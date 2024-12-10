import java.util.Scanner;

public class Juego {
    private Mapa mapa;
    private Scanner scanner;

    public Juego() {
        this.scanner = new Scanner(System.in);
        this.mapa = new Mapa(10, 10, "bosque"); // Ejemplo: mapa de bosque
    }

    public void iniciar() {
        mapa.generarEjercitos("Moros", "Inglaterra");
        mapa.mostrarTablero();
        while (!mapa.hayGanador()) {
            realizarTurno();
        }
        System.out.println("El ganador es: " + mapa.getEjercitoGanador().getReino());
    }

    private void realizarTurno() {
        System.out.println("Ingrese las coordenadas y direccion de movimiento (fila columna direccion):");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();
        String direccion = scanner.next();

        if (!mapa.moverSoldado(fila, columna, direccion)) {
            System.out.println("Movimiento no valido, intente nuevamente.");
        }

        mapa.mostrarTablero();
    }
}
