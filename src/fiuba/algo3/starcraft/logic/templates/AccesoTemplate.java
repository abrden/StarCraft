package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class AccesoTemplate extends ConstructionTemplate {

    private static AccesoTemplate instance = new AccesoTemplate();

    private AccesoTemplate() {
        value = new Value(150,0);
        constructionTime = 8;
        health = 500;
        shield = 500;
        enabledTemplates = new LinkedList<UnitTemplate>();
        enabledTemplates.add(ZealotTemplate.getInstance());
        enabledTemplates.add(DragonTemplate.getInstance());
    }

    public static AccesoTemplate getInstance() {
        return instance;
    }
    
    public ConstructionStructure create() {
        // TODO Resolver tiempo de construccion
        return new ConstructionStructure(new Life(health, shield), enabledTemplates);
    }
}