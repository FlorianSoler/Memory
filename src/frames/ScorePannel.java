package frames;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The ScorePannel class represents a panel that displays the scores and player
 * names in the game.
 */
public class ScorePannel extends JPanel {

    private JLabel pseudo_1_label;
    private JLabel pseudo_2_label;
    private JLabel scoreJ1_label;
    private JLabel scoreJ2_label;

    /**
     * Constructs a new ScorePannel instance with the specified player names.
     * 
     * @param pseudoJ1 The name of player 1.
     * @param pseudoJ2 The name of player 2.
     */
    public ScorePannel(String pseudoJ1, String pseudoJ2) {

        this.pseudo_1_label = new JLabel(pseudoJ1);
        this.pseudo_2_label = new JLabel(pseudoJ2);

        this.scoreJ1_label = new JLabel("0");
        this.scoreJ2_label = new JLabel("0");

        this.pseudo_1_label.setForeground(Color.blue);
        this.pseudo_2_label.setForeground(getForeground());

        this.setLayout(new GridLayout(1, 4));

        this.add(this.pseudo_1_label);
        this.add(this.scoreJ1_label);
        this.add(this.pseudo_2_label);
        this.add(this.scoreJ2_label);

    }

    /**
     * Adds the specified score to the score of player 1.
     * 
     * @param score The score to add.
     */
    public void addScoreJ1(int score) {
        this.scoreJ1_label.setText(Integer.toString(score));
    }

    /**
     * Adds the specified score to the score of player 2.
     * 
     * @param score The score to add.
     */
    public void addScoreJ2(int score) {
        this.scoreJ2_label.setText(Integer.toString(score));
    }

    /**
     * Switches the active player by changing the foreground color of the player
     * labels.
     */
    public void switchPlayer() {
        if (this.pseudo_1_label.getForeground() == Color.blue) {
            this.pseudo_1_label.setForeground(this.pseudo_2_label.getForeground());
            this.pseudo_2_label.setForeground(Color.blue);
        } else {
            this.pseudo_2_label.setForeground(this.pseudo_1_label.getForeground());
            this.pseudo_1_label.setForeground(Color.blue);
        }
    }
}
