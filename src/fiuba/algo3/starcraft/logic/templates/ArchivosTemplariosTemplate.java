package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class ArchivosTemplariosTemplate extends ConstructionTemplate {

    private static ArchivosTemplariosTemplate instance = new ArchivosTemplariosTemplate();

    private ArchivosTemplariosTemplate() {
        value = new Value(150,200);
        constructionTime = 9;
        health = 500;
        shield = 500;
        enabledTemplates = new LinkedList<UnitTemplate>();
		enabledTemplates = new LinkedList<UnitTemplate>();
		//enabledTemplates.add(AltosTemplariosTemplate.getInstance());
    }

    public static ArchivosTemplariosTemplate getInstance() {
        return instance;
    }
    public ConstructionStructure create() {
        // TODO Resolver tiempo de construccion
        return new ConstructionStructure(new Life(health, shield), enabledTemplates);
    }
}