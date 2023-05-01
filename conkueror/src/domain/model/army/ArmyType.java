package domain.model.army;

public enum ArmyType {
    Infantry,
    Cavalry,
    Artillery,
    Mercenary ;

    public String getName() {
        return name();
    }
}
