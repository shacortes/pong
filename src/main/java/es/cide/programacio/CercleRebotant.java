package es.cide.programacio;

import java.awt.Color;
import java.awt.Font;
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

public class CercleRebotant extends JPanel implements ActionListener, KeyListener {
    private int x = 50, y = 50;
    private int dx = 2, dy = 2;
    private final int RADI = 20;
    private final int DELAY = 10;
    private Timer timer;

    private Barra barraE, barraD;
    private static final int VELOCITAT_BARRA = 10;
    private static final int MARGE_BARRA = 50;
    private int puntuacioE = 0;
    private int puntuacioD = 0;
    private boolean amuntE, avallE, amuntD, avallD;
    public CercleRebotant() {
        setBackground(Color.WHITE);
        timer = new Timer(DELAY, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);

        barraE = new Barra(50, 50, 100, Color.BLACK, true);
        barraD = new Barra(50, 50, 100, Color.BLACK, false);
    }

    private void actualitzarPosicioBarres() {
        int ample = getWidth();
        if (ample > 0) {
            barraE.actualitzarPosicioX(ample, MARGE_BARRA);
            barraD.actualitzarPosicioX(ample, MARGE_BARRA);
        }
    }

    private void resetPilota() {
        x = getWidth() / 2 - RADI;
        y = getHeight() / 2 - RADI;
        dx = -dx;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, RADI * 2, RADI * 2);

        barraE.dibuixar(g2d);
        barraD.dibuixar(g2d);
        Graphics2D puntuacio = (Graphics2D) g;
        puntuacio.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 48));
        String marcador = puntuacioE + " - " + puntuacioD;
        int ampleText = g2d.getFontMetrics().stringWidth(marcador);
        g2d.drawString(marcador, (getWidth() - ampleText) / 2, 60); //En mig (dividim s'amplada per sa meitat) i a 60 px des de dalt.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (y <= 0 || y + 2 * RADI >= getHeight()) {
            dy = -dy;
        }

        if (dx < 0 &&
                x <= barraE.getX() + barraE.getAmple() &&
                x + 2 * RADI >= barraE.getX() &&
                y + 2 * RADI >= barraE.getY() &&
                y <= barraE.getY() + barraE.getAltura()) {

            dx = -dx;
        }

        if (dx > 0 &&
                x + 2 * RADI >= barraD.getX() &&
                x <= barraD.getX() + barraD.getAmple() &&
                y + 2 * RADI >= barraD.getY() &&
                y <= barraD.getY() + barraD.getAltura()) {

            dx = -dx;

        }

        if (x <= 0) {
            puntuacioD++;
            resetPilota();
        } else if (x + 2 * RADI >= getWidth()) {
            puntuacioE++;
            resetPilota();
        }

        if (x > 0 && x + 2 * RADI < getWidth()) {
            x += dx;
            y += dy;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int altPanell = getHeight();

        if (key == KeyEvent.VK_W) {
            barraE.moure(-VELOCITAT_BARRA, altPanell);
        } else if (key == KeyEvent.VK_S) {
            barraE.moure(VELOCITAT_BARRA, altPanell);
        }
        if (key == KeyEvent.VK_UP) {
            barraD.moure(-VELOCITAT_BARRA, altPanell);
        } else if (key == KeyEvent.VK_DOWN) {
            barraD.moure(VELOCITAT_BARRA, altPanell);
        }
        repaint();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        actualitzarPosicioBarres();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pong");
            CercleRebotant panel = new CercleRebotant();
            frame.add(panel);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}