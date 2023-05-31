public class GameManager {
    private SettingsManager settings;

    public GameManager(){
        this.settings = new SettingsManager();
    }

    
    private void createPlateau(){
        this.settings.getValuesFromView();
    }

    

}
