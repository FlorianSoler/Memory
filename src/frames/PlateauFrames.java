package frames;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;

import managers.GameManager;
import plateau_tools.ButtonCard;
import plateau_tools.Score;

public class PlateauFrames extends JFrame  {
    
    GameManager gameManager;
    private ArrayList<ButtonCard> buttonList;
    private int rows;
    private int cols;

    //panels
    private ScorePannel scorePanel;
    private JPanel plateauPanel;


    public PlateauFrames(GameManager gameManager, ArrayList<ButtonCard> buttonList, ScorePannel scorePanel, int row, int col) {
        this.buttonList = buttonList;
        this.gameManager = gameManager;
        this.scorePanel = scorePanel;
        this.rows=row;
        this.cols=col;
        this.setTitle("Plateau");
        this.plateauPanel = buildPlateau();
        layoutAssembly(this.scorePanel, this.plateauPanel);
    }

    private void layoutAssembly(JPanel score, JPanel plateau){

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(score);
        this.add(plateau);
        this.pack();
        this.setVisible(true);

    }
    

    private JPanel buildPlateau(){

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(this.rows, this.cols));
        
        for (ButtonCard curButton : buttonList) {
            curButton.fliped();
            System.out.println(curButton.getButtonId());
            curButton.setPreferredSize(new Dimension(200, 200));
            gridPanel.add(curButton);
        }

        return gridPanel;
    }

    private void updatePlateau(){
        this.getContentPane().removeAll();
        layoutAssembly(scorePanel, plateauPanel);
    }

    public void setScorePanel(ScorePannel scorePanel) {
        this.scorePanel = scorePanel;
        updatePlateau();

    }

}
