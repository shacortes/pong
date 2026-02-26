package es.cide.programacio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class barresJugadors extends JPanel implements KeyListener{
    public int z = 100;

    public barresJugadors(){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D barraE = (Graphics2D) g;
        barraE.setColor(Color.BLACK); // Defineix el color del cercle
        barraE.fillRect(50, z, 50, 100);
        Graphics2D barraD = (Graphics2D) g;
        barraE.setColor(Color.BLACK); // Defineix el color del cercle
        barraE.fillRect(1870, z, 50, 100);
    }
}
