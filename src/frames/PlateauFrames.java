package frames;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import managers.GameManager;
import plateau_tools.ButtonCard;

public class PlateauFrames extends JFrame implements ActionListener {
    
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

            curButton.addActionListener(this);
            System.out.println(curButton.getButtonId());
            curButton.setPreferredSize(new Dimension(150, 150));
            gridPanel.add(curButton);
        }

        return gridPanel;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        ButtonCard curBC = (ButtonCard) e.getSource();
        curBC.fliped();
        System.out.println(curBC.getButtonId());
    }

    public void flipCard(ButtonCard cardbutton){
        for (ButtonCard curButton : this.buttonList) {
            if(curButton.getButtonId() == cardbutton.getButtonId()){
                curButton.fliped();
            }
        }
    }

    public void updatePlateau(){
        this.getContentPane().removeAll();
        layoutAssembly(scorePanel, plateauPanel);
    }

    public ArrayList<ButtonCard> getButtonList() {
        return buttonList;
    }

    public void setScorePanel(ScorePannel scorePanel) {
        this.scorePanel = scorePanel;
        updatePlateau();
    }
}
