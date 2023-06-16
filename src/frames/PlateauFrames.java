package frames;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import managers.GameManager;
import managers.PlateauManager;
import plateau_tools.ButtonCard;

/**
 * The PlateauFrames class represents the main frame that displays the game
 * board and related components.
 */
public class PlateauFrames extends JFrame implements ActionListener {

    private GameManager gameManager;
    private PlateauManager plateauManager;

    private ArrayList<ButtonCard> buttonList;
    private int rows;
    private int cols;

    // top panel
    private JPanel topPanel;

    // panels
    private JPanel scorePanel;
    private JPanel plateauPanel;

    // exit or setting
    private JButton exitButton;

    /**
     * Constructs a new PlateauFrames instance with the specified parameters.
     * 
     * @param gameManager    The GameManager instance.
     * @param plateauManager The PlateauManager instance.
     * @param buttonList     The list of ButtonCard instances representing the game
     *                       buttons.
     * @param scorePanel     The ScorePannel instance for displaying scores.
     * @param row            The number of rows in the game board.
     * @param col            The number of columns in the game board.
     */
    public PlateauFrames(GameManager gameManager, PlateauManager plateauManager, ArrayList<ButtonCard> buttonList,
            ScorePannel scorePanel, int row, int col) {
        System.out.println("PlateauFrame atteint");

        this.gameManager = gameManager;
        this.plateauManager = plateauManager;

        // top panel creation with score and exit
        this.topPanel = new JPanel(new GridLayout(2, 1));
        this.exitButton = new JButton("Exit/Settings");
        this.exitButton.addActionListener(this);
        this.scorePanel = scorePanel;
        this.topPanel.add(this.scorePanel);
        this.topPanel.add(this.exitButton);

        // card panel creation
        this.buttonList = buttonList;
        this.rows = row;
        this.cols = col;
        this.setTitle("Plateau");
        this.plateauPanel = buildPlateau();

        // all panel assembly
        layoutAssembly(this.plateauPanel, this.topPanel);

        System.out.println("PlateauFrame affiché");
    }

    private void layoutAssembly(JPanel plateau, JPanel topPanel) {

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(topPanel);
        this.add(plateau);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Closes the window by dispatching a WINDOW_CLOSING event.
     */
    public void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private JPanel buildPlateau() {

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(this.rows, this.cols));

        for (ButtonCard curButton : buttonList) {

            curButton.addActionListener(this);
            curButton.setPreferredSize(new Dimension(150, 150));
            gridPanel.add(curButton);
        }

        return gridPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (this.buttonList.contains(e.getSource())) {
            this.plateauManager.buttonCardListener((ButtonCard) e.getSource());
        } else if (e.getSource() == this.exitButton) {
            this.gameManager.returnToSettings();
        }
    }

    /**
     * Flips the specified card button.
     * 
     * @param cardbutton The ButtonCard instance representing the card button to
     *                   flip.
     */
    public void flipCard(ButtonCard cardbutton) {
        for (ButtonCard curButton : this.buttonList) {
            if (curButton.getButtonId() == cardbutton.getButtonId()) {
                curButton.fliped();
            }
        }
        this.update(getGraphics());
    }

    /**
     * Updates the game board.
     */
    public void updatePlateau() {
        this.getContentPane().removeAll();
        this.topPanel.add(this.scorePanel);
        this.topPanel.add(this.exitButton);
        layoutAssembly(plateauPanel, topPanel);
    }

    /**
     * Returns the list of ButtonCard instances representing the game buttons.
     * 
     * @return The list of ButtonCard instances.
     */
    public ArrayList<ButtonCard> getButtonList() {
        return buttonList;
    }

    /**
     * Sets the ScorePannel instance for displaying scores.
     * 
     * @param scorePanel The ScorePannel instance.
     */
    public void setScorePanel(JPanel scorePanel) {
        this.scorePanel = scorePanel;
        updatePlateau();
    }
}
