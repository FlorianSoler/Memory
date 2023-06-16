package managers;

import java.io.File;


import frames.SettingsFrame;

public class SettingsManager {
    private String pseudoJ1;
    private String pseudoJ2;
    private String taillePlateau;
    private String theme;
    private SettingsFrame settingsFrame;


    public SettingsManager(GameManager gameManager){
        
        this.settingsFrame = new SettingsFrame(gameManager, this.getThemes(), this.getTailles());
        this.setVisible(true);

    }

    public void closeWindow() {
        this.settingsFrame.closeWindow();
    }

    private String[] getThemes(){
        //Creating a File object for directory
        File directoryPath = new File("src/data/Collection");
        //List of all files and directories
        String themes[] = directoryPath.list();
        return themes;
    }

    private String[] getTailles() {
        return new String[]{"4x5", "5x6", "4x4"};
    }

    public void getValuesFromView() {
        this.pseudoJ1 = this.settingsFrame.getPseudoJ1();
        this.pseudoJ2 = this.settingsFrame.getPseudoJ2();
        this.taillePlateau = this.settingsFrame.getTaillePlateau();
        this.theme = this.settingsFrame.getTheme();
    }

    public void setVisible(boolean visible){
        this.settingsFrame.setVisible(visible);
    }

    /**
     * @return the pseudoJ1
     */
    public String getPseudoJ1() {
        return pseudoJ1;
    }
    /**
     * @return the pseudoJ2
     */
    public String getPseudoJ2() {
        return pseudoJ2;
    }
    /**
     * @return the taillePlateau
     */
    public String getTaillePlateau() {
        return taillePlateau;
    }
    /**
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

}
