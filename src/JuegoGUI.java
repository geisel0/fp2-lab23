import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoGUI extends JFrame {
    private Tablero tablero;
    private Ejercito ejercito1;
    private Ejercito ejercito2;
    private JTextArea areaEstado;

    public JuegoEstrategiaGUI() {
        setTitle("Juego de Estrategia");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tablero = new Tablero(10, 10);
        ejercito1 = new Ejercito("Inglaterra", tablero, "bosque");
        ejercito2 = new Ejercito("Francia", tablero, "campo abierto");

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelControles = new JPanel(new GridLayout(3, 2));
        areaEstado = new JTextArea(10, 50);
        areaEstado.setEditable(false);
        JScrollPane scrollEstado = new JScrollPane(areaEstado);

        JButton btnMover = new JButton("Mover Soldado");
        JButton btnMostrar = new JButton("Mostrar Tablero");

        JComboBox<String> direccionCombo = new JComboBox<>(new String[]{"Arriba", "Abajo", "Izquierda", "Derecha"});
        JTextField coordenadasTexto = new JTextField();

        panelControles.add(new JLabel("Coordenadas:"));
        panelControles.add(coordenadasTexto);
        panelControles.add(new JLabel("Direccion:"));
        panelControles.add(direccionCombo);
        panelControles.add(btnMover);
        panelControles.add(btnMostrar);

        panelPrincipal.add(panelControles, BorderLayout.NORTH);
        panelPrincipal.add(scrollEstado, BorderLayout.CENTER);

        add(panelPrincipal, BorderLayout.CENTER);
    }
}