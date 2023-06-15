package plateau_tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * The CardProvider class is responsible for generating pairs of cards, and
 * shuffling the card list.
 */
public class CardProvider {
    // buffers
    private String collectionPath;
    private ArrayList<ImageIcon> loadedImages = new ArrayList<ImageIcon>();

    // ui
    private static String rectoPath = "src/data/Gui/CardRecto.jpg";
    private StretchIcon cardRecto;

    /**
     * Constructs a new CardProvider instance with the specified collection name.
     * 
     * @param collectionName The name of the collection.
     */
    public CardProvider(String collectionName) {
        this.collectionPath = "src/data/Collection/" + collectionName;
        this.cardRecto = new StretchIcon(rectoPath);
        LoadImages();
    }

    private void LoadImages() {
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

    /**
     * Generates pairs of ButtonCard objects based on the specified number of cards.
     * 
     * @param NumberOfCard The total number of cards (should be even).
     * @return An ArrayList of ButtonCard pairs.
     */
    public ArrayList<ButtonCard> GeneratePairs(int NumberOfCard) {
        ArrayList<ButtonCard> buttonCardPairs = new ArrayList<ButtonCard>();
        try {
            // check for evenness
            if ((NumberOfCard % 2) == 0) {
                int id = 0;
                for (int i = 0; i < NumberOfCard / 2; i++) {
                    int listIndex = i % loadedImages.size();
                    Card card = new Card(loadedImages.get(listIndex), listIndex);
                    // Create pairs
                    ButtonCard bCardPair1 = new ButtonCard(id, card, this.cardRecto);
                    id++;
                    ButtonCard bCardPair2 = new ButtonCard(id, card, this.cardRecto);
                    id++;
                    buttonCardPairs.add(bCardPair1);
                    buttonCardPairs.add(bCardPair2);
                }
            } else {
                throw new Exception("Error the NumberOfCard is odd !");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        scrambleArrayList(buttonCardPairs);
        return buttonCardPairs;
    }

    /**
     * Shuffles the elements of the provided ArrayList.
     * 
     * @param list The ArrayList to be shuffled.
     */
    private static void scrambleArrayList(ArrayList<?> list) {
        Collections.shuffle(list);
    }

}

/*
           _____
         |A .  | _____
         | /.\ ||A ^  | _____
         |(_._)|| / \ ||A _  | _____
         |  |  || \ / || ( ) ||A_ _ |
         |____V||  .  ||(_'_)||( v )|
                |____V||  |  || \ / |
                       |____V||  .  |
                              |____V|
 */