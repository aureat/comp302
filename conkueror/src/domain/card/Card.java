package domain.card;

public abstract class Card {

    private CardType cardType;

    public Card(CardType type) {
        this.cardType = type;
    }

    public CardType getCardType() {
        return cardType;
    }

}
