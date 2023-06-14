package managers;

import java.util.ArrayList;

import plateau_tools.ButtonCard;

public class GameManager {
    private SettingsManager settings;
    private PlateauManager plateauManager;

    public GameManager(){
        // this needed to lunch createPlateau() on validation
        this.settings = new SettingsManager(this); 
    }

    public void createPlateau(){
        this.settings.getValuesFromView();
        this.settings.closeWindow();
        
        System.out.println(this.settings.getPseudoJ1() + " , " + this.settings.getPseudoJ2());
        this.plateauManager = new PlateauManager(settings, this);
    }
    
    public void returnToSettings() {
        this.plateauManager.closeWindow();
        this.settings = new SettingsManager(this);
    }

    

}
