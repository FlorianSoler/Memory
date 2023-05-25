import javax.swing.ImageIcon;

public class Card {
    private ImageIcon cardImage;
    private int cardId;

    public Card(ImageIcon CardImage, int id){
        this.cardImage = CardImage;
        this.cardId = id;
    }

    public ImageIcon getCardImage() {
        return cardImage;
    }

    public int getCardId() {
        return cardId;
    }
}
