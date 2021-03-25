import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entite {
    private int score;
    private String name;

    public Player(Hitbox h, Coordonnee c, String name, int ms) {
        super(h, c, ms);
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScoreByX(int x) {
        this.score += x;
    }

    public void decrementScoreByX(int x) {
        if (this.score <= x) {
            this.score = 0;
        } else {
            this.score -= x;
        }
    }

    public String getName() {
        return this.name;
    }

    public Graphics renderPlayer(Graphics g, int scale) {

        g.drawRect(coords.getX(), coords.getY(), getHitbox().getWidth(), getHitbox().getHeight());

        if (ToStringSelectionPlayer.col == "Rouge") {
            g.setColor(Color.RED);
        } else if (ToStringSelectionPlayer.col == "Jaune") {
            g.setColor(Color.YELLOW);
        } else if (ToStringSelectionPlayer.col == "Bleu") {
            g.setColor(Color.BLUE);
        } else if (ToStringSelectionPlayer.col == "Vert") {
            g.setColor(Color.GREEN);
        } else if (ToStringSelectionPlayer.col == "Noir") {
            g.setColor(Color.BLACK);
        } else if (ToStringSelectionPlayer.col == "Orange") {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.BLACK);
        }

        g.fillRect(coords.getX() * scale, coords.getY() * scale, getHitbox().getWidth() * (scale),
                getHitbox().getHeight() * (scale));

        return g;
    }

}