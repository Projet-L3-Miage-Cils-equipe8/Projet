import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Enchainement {

    public static int init = 1;

    public static void ChoixPerso() {
        Fenetre fen = new Fenetre("Choix du personnage", 0, 0, 0);
        Texte text = new Texte("<html><center>Choix du personnage", 260, 75, 500, 100, 50, "Cambria");
        fen.add(text);

        Bouton bouton1 = new Bouton("<html><center>Selection du personnage", 400, 450, 200, 60);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SelectionPlayer sp = new SelectionPlayer(null, "Selection personnage", true, fen);
                ToStringSelectionPlayer infoToString = sp.showSelectionPlayer();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, infoToString.toString(), "Selection personnage",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        Bouton bouton2 = new Bouton("<html><center>Retour Page d'accueil", 100, 450, 200, 60);
        fen.panel.add(bouton2);
        fen.setContentPane(fen.panel);
        bouton2.addActionListener(e -> {
            fen.dispose();
        });

        Bouton bouton3 = new Bouton("<html><center>Regles du jeu", 700, 450, 200, 60);
        fen.panel.add(bouton3);
        fen.setContentPane(fen.panel);
        bouton3.addActionListener(e -> {
            fen.dispose();
            RegleJeu();
        });

    }

    public static void RegleJeu() {
        Fenetre fen = new Fenetre("Règle du jeu", 0, 0, 0);
        Texte text = new Texte(
                "<html><center>Voici les regle du jeu :\n \n Le but de ce jeu est d'atteindre le drapeau, en ramassant le maximum de piece, sans percuter des pieges. Il y a deux types de piege :\n Si vous percuter un piege actif, vous recommencer le niveau et votre score retombe a 0. Les pieges inactifs, quant a eux, ils n\'ont aucune repercussion sur vous. Les deux types de pieges sont identiques, et a vous de trouver le bon chemin pour atteindre le drapeau ! ",
                0, 100, 1000, 200, 25, "Cambria");
        fen.add(text);

        Bouton bouton1 = new Bouton("<html><center>Retour", 400, 450, 200, 60);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
            ChoixPerso();
        });
    }

    public static void Stage1() {
        try {
            Stage s = new Stage(new File("../Ressources/Niveau1.txt"), new File("../Ressources/Niveau1_objets.txt"));
            s.toFrame().show();
            init = 2;
        } catch (IOException ioException) {

        }
    }

    public static void Stage2() {
        try {
            Stage s = new Stage(new File("../Ressources/Niveau2.txt"), new File("../Ressources/Niveau2_objets.txt"));
            s.toFrame().show();
            init = 3;
        } catch (IOException ioException) {

        }
    }

    public static void Stage3() {
        try {
            Stage s = new Stage(new File("../Ressources/Niveau3.txt"), new File("../Ressources/Niveau3_objets.txt"));
            s.toFrame().show();
            init = 4;
        } catch (IOException ioException) {

        }
    }

    public static void TableauScore(Player p) {
        Fenetre fen = new Fenetre("Tableau des scores", 0, 0, 0);
        Texte text = new Texte("<html><center>Voici le tableau des scores", 250, 75, 500, 100, 50, "Cambria");
        fen.add(text);

        String resultat = "" + p.getScore();
        Texte text2 = new Texte(resultat, 460, 250, 500, 100, 50, "Cambria");
        fen.add(text2);

        Bouton bouton1 = new Bouton("<html><center>Quitter", 400, 450, 200, 60);
        fen.panel.add(bouton1);
        fen.setContentPane(fen.panel);
        bouton1.addActionListener(e -> {
            fen.dispose();
        });
    }
}
