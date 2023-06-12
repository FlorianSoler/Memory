package plateau_tools;
import javax.swing.ImageIcon;

public class Card {
    private StretchIcon cardImage;
    private int cardId;

    public Card(ImageIcon CardImage, int id){
        this.cardImage = new StretchIcon(CardImage.getImage());
        this.cardId = id;
    }

    public StretchIcon getCardImage() {
        return cardImage;
    }

    public int getCardId() {
        return cardId;
    }
}
