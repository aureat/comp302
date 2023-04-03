package game.deck;

import java.util.ArrayList;

public class Deck {

    private ChanceCard lastChanceCard;

    private ArrayList<Card> shuffledCards;

    public Deck() {

    }

    public void createTerritoryCards(Territory[] territories) {

    }

    public void createArmyCards(int playerCount) {

    }

    public ChanceCard drawChanceCard() {
        ChanceCard card = new ChanceCard();
        return card;
    }

}
