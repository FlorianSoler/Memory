package plateau_tools;
import javax.swing.*;

public class ButtonCard extends JButton{

    //Parameter
    private int buttonId;
    private boolean isVerso = false;

    //card
    private Card card;
    private StretchIcon cardRecto;

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

    public void fliped(){
        if(this.isVerso == false){
            this.isVerso = true;
            this.setIcon(this.card.getCardImage());
        }else{
            this.isVerso = false;
            this.setIcon(this.cardRecto);
        }
    }

    public Card getCard() {
        return card;
    }

    public int getButtonId() {
        return buttonId;
    }
}
