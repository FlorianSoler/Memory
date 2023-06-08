package managers;

public class GameManager {
    private SettingsManager settings;

    public GameManager(){
        // this needed to lunch createPlateau() on validation
        this.settings = new SettingsManager(this); 
    }

    public void createPlateau(){
        this.settings.getValuesFromView();
        this.settings.closeWindow();
        
        System.out.println(this.settings.getPseudoJ1() + " , " + this.settings.getPseudoJ2());
    }

    

}
