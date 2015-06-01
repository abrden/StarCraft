package fiuba.algo3.starcraft.logic.templates;


import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class NaveTransporteProtossTemplate extends TransportUnitTemplate {

    private static NaveTransporteProtossTemplate instance = new NaveTransporteProtossTemplate();

    private NaveTransporteProtossTemplate() {
        value = new Value(200,0);
        constructionTime = 8;
        health = 80;
        shield = 60;
        capacity = 8;
    }

    public static NaveTransporteProtossTemplate getInstance() {
        return instance;
    }
    public ConstructionStructure create() {
        // TODO Resolver tiempo de construccion
        return new ConstructionStructure(new Life(health));
    }
    @Override
    public StructureID getStructureId() {
        return StructureID.ConstructionStructure;
    }
}