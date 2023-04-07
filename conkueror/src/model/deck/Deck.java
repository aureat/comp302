package game.deck;

import game.Game;
import game.Utils;
import game.map.ArmyType;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    private ChanceCard lastChanceCard;
    private ArrayList<Card> shuffledCards;

    private static final int infantryPerPlayer = 3;
    private static final int cavalryPerPlayer = 2;
    private static final int artilleryPerPlayer = 1;

    public Deck() {
        this.lastChanceCard = null;
        this.shuffledCards = new ArrayList<>();
    }

    public boolean isEmpty() {
        return shuffledCards.isEmpty();
    }

    private void checkDeck() {
        if (isEmpty()) shuffleDeck();
    }

    private void createArmyCards() {
        // get player count
        Game game = Game.getInstance();
        int playerCount = game.getPlayerCount();

        // infantry cards
        Card[] infantryCards = new Card[playerCount * infantryPerPlayer];
        Arrays.setAll(infantryCards, card -> new ArmyCard(ArmyType.Infantry));
        for (Card card : infantryCards) {
            shuffledCards.add(card);
        }

        // cavalry cards
        Card[] cavalryCards = new Card[playerCount * cavalryPerPlayer];
        Arrays.setAll(cavalryCards, card -> new ArmyCard(ArmyType.Cavalry));
        for (Card card : cavalryCards) {
            shuffledCards.add(card);
        }

        // artillery cards
        Card[] artilleryCards = new Card[playerCount * artilleryPerPlayer];
        Arrays.setAll(artilleryCards, card -> new ArmyCard(ArmyType.Artillery));
        for (Card card : artilleryCards) {
            shuffledCards.add(card);
        }
    }

    private void createTerritoryCards() {

    }

    public void shuffleDeck() {
        createArmyCards();
        createTerritoryCards();

    }

    public Card drawCard() {
        checkDeck();
        Card card = Utils.randomChoice(shuffledCards);
        shuffledCards.remove(card);
        return card;
    }

    public ChanceCard drawChanceCard() {
        ChanceCard card = new ChanceCard();
        return card;
    }

}
