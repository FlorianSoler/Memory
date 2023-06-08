import managers.CardProvider;
import managers.GameManager;

public class test {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        CardProvider CP = new CardProvider("src/data/Collection/Cats");
    }
}
