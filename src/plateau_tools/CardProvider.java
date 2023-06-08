package managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import plateau_tools.*;

public class CardProvider {
    private String collectionPath;
    private ArrayList<ImageIcon> loadedImages = new ArrayList<ImageIcon>();

    private static String rectoPath = "src/data/Gui/CardRecto.jpg";
    private Icon cardRecto;

    public CardProvider(String PathCollection){
        this.collectionPath = PathCollection;
        this.cardRecto = new ImageIcon(rectoPath);
        LoadImages();
    }

    private void LoadImages(){
        File folder = new File(this.collectionPath);
        File[] files = folder.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                        try {
                            BufferedImage bufferedImage = ImageIO.read(file);
                            this.loadedImages.add(new ImageIcon(bufferedImage));
                        } catch (IOException e) {
                            System.out.println("Erreur lors du chargement de l'image : " + fileName);
                        }
                    }
                }
            }
        }   
    }

    public ArrayList<ButtonCard> GeneratePairs(int NumberOfCard){
        ArrayList<ButtonCard> buttonCardPairs = new ArrayList<ButtonCard>();
        try{
            //check for evennes
            if((NumberOfCard % 2) == 0){
                for (int i = 0; i < NumberOfCard; i++) {
                    int listIndex = i % loadedImages.size();

                    Card card = new Card(loadedImages.get(listIndex), listIndex);
                    ButtonCard bCard = new ButtonCard(i, card, this.cardRecto);

                    buttonCardPairs.add(bCard);
                }
            }
            else{
                throw new Exception("Error the NumberOfCard is odd !");
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
        return buttonCardPairs;
    }
}
