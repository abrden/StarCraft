package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.StructureID;

public abstract class TransportUnitTemplate extends UnitTemplate {

    protected int capacity;
    public abstract StructureID getStructureId();

}
