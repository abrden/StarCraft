package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.NaveTransporteProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;

public class PuertoEstelarProtossTemplate extends ConstructionTemplate {

    public PuertoEstelarProtossTemplate() {
        name = "Puerto Estelar";
        value = new Value(150,150);
        constructionTime = 10;
        health = 600;
        shield = 600;
        enabledTemplates = new LinkedList<UnitTemplate>();
        enabledTemplates.add(new ScoutTemplate());
        enabledTemplates.add(new NaveTransporteProtossTemplate());
    }

	public ConstructionStructure create(Point position) {
		return new ConstructionStructure(name, new Life(health, shield), position, enabledTemplates);
	}
}

