package es.cide.programacio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// Classe que representa un panell on es dibuixa un cercle que rebota
public class CercleRebotant extends JPanel implements ActionListener, KeyListener {
    private JPanel BarresJugador1;
    private int x = 50, y = 50, z = 50; // Coordenades inicials del cercle
    private int dx = 2, dy = 2; // Velocitat del moviment en X i Y
    private final int RADI = 20; // Radi del cercle
    private final int DELAY = 10; // Retard del temporitzador en mil·lisegons
    private Timer timer; // Temporitzador per controlar l'animació

    // Constructor que inicialitza el panell i inicia el temporitzador
    public CercleRebotant() {
        setBackground(Color.WHITE); // Defineix el color de fons del panell
        timer = new Timer(DELAY, this); // Crea el temporitzador amb retard especificat
        timer.start(); // Inicia el temporitzador
    }

    // Mètode per dibuixar el cercle dins del panell
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d.setColor(Color.RED); // Defineix el color del cercle
        g2d.fillOval(x, y, RADI * 2, RADI * 2); // Dibuixa el cercle amb les coordenades i el radi
        Graphics2D barraE = (Graphics2D) g;
        barraE.setColor(Color.BLACK); // Defineix el color del cercle
        barraE.fillRect(z, 100, 50, 100);
    }

    // Mètode que s'executa a cada tic del temporitzador per moure el cercle
    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprova si el cercle toca les vores horitzontals
        if (x + 2 * RADI >= getWidth() || x <= 0) {
            dx = -dx; // Inverteix la direcció horitzontal
        }

        // Comprova si el cercle toca les vores verticals
        if (y + 2 * RADI >= getHeight() || y <= 0) {
            dy = -dy; // Inverteix la direcció vertical
        }

        // Actualitza la posició del cercle
        x += dx;
        y += dy;
        repaint(); // Redibuixa el panell per actualitzar la posició del cercle
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            z = z+100;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            z--;
        }repaint();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            z = z+100;        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            z--;
        }
        repaint();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            z = z+100;        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            z--;
        }repaint();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Mètode principal per iniciar l'aplicació
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cercle Rebotant"); // Crea la finestra
            CercleRebotant panel = new CercleRebotant(); // Crea una instància del panell
            panel.add(new BarresJugador1());
            frame.add(panel); // Afegeix el panell a la finestra

            frame.setSize(1920, 1080); // Defineix la mida de la finestra
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura el tancament de la finestra
            frame.setLocationRelativeTo(null); // Centra la finestra a la pantalla
            frame.setVisible(true); // Mostra la finestra
        });
    }

}
