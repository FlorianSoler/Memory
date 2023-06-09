
import frames.PlateauFrames;
import managers.GameManager;
import plateau_tools.CardProvider;

public class test {
    public static void main(String[] args) {
        //GameManager gameManager = new GameManager();
        CardProvider CP = new CardProvider("Birds");
        PlateauFrames PF = new PlateauFrames(null, CP.GeneratePairs(20), 4, 5);
        
    }
}
