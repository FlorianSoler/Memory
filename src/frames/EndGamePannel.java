package frames;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The EndGamePannel class is a custom JPanel that displays the end game message.
 * It contains a JLabel to show the provided message.
 */
public class EndGamePannel extends JPanel {
    
    private JLabel messageLabel; // Label to display the end game message

    /**
     * Constructor for the EndGamePannel class.
     * Creates a JLabel with the provided message and adds it to the panel.
     *
     * @param message The end game message to be displayed.
     */
    public EndGamePannel(String message) {
        this.messageLabel = new JLabel(message);
        this.add(this.messageLabel);
    }
}

