package managers;
import plateau_tools.*;
import frames.*;



public class PlateauManager {
    
    // Score score;
    private Card lastCard;
    private SettingsManager settings;
    private PlateauFrames plateauFrames;
    private GameManager gameManager;
    private Score score;

    public PlateauManager(SettingsManager settings, GameManager gameManager){
        this.settings = settings;
        this.score = new Score(settings.getPseudoJ1(), settings.getPseudoJ2());
        this.gameManager = new PlateauFrames(null, gameManager) ;

    }
}
