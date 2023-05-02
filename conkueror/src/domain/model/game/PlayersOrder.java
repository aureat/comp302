package domain.model.game;

import domain.model.player.Player;

import java.util.*;
public class PlayersOrder {

    private ArrayList<Player> playerOrder;
    private int[] diceOrder;

    // when click on roll dice for player orders get players method is initialized in game class
    public PlayersOrder(){
        this.playerOrder = Game.getInstance().getPlayers();
        this.diceOrder = new int[playerOrder.size()];
    }
    public int[] rollDices(){
        for (int i = 0; i<playerOrder.size(); i++){
            diceOrder[i] = Dice.roll();
        }
        return diceOrder;
    }

    public ArrayList<Player> getPlayerOrder(){
        rollDices();
        int max = 0;
        int index = 0;
        Player maxRolledPlayer = null;
        for (int i = 0; i<diceOrder.length; i++){
            if (diceOrder[i]>max){
                max = diceOrder[i];
                index=i;
            }
        }
        for (int j = 0; j<diceOrder.length; j++ ){
            maxRolledPlayer = playerOrder.get(j);
            while (j != index && diceOrder[j] == max){
                getPlayerOrder();
            }
            break;
        }
        playerOrder.remove(maxRolledPlayer);
        Collections.shuffle(playerOrder);
        playerOrder.add(0, maxRolledPlayer);
        return playerOrder;
    }

}
