package domain.model.map.states;


import domain.model.map.types.*;
import domain.model.player.Player;
import java.util.ArrayList;
public class ContinentState {

    private ContinentType continent;

    public ContinentState (ContinentType continent){
        this.continent = continent;
    }

    public ContinentType getContinent() {
        return continent;
    }

    public ArrayList<TerritoryType> getTerritories(){
        return getTerritories();
    }
}
