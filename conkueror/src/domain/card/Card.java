package domain.card;

import java.io.Serializable;

public abstract class Card implements Serializable {

    private CardType cardType;

    public Card(CardType type) {
        this.cardType = type;
    }

    public CardType getCardType() {
        return cardType;
    }

}
