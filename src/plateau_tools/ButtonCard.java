package plateau_tools;
import javax.swing.*;

/**
 * The ButtonCard class represents a button that displays a card in the game.
 */
public class ButtonCard extends JButton{

    //Parameter
    private int buttonId;
    private boolean isVerso = false;

    //card
    private Card card;
    private StretchIcon cardRecto;

    /**
     * Constructs a new ButtonCard instance with the specified button ID, card, and card recto icon.
     * @param buttonid The ID of the button.
     * @param card The card associated with the button.
     * @param rectoIcon The recto icon for the button.
     */
    public ButtonCard(int buttonid, Card card, StretchIcon rectoIcon){
        this.buttonId = buttonid;
        this.card = card;
        this.cardRecto = rectoIcon;
        initButtonGui();
    }

    private void initButtonGui(){
        this.setIcon(this.cardRecto);
        this.setContentAreaFilled(false);
    }

    /**
     * Flips the button to show the card image or the recto icon based on its current state.
     */
    public void fliped(){
        if(this.isVerso == false){
            this.isVerso = true;
            this.setIcon(this.card.getCardImage());
        }else{
            this.isVerso = false;
            this.setIcon(this.cardRecto);
        }
    }

    /**
     * Checks if the button is currently displaying the verso (card image) or recto icon.
     * @return true if the button is showing the verso, false otherwise.
     */
    public boolean isVerso() {
        return isVerso;
    }

    /**
     * Retrieves the card associated with the button.
     * @return The card associated with the button.
     */
    public Card getCard() {
        return card;
    }

    /**
     * Retrieves the ID of the button.
     * @return The ID of the button.
     */
    public int getButtonId() {
        return buttonId;
    }
}
