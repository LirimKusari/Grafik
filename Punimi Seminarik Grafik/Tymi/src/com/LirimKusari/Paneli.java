package com.LirimKusari;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Paneli extends JPanel {

    int madhesiaEGrimcave;
    int gjatesiaX;
    int gjeresiaY;
    int numriIGrimcave= 1500;
    //Qikjo osht foto per backgorund veq boje resize sa osht width edhe height qe met tfit.
    BufferedImage backGround;


    public Paneli(int x, int y,int madhesiaEGrimcave) {
        this.madhesiaEGrimcave=madhesiaEGrimcave;
        gjatesiaX = x;
        gjeresiaY = y;

        try {
            //Qitu kqyr nese ki naj problem me path ndroje
            backGround = ImageIO.read(new File("src/com/LirimKusari/fireplace.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ngjyrat e ndrryshme qe mujin me dal pi tymit
    ArrayList <Color> ngjyrat = new ArrayList<Color>();

    //Lista qe i ruan grimcat
    ArrayList<Grimcat> grimcat = new ArrayList<Grimcat>();
    int numri = 0;

//====================================================================================================================================================================================

    public void paintComponent(Graphics g) {



        //gjyrat e tymit
        ngjyrat.add(new Color(40,40,40,150));
        ngjyrat.add(new Color(51,45,21,120));
        ngjyrat.add(new Color(140,120,20,120));
        ngjyrat.add(new Color(180,60,40,150));
        ngjyrat.add(new Color(80,80,80,120));

//        ngjyrat.add(new Color(60,60,60,50));
//        ngjyrat.add(new Color(100,100,100,50));
//        ngjyrat.add(new Color(140,140,140,50));
//        ngjyrat.add(new Color(180,180,180,50));
//        ngjyrat.add(new Color(222,220,220,50));

        //qitu e bon paint
        g.drawImage(backGround,0,0,null);


        // i vizaton deri en x(numriIGrimcave) grimca
        while (numri < numriIGrimcave) {
            // gjen poziten e mausit dhe e jep si piknisje te grices, masnej qat pozit e ndrron kapak metoda leviz derisa tqelyhet grimca
            PointerInfo m = MouseInfo.getPointerInfo();
            Point p = m.getLocation();
            int mausiX = (int) p.getX();
            int mausiY = (int) p.getY();
            //krijon 1 grimc
            Grimcat grimca = new Grimcat( zgjedhNgjyren(),mausiX,mausiY, (Graphics) g, madhesiaEGrimcave);
            grimcat.add(grimca);
            numri++;
        }


        for (int i = 0; i < grimcat.size(); i++) {
            // metoda e i hek dikur grimcat
            if (grimcat.get(i).numIVizatimeve>20+(int)(Math.random()*20)) {
                grimcat.remove(i);
                numri--;
            }
            // e mbron mes me dal lista out of bound
            if (i < grimcat.size() - 1) {
                grimcat.get(i).leviz();
                grimcat.get(i).vizatoGrimcen(g);

            }
        }
        repaint(10000);
    }
//====================================================================================================================================================================================

    // e zgedh ni ngjyr en array t'ngjyrave
    private Color zgjedhNgjyren(){
        int randome = (int)(Math.random()*100);
        // ngjyra e kaft
        int numINgjyres=0;

        if (randome>=50 && randome<88){
            // ngjyra e hirt e mshel
            numINgjyres =1;
        }else if (randome>=80 && randome<90){
            //e hint e qel
            numINgjyres =2;
        }else if(randome>=90 && randome<96) {
            // e verdh en tportokallt
            numINgjyres =3;
        }else{
            // e portokallt en t'kuqe
            numINgjyres =4;

        }
        return ngjyrat.get(numINgjyres);
    }
}


