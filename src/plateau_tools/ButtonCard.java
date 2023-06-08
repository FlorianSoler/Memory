package plateau_tools;
import javax.swing.*;

public class ButtonCard extends JButton{

    //Parameter
    private int buttonId;
    private boolean isVerso = false;

    //card
    private Card card;
    private Icon cardRecto;

    public ButtonCard(int buttonid, Card card, Icon rectoIcon){
        this.buttonId = buttonid;
        this.card = card;
        this.cardRecto = rectoIcon;
        initButtonGui();
    }

    private void initButtonGui(){
        this.setIcon(this.cardRecto);
        this.setContentAreaFilled(false);
    }

    public void fliped(){
        this.isVerso = true;
        this.setIcon(card.getCardImage());
    }

    public Card getCard() {
        return card;
    }

    public int getButtonId() {
        return buttonId;
    }
}
