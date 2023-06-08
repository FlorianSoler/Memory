package frames;

import java.util.ArrayList;

import javax.swing.*;

import plateau_tools.ButtonCard;

public class PlateauFrames extends JFrame  {
    
    private ArrayList<ButtonCard> buttonList;

    public PlateauFrames(ArrayList<ButtonCard> buttonList) {
        this.buttonList = buttonList;
    }

}
