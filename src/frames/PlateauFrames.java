package frames;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;

import managers.GameManager;
import plateau_tools.ButtonCard;

public class PlateauFrames extends JFrame  {
    
    private ArrayList<ButtonCard> buttonList;

    public PlateauFrames(ArrayList<ButtonCard> buttonList, GameManager gameManager) {
        this.buttonList = buttonList;
        int rows = 4; // Nombre de lignes dans la grille
        int cols = 5; // Nombre de colonnes dans la grille
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        

        for (ButtonCard curButton : buttonList) {
            gridPanel.add(curButton);
        }

        // Ajout du panneau de la grille à la fenêtre principale
        this.getContentPane().add(gridPanel);

        // Ajustement de la taille de la fenêtre et affichage
        this.pack();
        this.setVisible(true);
    }

}
