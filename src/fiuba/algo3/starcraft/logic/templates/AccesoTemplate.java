package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class AccesoTemplate extends ConstructionTemplate {

    private static AccesoTemplate instance = new AccesoTemplate();

    private AccesoTemplate() {
        value = new Value(150,0);
        constructionTime = 8;
        health = 500;
        shield = 500;
        //faltan las enabled units
    }

    public static AccesoTemplate getInstance() {
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