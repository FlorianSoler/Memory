package plateau_tools;
import frames.ScorePannel;

public class Score {
    private int scoreJ1;
    private int scoreJ2;
    private String pseudoJ1;
    private String pseudoJ2;
    private boolean isJ1CurrentPlayer;
    private ScorePannel scorePannel;

    public Score(String pseudoJ1, String pseudoJ2){
        this.pseudoJ1 = pseudoJ1;
        this.pseudoJ2 = pseudoJ2;
        this.scoreJ1 = 0;
        this.scoreJ2 = 0;
        this.isJ1CurrentPlayer = true;
        this.scorePannel = new ScorePannel(pseudoJ1, pseudoJ2);
        
    }

    public void switchPlayer() {
        this.isJ1CurrentPlayer = ! this.isJ1CurrentPlayer;
        this.scorePannel.switchPlayer();
    }

    public void addPoint() {
        if (this.isJ1CurrentPlayer) {
            this.scoreJ1 = this.scoreJ1 +1;
            this.scorePannel.addScoreJ1(this.scoreJ1);
        } else {
            this.scoreJ2 = this.scoreJ2 +1;
            this.scorePannel.addScoreJ2(this.scoreJ2);
        }
        
    }

    /**
     * @return the pseudoJ1
     */
    public String getPseudoJ1() {
        return pseudoJ1;
    }

    /**
     * @return the pseudoJ2
     */
    public String getPseudoJ2() {
        return pseudoJ2;
    }

    /**
     * @return the scoreJ1
     */
    public int getScoreJ1() {
        return scoreJ1;
    }

    /**
     * @return the scoreJ2
     */
    public int getScoreJ2() {
        return scoreJ2;
    }

    /**
     * @return the scorePannel
     */
    public ScorePannel getScorePannel() {
        return scorePannel;
    }
}
