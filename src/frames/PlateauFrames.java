package frames;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.Console;

import managers.GameManager;
import managers.PlateauManager;
import plateau_tools.ButtonCard;

public class PlateauFrames extends JFrame implements ActionListener {
    
    private GameManager gameManager;
    private PlateauManager plateauManager;

    private ArrayList<ButtonCard> buttonList;
    private int rows;
    private int cols;

    //top pannel
    private JPanel topPanel;

    //panels
    private ScorePannel scorePanel;
    private JPanel plateauPanel;

    //exit or setting
    private JButton exitButton;


    public PlateauFrames(GameManager gameManager, PlateauManager plateauManager, ArrayList<ButtonCard> buttonList, ScorePannel scorePanel, int row, int col) {
        System.out.println("PlateauFrame atteint");
        
        this.gameManager = gameManager;
        this.plateauManager = plateauManager;

        //top pannel creation with score and exit
        this.topPanel = new JPanel(new GridLayout(2, 1));
        this.exitButton = new JButton("Exit/Settings");
        this.exitButton.addActionListener(this);
        this.scorePanel = scorePanel;
        this.topPanel.add(this.scorePanel);
        this.topPanel.add(this.exitButton);

        //card pannel creation
        this.buttonList = buttonList;
        this.rows=row;
        this.cols=col;
        this.setTitle("Plateau");
        this.plateauPanel = buildPlateau();
        
        //all pannel assembly
        layoutAssembly(this.plateauPanel, this.topPanel);
        
        System.out.println("PlateauFrame affiché");
    }

    private void layoutAssembly( JPanel plateau, JPanel topPanel){
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(topPanel);
        this.add(plateau);
        this.pack();
        this.setVisible(true);
    }

    public void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    

    private JPanel buildPlateau(){

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(this.rows, this.cols));
        
        for (ButtonCard curButton : buttonList) {

            curButton.addActionListener(this);
            curButton.setPreferredSize(new Dimension(150, 150));
            gridPanel.add(curButton);
        }

        return gridPanel;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (this.buttonList.contains(e.getSource())) {
            this.plateauManager.buttonCardListener((ButtonCard)e.getSource());
        } else if (e.getSource() == this.exitButton){
            this.gameManager.returnToSettings();
        }
    }

    public void flipCard(ButtonCard cardbutton){
        for (ButtonCard curButton : this.buttonList) {
            if(curButton.getButtonId() == cardbutton.getButtonId()){
                curButton.fliped();
            }
        }
        this.update(getGraphics());
    }

    public void updatePlateau(){
        this.getContentPane().removeAll();
        this.topPanel.add(this.scorePanel);
        this.topPanel.add(this.exitButton);
        layoutAssembly(plateauPanel, topPanel);
    }

    public ArrayList<ButtonCard> getButtonList() {
        return buttonList;
    }

    public void setScorePanel(ScorePannel scorePanel) {
        this.scorePanel = scorePanel;
        updatePlateau();
    }
}
