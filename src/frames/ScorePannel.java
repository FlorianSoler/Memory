package frames;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePannel extends JPanel {
    
    private JLabel pseudo_1_label;
    private JLabel pseudo_2_label;
    private JLabel scoreJ1_label;
    private JLabel scoreJ2_label;

    public ScorePannel(String pseudoJ1, String pseudoJ2) {

        this.pseudo_1_label = new JLabel(pseudoJ1);
        this.pseudo_2_label = new JLabel(pseudoJ2);
        
        this.scoreJ1_label = new JLabel("0");
        this.scoreJ2_label = new JLabel("0");

        this.pseudo_1_label.setBackground(Color.blue);
        this.pseudo_2_label.setBackground(getBackground());

        this.setLayout(new GridLayout(1, 4));

        this.add(this.pseudo_1_label);
        this.add(this.scoreJ1_label);
        this.add(this.pseudo_2_label);
        this.add(this.scoreJ2_label);
        
    }

    public void addScoreJ1(int score) {
        this.scoreJ1_label.setText(Integer.toString(score));
    }

    public void addScoreJ2(int score) {
        this.scoreJ2_label.setText(Integer.toString(score));
    }

    public void switchPlayer() {
        if(this.pseudo_1_label.getBackground() == Color.blue){
            this.pseudo_1_label.setBackground(this.pseudo_2_label.getBackground());
            this.pseudo_2_label.setBackground(Color.blue);
        } else {
            this.pseudo_2_label.setBackground(this.pseudo_1_label.getBackground());
            this.pseudo_1_label.setBackground(Color.blue);
        }
    }

    
}
