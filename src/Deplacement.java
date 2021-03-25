import java.awt.Frame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Deplacement extends Frame implements KeyListener {

    int vel; // Vitesse du personnage
    int amplitude;

    final int height = 1180;
    final int width = 660;
    Player p;
    int cpt = 0;
    Stage stage;

    public Deplacement(Stage s) {
        stage = s;
        setSize(1185, 670);
        addKeyListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        p = new Player(new Hitbox(1, 1),
                new Coordonnee(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX(),
                        stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY()),
                ToStringSelectionPlayer.nom, 10);

        vel = stage.scale / 50;
        amplitude = stage.scale;
    }

    // COLLISIONS

    public void CollisionsUp(Player p, int vel, int cpt) {

        if (p.getCoordonnee().getY() <= 0) {
            return;
        } else if ((p.getCoordonnee().getY() > 0) && (p.getCoordonnee().getY() + p.getHitbox().getHeight() < height)) {

            if (stage.stageRep.get(stage.index - 28) instanceof Grass) {

                p.moveUp(1);
                System.out.println("haut");
                stage.index -= 28;

                check_Actual_Bloc();

            } else {
                System.out.println("MUR EN HAUT");
                // COLLISION MUR
            }

        }

    }

    public void CollisionsDown(Player p, int vel, int width) {

        if (p.getCoordonnee().getY() + p.getHitbox().getHeight() >= width) {
        } else if ((p.getCoordonnee().getY() + p.getHitbox().getWidth() < width)) {

            if (stage.stageRep.get(stage.index + 28) instanceof Grass) {

                p.moveDown(1);
                System.out.println("bas");
                stage.index += 28;

                check_Actual_Bloc();

            } else {
                System.out.println("MUR EN BAS");
                return;
                // COLLISION MUR
            }

        }

    }

    public void CollisionsRight(Player p, int vel, int height) {
        if (p.getCoordonnee().getX() + p.getHitbox().getWidth() < 0) {

        } else if ((p.getCoordonnee().getX() + p.getHitbox().getWidth() < width)) {

            if (stage.stageRep.get(stage.index + 1) instanceof Grass) {
                p.moveRight(1);
                System.out.println("droite");
                stage.index += 1;

                check_Actual_Bloc();

            } else {
                System.out.println("MUR A DROITE");
                // COLLISION MUR
            }
        }

    }

    public void CollisionsLeft(Player p, int vel) {
        if (p.getCoordonnee().getX() < 0) {

        } else if ((p.getCoordonnee().getX() > 0)) {

            if (stage.stageRep.get(stage.index - 1) instanceof Grass) {
                p.moveLeft(1);
                System.out.println("gauche");
                stage.index -= 1;

                check_Actual_Bloc();

            } else {
                System.out.println("MUR A GAUCHE");
                // COLLISION MUR
            }

        }

    }

    public String check_Actual_Bloc() {
        String s = new String();
        // Mettre tout ca dans une fonction ?
        if (stage.itemRep.get(stage.index) == null) { // Si aucun item
            s = "";
            return s;
        } else if (stage.itemRep.get(stage.index) instanceof Piece) {
            p.incrementScoreByX(1);
            s = "piece";
            stage.itemRep.set(stage.index, null); // Ramasser une piece
            System.out.println("piece");
            System.out.println("score : " + p.getScore());
            return s;

        } else if (stage.itemRep.get(stage.index) instanceof Piege) {

            p.setCoord(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX(),
                    stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY());

            stage.index = stage.getIndexDepart();
            System.out.println("piege");
            p.decrementScoreByX(p.getScore()); // METTRE LE SCORE A 0
            System.out.println("score : " + p.getScore());
            return "piege";

        } else if (stage.itemRep.get(stage.index) instanceof Flag) {
            // AFFICHER LE NIVEAU SUIVANT
            if (Enchainement.init == 2) {
                Enchainement.TableauScore(p);
                // Enchainement.Stage2();
            } else if (Enchainement.init == 3) {
                Enchainement.Stage3();
            } else if (Enchainement.init == 4) {
                Enchainement.TableauScore(p);
            }
            return "stage";
        } else {
            return "";
        }

    }

    // EVENT

    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        switch (keyCode) {
        case KeyEvent.VK_UP:
            CollisionsUp(p, vel, cpt);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            repaint();
            break;

        case KeyEvent.VK_DOWN:
            CollisionsDown(p, vel, width);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            repaint();
            break;

        case KeyEvent.VK_LEFT:
            CollisionsLeft(p, vel);
            repaint();
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;

        case KeyEvent.VK_RIGHT:
            CollisionsRight(p, vel, height);
            repaint();
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;
        }
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }

}
