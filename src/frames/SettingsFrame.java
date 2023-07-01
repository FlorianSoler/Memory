package frames;

import managers.GameManager;

import javax.swing.*;
import java.awt.event.*;

/**
 * The SettingsFrame class represents the settings window of the game.
 * It allows the user to enter player names, select a theme, and choose the size of the game board.
 */
public class SettingsFrame extends JFrame implements ActionListener {

    // inputs
    private JTextField pseudo1_TextField;
    private JTextField pseudo2_TextField;
    private JComboBox theme_comboBox;
    private JComboBox taille_comboBox;

    // buttons
    private JButton validation_button;

    // labels
    // private JLabel Title_label;
    private JLabel pseudo_1_label;
    private JLabel pseudo_2_label;
    private JLabel theme_label;
    private JLabel taille_label;

    // observer
    private GameManager gameManager;

    /**
     * Constructs a new SettingsFrame instance.
     * @param gameManager The game manager instance.
     * @param themes An array of themes for the theme selection.
     * @param tailles An array of sizes for the game board selection.
     */
    public SettingsFrame(GameManager gameManager, String[] themes, String[] tailles) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.gameManager = gameManager;
        this.setTitle("Memory settings");
        this.setSize(340, 340);
        BuildFrame(themes, tailles);
    }

    /**
     * Closes the settings window.
     */
    public void closeWindow() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void BuildFrame(String[] themes, String[] tailles) {

        pseudo_1_label = new JLabel("Pseudo 1:");
        pseudo_1_label.setBounds(10, 10, 100, 30);

        pseudo1_TextField = new JTextField();
        pseudo1_TextField.setBounds(120, 10, 150, 30);

        pseudo_2_label = new JLabel("Pseudo 2:");
        pseudo_2_label.setBounds(10, 50, 100, 30);

        pseudo2_TextField = new JTextField();
        pseudo2_TextField.setBounds(120, 50, 150, 30);

        theme_label = new JLabel("Thème :");
        theme_label.setBounds(10, 90, 100, 30);

        theme_comboBox = new JComboBox<>(themes);
        theme_comboBox.setBounds(120, 90, 150, 30);

        taille_label = new JLabel("Taille :");
        taille_label.setBounds(10, 130, 100, 30);

        taille_comboBox = new JComboBox<>(tailles);
        taille_comboBox.setBounds(120, 130, 150, 30);

        this.validation_button = new JButton("Jouer");
        this.validation_button.setBounds(120, 170, 100, 30);
        this.validation_button.addActionListener(this);

        // Ajout des composants à la fenêtre
        add(pseudo_1_label);
        add(pseudo1_TextField);
        add(pseudo_2_label);
        add(pseudo2_TextField);
        add(theme_label);
        add(theme_comboBox);
        add(taille_comboBox);
        add(taille_label);
        add(validation_button);

        setLayout(null);
    }

    /**
     * Retrieves the name of the first player entered in the text field.
     * @return The name of the first player.
     */
    public String getPseudoJ1() {
        return this.pseudo1_TextField.getText();
    }

    /**
     * Retrieves the name of the second player entered in the text field.
     * @return The name of the second player.
     */
    public String getPseudoJ2() {
        return this.pseudo2_TextField.getText();
    }

    /**
     * Retrieves the selected size of the game board.
     * @return The selected size of the game board.
     */
    public String getTaillePlateau() {
        return this.taille_comboBox.getSelectedItem().toString();
    }

    /**
     * Retrieves the selected theme.
     * @return The selected theme.
     */
    public String getTheme() {
        return this.theme_comboBox.getSelectedItem().toString();
    }

    /**
     * Handles the action performed event.
     * @param e The ActionEvent object.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.validation_button) {
            this.gameManager.createPlateau();
        }
    }

}
