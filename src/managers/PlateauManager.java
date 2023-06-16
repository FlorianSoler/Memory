package managers;
import plateau_tools.*;

import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import frames.*;



public class PlateauManager {
    
    // Score score;
    private ButtonCard lastCard;
    private PlateauFrames plateauFrames;
    private Score score;
    private static Semaphore semaphore1 = new Semaphore(1); // un clique traiter a la fois
    private static Semaphore semaphore2 = new Semaphore(0); // timer de 2 secondes avant de reretourner les non paires

    public PlateauManager(SettingsManager settings, GameManager gameManager){

        this.lastCard = null;

        //creating the score barr
        this.score = new Score(settings.getPseudoJ1(), settings.getPseudoJ2());

        // TO change => lecture des taille a faire dans un fichier parametrable
        int[] taille = {4,5};
        
        switch (settings.getTaillePlateau()) {
            
            case "4x5":
                taille = new int[]{4,5};
                break;
            
            case "5x6":
                taille = new int[]{5,6};
                break;
            
            case "4x4":
                taille = new int[]{4,4};
                break;
        
            default:
                break;
        }
        
        
        CardProvider cardProvider = new CardProvider(settings.getTheme());
        System.out.println("CardProvider atteint");
        this.plateauFrames = new PlateauFrames(gameManager, this, cardProvider.GeneratePairs(taille[0] * taille[1]), this.score.getScorePannel(), taille[0], taille[1]);
    }

    /**
     * alows to click on a card after 2 seconds
     */
    public static void freeSemaphore2() {

        semaphore2.release();
    }

    public void buttonCardListener(ButtonCard buttonCard){
        if (semaphore1.tryAcquire()) {
            if (!buttonCard.isVerso()) {
                System.out.println("flip one card id ="+ buttonCard.getButtonId());
                this.plateauFrames.flipCard(buttonCard);

                if (this.lastCard ==  null) {
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
                            // TODO Auto-generated catch block
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

    public void closeWindow() {
        this.plateauFrames.closeWindow();
    }

    private void testFinDeJeu(){

        boolean finDeJeu = true;
        for (ButtonCard buttonCard : this.plateauFrames.getButtonList()) {
            if (! buttonCard.isVerso()) {
                System.out.print("verso");
                finDeJeu = false;
            }            
        }
        if (finDeJeu) {
            String message;
            if (this.score.getScoreJ1() == this.score.getScoreJ2()) {
                message = this.score.getPseudoJ1() + " et " + this.score.getPseudoJ2() + " ont fait ex aequo avec "+ this.score.getScoreJ1()+ " points";
            } else if (this.score.getScoreJ1() > this.score.getScoreJ2()){
                message = this.score.getPseudoJ1() + " a gagne avec "+ this.score.getScoreJ1()+ " points";
            } else {
                message = this.score.getPseudoJ2() + " a gagne avec "+ this.score.getScoreJ2()+ " points";
            }
            this.plateauFrames.setMessagePannel(new EndGamePannel(message));
        }
    }


}
