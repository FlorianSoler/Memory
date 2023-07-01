package managers;

import java.io.File;
import frames.SettingsFrame;

/**
 * The SettingsManager class handles the management of game settings.
 * It provides methods to interact with the settings frame and retrieve the values entered by the user.
 * The settings include player pseudonyms, board size, and theme.
 */
public class SettingsManager {
    private String pseudoJ1; // Player 1 pseudonym
    private String pseudoJ2; // Player 2 pseudonym
    private String taillePlateau; // Board size
    private String theme; // Theme
    private SettingsFrame settingsFrame; // The frame that displays the settings

    /**
     * Constructor for the SettingsManager class.
     * Initializes the settings frame with the game manager and available themes and board sizes.
     *
     * @param gameManager The game manager object.
     */
    public SettingsManager(GameManager gameManager) {
        this.settingsFrame = new SettingsFrame(gameManager, this.getThemes(), this.getTailles());
        this.setVisible(true);
    }

    /**
     * Closes the settings window.
     */
    public void closeWindow() {
        this.settingsFrame.closeWindow();
    }

    /**
     * Retrieves the available themes from the "src/data/Collection" directory.
     *
     * @return An array of available themes.
     */
    private String[] getThemes() {
        // Creating a File object for the directory
        File directoryPath = new File("src/data/Collection");
        // List of all files and directories
        String themes[] = directoryPath.list();
        return themes;
    }

    /**
     * Retrieves the available board sizes.
     *
     * @return An array of available board sizes.
     */
    private String[] getTailles() {
        return new String[]{"4x5", "5x6", "4x4"};
    }

    /**
     * Retrieves the values entered by the user from the settings frame.
     * Updates the corresponding variables in the SettingsManager.
     */
    public void getValuesFromView() {
        this.pseudoJ1 = this.settingsFrame.getPseudoJ1();
        this.pseudoJ2 = this.settingsFrame.getPseudoJ2();
        this.taillePlateau = this.settingsFrame.getTaillePlateau();
        this.theme = this.settingsFrame.getTheme();
    }

    /**
     * Sets the visibility of the settings frame.
     *
     * @param visible true to make the frame visible, false to hide it.
     */
    public void setVisible(boolean visible) {
        this.settingsFrame.setVisible(visible);
    }

    /**
     * Returns the pseudonym of player 1.
     *
     * @return The pseudonym of player 1.
     */
    public String getPseudoJ1() {
        return pseudoJ1;
    }

    /**
     * Returns the pseudonym of player 2.
     *
     * @return The pseudonym of player 2.
     */
    public String getPseudoJ2() {
        return pseudoJ2;
    }

    /**
     * Returns the selected board size.
     *
     * @return The selected board size.
     */
    public String getTaillePlateau() {
        return taillePlateau;
    }

    /**
     * Returns the selected theme.
     *
     * @return The selected theme.
     */
    public String getTheme() {
        return theme;
    }
}
