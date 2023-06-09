package plateau_tools;

public class Score {
    private int scoreJ1;
    private int scoreJ2;
    private String pseudoJ1;
    private String pseudoJ2;
    private boolean isJ1CurrentPlayer;

    public Score(String pseudoJ1, String pseudoJ2){
        this.pseudoJ1 = pseudoJ1;
        this.pseudoJ2 = pseudoJ2;
        this.scoreJ1 = 0;
        this.scoreJ2 = 0;
        this.isJ1CurrentPlayer = true;
        
    }

    public void switchPlayer() {
        this.isJ1CurrentPlayer = ! this.isJ1CurrentPlayer;
    }

    public int addPointJ1() {
        this.scoreJ1 = this.scoreJ1 +1;
        return this.scoreJ1;
    }

    public int addPointJ2() {
        this.scoreJ2 = this.scoreJ2 +1;
        return this.scoreJ2;
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
}
