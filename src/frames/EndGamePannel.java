package frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGamePannel extends JPanel{
    
    private JLabel messageLabel;

    public EndGamePannel(String message){
        this.messageLabel = new JLabel(message);
        this.add(this.messageLabel);
    }
}
