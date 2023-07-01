package managers;

/**
 * The GameManager class handles the game logic and manages the settings and plateau.
 */
public class GameManager {
    private SettingsManager settings;
    private PlateauManager plateauManager;

    /**
     * Constructs a new GameManager instance.
     * Initializes the settings and sets up the necessary components.
     */
    public GameManager() {
        this.settings = new SettingsManager(this);
    }

    /**
     * Creates a new plateau based on the current settings.
     * Retrieves values from the view, closes the window, and initializes the PlateauManager.
     */
    public void createPlateau() {
        this.settings.getValuesFromView();
        System.out.println("valeurs récupéré");
        this.settings.closeWindow();
        System.out.println(this.settings.getPseudoJ1() + " , " + this.settings.getPseudoJ2());
        this.plateauManager = new PlateauManager(settings, this);
    }
    
    /**
     * Returns to the settings screen.
     * Closes the plateau window and initializes a new SettingsManager.
     */
    public void returnToSettings() {
        this.plateauManager.closeWindow();
        this.settings = new SettingsManager(this);
    }
}
