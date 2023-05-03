package domain.gamemap;

import java.util.List;


/**
 * TerritoryType is an interface that represents a territory in the game.
 * A territory has a name, a continent, and a list of neighbors.
 * A territory is defined by implementing this interface.
 *
 * @see domain.gamemap.GameMap
 */
public interface TerritoryType {
    String getName();
    ContinentType getContinent();
    void addNeighbor(TerritoryType neighbor);
    boolean hasNeighbor(TerritoryType neighbor);
    List<TerritoryType> getNeighbors();
}
