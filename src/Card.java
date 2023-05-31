import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Card {
    private Icon cardImage;
    private int cardId;

    public Card(ImageIcon CardImage, int id){
        this.cardImage = CardImage;
        this.cardId = id;
    }

    public Icon getCardImage() {
        return cardImage;
    }

    public int getCardId() {
        return cardId;
    }
}
