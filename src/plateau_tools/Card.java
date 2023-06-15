package plateau_tools;

import javax.swing.ImageIcon;

/**
 * The Card class represents a card in the game.
 */
public class Card {
    private StretchIcon cardImage;
    private int cardId;

    /**
     * Constructs a new Card instance with the specified card image and ID.
     * 
     * @param CardImage The image of the card.
     * @param id        The ID of the card.
     */
    public Card(ImageIcon CardImage, int id) {
        this.cardImage = new StretchIcon(CardImage.getImage());
        this.cardId = id;
    }

    /**
     * Retrieves the image of the card.
     * 
     * @return The image of the card.
     */
    public StretchIcon getCardImage() {
        return cardImage;
    }

    /**
     * Retrieves the ID of the card.
     * 
     * @return The ID of the card.
     */
    public int getCardId() {
        return cardId;
    }

    /**
     * Checks if the current card is equal to the specified object.
     * 
     * @param obj The object to compare.
     * @return true if the cards have the same ID, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return this.getCardId() == ((Card) obj).getCardId();
    }
}
