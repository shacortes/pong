package es.cide.programacio;

import java.awt.Color;
import java.awt.Graphics2D;

public class Barra {
    private int x, y;
    private final int AMPLE, ALTURA;
    private final Color COLOR;
    private int limitInferior; // Per adaptar-se a la pantalla dinàmicament
    private final boolean esEsquerra;

    public Barra(int y, int ample, int altura, Color color, boolean esEsquerra) {
        this.y = y;
        this.AMPLE = ample;
        this.ALTURA = altura;
        this.COLOR = color;
        this.esEsquerra = esEsquerra;
        this.x = -1; // Valor temporal
    }

    public void actualitzarPosicioX(int amplePanell, int marge) {
        if (esEsquerra) {
            this.x = marge;
        } else {
            this.x = amplePanell - marge - AMPLE;
        }
    }
    /** Mou la barra verticalment, respectant els límits de la pantalla */
    public void moure(int dy, int altPanell) {
        y += dy;
        if (y < 0) y = 0;
        if (y + ALTURA > altPanell) y = altPanell - ALTURA;
    }

    /** Dibuixa la barra al Graphics2D */
    public void dibuixar(Graphics2D g2d) {
        g2d.setColor(COLOR);
        g2d.fillRect(x, y, AMPLE, ALTURA);
    }

    // Getters bàsics (si els necessites més endavant)
    public int getY() { return y; }
    public int getAltura() { return ALTURA; }
    public int getX() { return x; }
    public int getAmple() { return AMPLE; }
}