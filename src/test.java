
import javax.swing.JPanel;

import frames.PlateauFrames;
import frames.ScorePannel;
import managers.GameManager;
import plateau_tools.CardProvider;
import plateau_tools.Score;

public class test {
    public static void main(String[] args) {
        //GameManager gameManager = new GameManager();

        ScorePannel SP = new ScorePannel("MOI", "TOI");
        CardProvider CP = new CardProvider("Birds");
        PlateauFrames PF = new PlateauFrames(null, CP.GeneratePairs(20), SP, 4, 5);

        ScorePannel SP2 = new ScorePannel("MOIAAAAA", "TOAAAAI");
        PF.setScorePanel(SP2);

        
    }
}
