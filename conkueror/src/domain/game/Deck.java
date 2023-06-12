package domain.game;

import domain.card.*;
import domain.game.config.GameConfig;
import domain.gamemap.GameMap;
import util.CoreUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Deck {

    private static final int infantryPerPlayer = GameConfig.get().getInfantryPerPlayer();
    private static final int cavalryPerPlayer = GameConfig.get().getCavalryPerPlayer();
    private static final int artilleryPerPlayer = GameConfig.get().getArtilleryPerPlayer();

    private GameMap map;
    private int playerCount;
    private final List<Card> shuffledCards = new ArrayList<>();

    public Deck(GameMap map, int playerCount) {
        this.map = map;
        this.playerCount = playerCount;
        shuffleDeck();
    }

    public boolean isEmpty() {
        return shuffledCards.isEmpty();
    }

    private void checkDeck() {
        if (isEmpty()) shuffleDeck();
    }

    public void shuffleDeck() {

        // Army Cards
        IntStream.range(0, playerCount * infantryPerPlayer)
                .forEach(i -> shuffledCards.add(new ArmyCard(ArmyType.Infantry)));
        IntStream.range(0, playerCount * cavalryPerPlayer)
                .forEach(i -> shuffledCards.add(new ArmyCard(ArmyType.Cavalry)));
        IntStream.range(0, playerCount * artilleryPerPlayer)
                .forEach(i -> shuffledCards.add(new ArmyCard(ArmyType.Artillery)));

        // Territory Cards
        map.getTerritories().forEach(territory -> shuffledCards.add(new TerritoryCard(territory)));

        // Shuffle
        Collections.shuffle(shuffledCards);

        System.out.println("Deck shuffled");
        System.out.println("Deck size: " + shuffledCards.size());

    }

    public Card drawCard() {

        // Check if deck is empty and reshuffle
        checkDeck();

        // Draw card
        Card card = CoreUtils.chooseRandom(shuffledCards);
        shuffledCards.remove(card);
        return card;

    }

    public ChanceCard drawChanceCard() {
        return new ChanceCard();
    }

}
