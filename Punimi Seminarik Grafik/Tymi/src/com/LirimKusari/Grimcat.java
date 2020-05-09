package com.LirimKusari;

import java.awt.*;


public class Grimcat {

    int madhesiaEGrimcave;
    int x;
    int y;
    int numIVizatimeve = 0;
    Color c;



    public Grimcat(Color c, int x, int y, Graphics g, int madhesiaEGrimcave) {
        this.x = x;
        this.y = y;
        this.madhesiaEGrimcave = madhesiaEGrimcave;
        this.c = c;

        vizatoGrimcen(c, g, x, y);
    }

//===============================================================================================================================================================================
    //vizaton grimcen ne ekran heren e pare nga konstruktori
    private void vizatoGrimcen(Color c, Graphics g, int x, int y) {
        g.setColor(c);
        g.fillOval(x, y, madhesiaEGrimcave, madhesiaEGrimcave);
        numIVizatimeve++;
        if (c.getAlpha() > 15) {
            c = new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha() - 15 );
        }
    }

    //vizaton grimcen ne ekran
    public void vizatoGrimcen(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, madhesiaEGrimcave, madhesiaEGrimcave);
        numIVizatimeve++;
        if (c.getAlpha() > 16) {
            c = new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha() - 15);
        }
    }

//===============================================================================================================================================================================


    // kthen nje int te rendomt nemes min dhe max
    private int randomeInRange(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }

    // zhvendos poziten x dhe y te grimcave
    public void leviz() {
        this.x += randomeInRange(-20, 19);
        this.y += randomeInRange(-30, 12);
    }

//===============================================================================================================================================================================
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
