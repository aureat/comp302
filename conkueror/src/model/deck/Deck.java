package model.deck;

import model.card.*;
import model.game.Game;
import model.army.ArmyType;
import model.game.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    private ChanceCard lastChanceCard;
    private ArrayList<ChanceCard> shuffledCards;
    private ArrayList<ArmyCard> ArmyDeck ;

//    private static final int infantryPerPlayer = 3;
//    private static final int cavalryPerPlayer = 2;
//    private static final int artilleryPerPlayer = 1;

    public Deck() {
        this.lastChanceCard = null;
        this.shuffledCards = new ArrayList<ChanceCard>();
    }

    private void checkDeck(){
        if (shuffledCards.isEmpty()){
            throw new IllegalStateException("Deck is empty");
        }
    }

    public boolean isEmpty() {
        return shuffledCards.isEmpty();
    }

//    private void checkDeck() {
//        if (isEmpty()) shuffleDeck();
//    }

    private void createArmyCards() {
        ArmyDeck = new ArrayList<ArmyCard>();
        // get player count
        Game game = Game.getInstance();
        int infantaryCount = game.getInfantryPerPlayer();
        int cavalaryCount = game.getCavalryPerPlayer();
        int artilleryCount = game.getArtilleryPerPlayer();
        int playerCount = game.getPlayerCount();


        // infantry cards
        Card[] infantryCards = new Card[playerCount * infantaryCount];
        Arrays.setAll(infantryCards, card -> new ArmyCard(ArmyType.Infantry));
        for (Card card : infantryCards) {
            ArmyDeck.add((ArmyCard) card);
        }

        // cavalry cards
        Card[] cavalryCards = new Card[playerCount * cavalaryCount];
        Arrays.setAll(cavalryCards, card -> new ArmyCard(ArmyType.Cavalry));
        for (Card card : cavalryCards) {
            ArmyDeck.add((ArmyCard) card);
        }

        // artillery cards
        Card[] artilleryCards = new Card[playerCount * artilleryCount];
        Arrays.setAll(artilleryCards, card -> new ArmyCard(ArmyType.Artillery));
        for (Card card : artilleryCards) {
            ArmyDeck.add((ArmyCard) card);
        }
    }

    private void createTerritoryCards() {

    }

    public void shuffleDeck() {
        createArmyCards();
        createTerritoryCards();

    }

    public ChanceCard drawCard() {
        checkDeck();
        int randomIndex = Utils.randomChoiceIndex(shuffledCards.size());
        ChanceCard card = shuffledCards.get(randomIndex);
        shuffledCards.remove(randomIndex);
        return card;
    }

    public ChanceCard drawChanceCard() {
        ChanceCard card = new ChanceCard();
        return card;
    }

}
