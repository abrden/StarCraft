package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.structures.StructureID;

public class PuertoEstelarProtossTemplate extends ConstructionTemplate {

    private static PuertoEstelarProtossTemplate instance = new PuertoEstelarProtossTemplate();

    private PuertoEstelarProtossTemplate() {
        value = new Value(150,150);
        constructionTime = 10;
        health = 600;
        shield = 600;
    }

    public static PuertoEstelarProtossTemplate getInstance() {
        return instance;
    }


    @Override
    public StructureID getStructureId() {
        return StructureID.ConstructionStructure;
    }
}

