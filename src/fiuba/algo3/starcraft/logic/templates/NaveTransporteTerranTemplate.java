package fiuba.algo3.starcraft.logic.templates;



import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;
import fiuba.algo3.starcraft.logic.units.TransportUnit;

public class NaveTransporteTerranTemplate extends TransportUnitTemplate{

    private static NaveTransporteTerranTemplate instance = new NaveTransporteTerranTemplate();

    private NaveTransporteTerranTemplate() {
        value = new Value(200,0);
        constructionTime = 8;
        health = 150;
        capacity = 8;
    }

    public static NaveTransporteTerranTemplate getInstance() {
        return instance;
    }

    @Override
    public StructureID getStructureId() {
        return StructureID.ConstructionStructure;
    }
}