package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen

    private final int MAXROW = 7;
    private final int MAXCOL = 8;
    private final int SCALE = 60;
    private final int marginleft = 50;
    private final int margintop = 150;
    private int [][] field = new int[MAXROW][MAXCOL];
    Robot robot = new Robot(MAXROW,MAXCOL);

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        fill(0, 102, 153);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        deleteAll();

        text("Susi - the little robot",10,40,50);
        text("<F> ... 1 Schritte vorwärts, <L> ... Drehe nach links, <M> ... ändere Modus",10,60);

        drawGride();

        drawRobot(robot);



    }

    private void drawGride() {
        // Horizontale Linien zeichnen
        for (int r = 0; r < MAXROW + 1; r++) {
            line(marginleft, margintop  + r * SCALE, marginleft + MAXCOL * SCALE, margintop + r * SCALE);
        }

        // Vertikale Linien zeichnen
        for (int c = 0; c < MAXCOL + 1; c++) {
            line(marginleft + c * SCALE,margintop, marginleft + c * SCALE, margintop + MAXROW * SCALE);
        }

    }


    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {
        ellipse(robot.getX()* SCALE + marginleft + SCALE/2, robot.getY()*SCALE + margintop +SCALE/2, SCALE-5, SCALE-5);
        fill(50);
        if(robot.getModi()){
            text("T",robot.getX()* SCALE + marginleft + SCALE/2 + robot.getModiX(),robot.getY()*SCALE + margintop + robot.getModiY());
            fill(0, 102, 153);
        }else{
            text("R",robot.getX()* SCALE + marginleft + SCALE/2 + robot.getModiX(),robot.getY()*SCALE + margintop + robot.getModiY());
            fill(0, 102, 153);
        }

    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(255);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();
            System.out.println();

        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }else if (key == 'm' || key == 'M'){
            if (robot.getModi()){
                robot.setModi(false);
                text("T",robot.getX()* SCALE + marginleft + SCALE/2,robot.getY()*SCALE + margintop +SCALE/2);
            }else{
                robot.setModi(true);
                text("M",robot.getX()* SCALE + marginleft + SCALE/2,robot.getY()*SCALE + margintop +SCALE/2);
            }
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}