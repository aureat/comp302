package domain.player;

import domain.card.*;
import domain.card.chance.EffectType;
import domain.game.Game;
import domain.game.config.GameConfig;
import domain.gamemap.ContinentType;
import domain.gamemap.TerritoryType;
import domain.mapstate.TerritoryState;
import org.jetbrains.annotations.NotNull;
import util.CoreUtils;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String fullName;
    private String firstName;
    private Colors.ColorType color;
    private Avatars.AvatarType avatar;
    private boolean isComputer;

    private final List<TerritoryCard> territoryCards = new ArrayList<>();
    private final List<ArmyCard> armyCards = new ArrayList<>();
    private final List<EffectType> effects = new ArrayList<>();

    private final List<TerritoryState> territories = new ArrayList<>();

    protected Player() {
        generateCharacter();
    }

    public List<TerritoryState> getTerritories() {
        return territories;
    }

    public int getTerritoryCount() {
        return territories.size();
    }

    public void addTerritory(TerritoryState territory) {
        territories.add(territory);
    }

    public void removeTerritory(TerritoryState territory) {
        territories.remove(territory);
    }

    public boolean hasTerritory(TerritoryState territory) {
        return territories.contains(territory);
    }

    public boolean hasAnyTerritory() {
        return !territories.isEmpty();
    }

    public void generateCharacter() {
        setColor(Colors.getRandomPlayable());
        setName(Names.getRandom());
        setAvatar(Avatars.getRandom());
        setComputer(Math.random() < 0.5);
    }

    public Colors.ColorType getColor() {
        return color;
    }

    public void setColor(@NotNull Colors.ColorType color) {
        this.color = color;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setName(@NotNull String displayName) {
        this.fullName = displayName;
        this.firstName = CoreUtils.firstWord(displayName);
    }

    public Avatars.AvatarType getAvatar() {
        return avatar;
    }

    public String getAvatarString() {
        return Avatars.getAvatarName(avatar);
    }

    public void setAvatar(@NotNull Avatars.AvatarType avatar) {
        this.avatar = avatar;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public boolean canApplyTerritoryCards() {
        if (territoryCards.size() == 0)
            return false;

        List<ContinentType> continents = Game.getInstance().getMap().getContinents();
        for (ContinentType continent : continents) {
            List<TerritoryType> continentTerritories = continent.getTerritories();
            if (continentTerritories.stream().allMatch(territory -> territoryCards.stream().anyMatch(card -> card.getTerritoryType() == territory))) {
                return true;
            }
        }

        return false;
    }

    public boolean canApplyArmyCards() {
        if (armyCards.size() < 3)
            return false;

        // check if card trade result is not 0
        List<ArmyType> armyTypes = armyCards.stream().map(ArmyCard::getArmyType).toList();
        return GameConfig.get().getArmyCardTradeResult(armyTypes) != 0;
    }

    public List<ArmyType> getArmyTypes() {
        return armyCards.stream().map(ArmyCard::getArmyType).toList();
    }

    public void resetArmyCards() {
        armyCards.clear();
    }

    public List<EffectType> getEffects() {
        return effects;
    }

    public void addEffect(EffectType effect) {
        effects.add(effect);
    }

    public boolean hasEffect() {
        return !effects.isEmpty();
    }

    public boolean hasEffect(EffectType effect) {
        return effects.contains(effect);
    }

    public void removeEffect(EffectType effect) {
        effects.remove(effect);
    }

    public void removeAllEffects() {
        effects.clear();
    }

    public void addArmyCard(ArmyCard card) {
        armyCards.add(card);
    }

    public void removeArmyCard(ArmyCard card) {
        armyCards.remove(card);
    }

    public void addTerritoryCard(TerritoryCard card) {
        territoryCards.add(card);
    }

    public void removeTerritoryCard(TerritoryCard card) {
        territoryCards.remove(card);
    }

    public boolean canRollTwice() {
        return effects.contains(EffectType.Bombardment);
    }

}
