package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class FabricaTemplate extends ConstructionTemplate {

    private static FabricaTemplate instance = new FabricaTemplate();

    private FabricaTemplate() {
        value = new Value(200,100);
        constructionTime = 12;
        health = 1250;
    }

    public static FabricaTemplate getInstance() {
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
