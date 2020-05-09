package com.LirimKusari;

import javax.swing.*;
import java.awt.*;

public class Korniza extends JFrame {

    int gjatesiaX;
    int gjeresiaY;
    int madhesiaEGrimcave;

    Korniza(int x, int y, int madhesiaEGrimcave) {
        gjatesiaX = x;
        gjeresiaY = y;
        this.madhesiaEGrimcave = madhesiaEGrimcave;
    }

    final String TITULLI = "Simulimi i tymit";


    public void shfaqKornizen() {


        JFrame korniza = new JFrame();
        Paneli paneli = new Paneli(gjatesiaX, gjeresiaY, madhesiaEGrimcave);

        korniza.setVisible(true);
        korniza.setResizable(false);
        //always add this man xD
        korniza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        korniza.getContentPane().add(paneli);
        korniza.setTitle(TITULLI);
        korniza.setSize(gjatesiaX, gjeresiaY);

    }

}
