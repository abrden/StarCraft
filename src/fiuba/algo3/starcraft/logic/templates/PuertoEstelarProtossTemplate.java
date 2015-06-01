package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class PuertoEstelarProtossTemplate extends ConstructionTemplate {

    private static PuertoEstelarProtossTemplate instance = new PuertoEstelarProtossTemplate();

    private PuertoEstelarProtossTemplate() {
        value = new Value(150,150);
        constructionTime = 10;
        health = 600;
        shield = 600;
        enabledTemplates = new LinkedList<UnitTemplate>();
        enabledTemplates.add(ScoutTemplate.getInstance());
        enabledTemplates.add(NaveTransporteProtossTemplate.getInstance());
    }

    public static PuertoEstelarProtossTemplate getInstance() {
        return instance;
    }

	public ConstructionStructure create() {
		return new ConstructionStructure(new Life(health, shield), enabledTemplates);
	}
}

