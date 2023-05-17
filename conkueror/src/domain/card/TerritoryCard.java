package domain.card;
import domain.card.CardType;
import domain.gamemap.TerritoryType;
import domain.gamemap.ContinentType;
import domain.player.Player;


/*
    continent: A reference to the Continent object that this territory card belongs to.
    cardType: An enum that represents the type of this card (territory, army, or chance).
    imageUrl: A string that represents the URL or path to an image of this territory card.
    description: A string that provides a brief description or flavor text for this territory card.
    canBeTraded: A boolean that indicates whether this card can be traded in for extra armies.
    tradeValue: An integer that represents the number of armies that can be gained by trading in a set of cards of this type.

 */



public class TerritoryCard extends Card {
    private String name;
    private Player owner;
    private TerritoryType territory;
    private ContinentType continent;
    private CardType cardType;
    private String imageUrl;
    private String description;
    private boolean canBeTraded;
    private int tradeValue;


    public TerritoryCard(String name,  CardType cardType,   String description, boolean canBeTraded, int tradeValue) {
        this.name = name;
//        this.owner = owner;
        //this.territory = territory;
        //this.continent = continent;
        this.cardType = cardType;
       // this.imageUrl = imageUrl;
        this.description = description;
        this.canBeTraded = canBeTraded;
        this.tradeValue = tradeValue;
    }

    public String getName() {
        return name;
    }


    //Complete this functions.
    public String getDescription(){
        return this.description;
    }

    public boolean canBeTraded(){
        return canBeTraded;
    }


    public boolean isOwned() {
        return owner==null;
    }

    public void setOwner(Player owner){
        this.owner = owner;
    }
    public void setOwned(boolean owned) {

    }

    public Player getOwner() {
        return owner;
    }



}
