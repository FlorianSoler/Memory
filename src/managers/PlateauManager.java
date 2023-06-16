package managers;

import plateau_tools.*;

import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import frames.*;

/**
 * The PlateauManager class manages the game board and its interactions.
 * It handles the creation of the game board based on the selected settings and
 * theme.
 * It also manages the scoring, card flipping, and game ending conditions.
 */
public class PlateauManager {

    private ButtonCard lastCard; // The last flipped card
    private PlateauFrames plateauFrames; // The frame that displays the game board
    private Score score; // The score object to track player scores
    private static Semaphore semaphore1 = new Semaphore(1); // Ensures only one click is processed at a time
    private static Semaphore semaphore2 = new Semaphore(0); // Timer of 2 seconds before flipping non-matching cards

    /**
     * Constructor for the PlateauManager class.
     * Initializes the game board based on the selected settings and theme.
     *
     * @param settings    The settings manager object containing game settings.
     * @param gameManager The game manager object.
     */
    public PlateauManager(SettingsManager settings, GameManager gameManager) {
        this.lastCard = null;
        this.score = new Score(settings.getPseudoJ1(), settings.getPseudoJ2()); // Creating the score bar

        // Retrieving the selected board size
        int[] taille = { 4, 5 };
        switch (settings.getTaillePlateau()) {
            case "4x5":
                taille = new int[] { 4, 5 };
                break;
            case "5x6":
                taille = new int[] { 5, 6 };
                break;
            case "4x4":
                taille = new int[] { 4, 4 };
                break;
            default:
                break;
        }

        CardProvider cardProvider = new CardProvider(settings.getTheme());
        this.plateauFrames = new PlateauFrames(gameManager, this, cardProvider.GeneratePairs(taille[0] * taille[1]),
                this.score.getScorePannel(), taille[0], taille[1]);
    }

    /**
     * Frees the semaphore2 to allow clicking on a card after 2 seconds.
     */
    public static void freeSemaphore2() {
        semaphore2.release();
    }

    /**
     * Handles the button card listener event.
     * Flips the clicked card and checks for matches or non-matches.
     *
     * @param buttonCard The clicked button card object.
     */
    public void buttonCardListener(ButtonCard buttonCard) {
        if (semaphore1.tryAcquire()) {
            if (!buttonCard.isVerso()) {
                this.plateauFrames.flipCard(buttonCard);

                if (this.lastCard == null) {
                    this.lastCard = buttonCard;
                } else {
                    if (this.lastCard.getCard().equals(buttonCard.getCard())) {
                        this.score.addPoint();
                    } else {
                        try {
                            Runnable r = new MyRunnable(this);
                            new Thread(r).start();
                            semaphore2.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        this.plateauFrames.flipCard(this.lastCard);
                        this.plateauFrames.flipCard(buttonCard);
                        this.score.switchPlayer();
                    }
                    this.lastCard = null;

                    this.plateauFrames.setScorePanel(this.score.getScorePannel());
                    this.testFinDeJeu();
                }
            }
            semaphore1.release();
        }
    }

    /**
     * Closes the game window.
     */
    public void closeWindow() {
        this.plateauFrames.closeWindow();
    }

    /**
     * Checks if the game has ended by flipping all the cards.
     * Displays the end game message panel with the winner or tie message.
     */
    private void testFinDeJeu() {
        boolean finDeJeu = true;
        for (ButtonCard buttonCard : this.plateauFrames.getButtonList()) {
            if (!buttonCard.isVerso()) {
                finDeJeu = false;
            }
        }
        if (finDeJeu) {
            String message;
            if (this.score.getScoreJ1() == this.score.getScoreJ2()) {
                message = this.score.getPseudoJ1() + " et " + this.score.getPseudoJ2() + " ont fait ex aequo avec "
                        + this.score.getScoreJ1() + " points";
            } else if (this.score.getScoreJ1() > this.score.getScoreJ2()) {
                message = this.score.getPseudoJ1() + " a gagné avec " + this.score.getScoreJ1() + " points";
            } else {
                message = this.score.getPseudoJ2() + " a gagné avec " + this.score.getScoreJ2() + " points";
            }
            this.plateauFrames.setMessagePannel(new EndGamePannel(message));
        }
    }
}
