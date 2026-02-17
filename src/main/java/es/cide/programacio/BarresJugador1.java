package es.cide.programacio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class BarresJugador1 extends JPanel implements KeyListener{
    
    public BarresJugador1(){
        this.setSize(20, 20);

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d1 = (Graphics2D) g; // Conversió a Graphics2D per millorar el dibuix
        g2d1.setColor(Color.BLACK); // Defineix el color del cercle
        g2d1.fillRect(100, 50, 0, 0);
    }
}
