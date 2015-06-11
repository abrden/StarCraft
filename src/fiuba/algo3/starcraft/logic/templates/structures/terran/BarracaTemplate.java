package fiuba.algo3.starcraft.logic.templates.structures.terran;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;

public class BarracaTemplate extends ConstructionTemplate {

	public BarracaTemplate() {
		name = "Barraca";
		value = new Value(150,0);
		constructionTime = 12;
		health = 1000;
		enabledTemplates = new LinkedList<UnitTemplate>();
		enabledTemplates.add(new MarineTemplate());
	}

	public ConstructionStructure create(Point position) {
		return new ConstructionStructure(name, new Life(health), position, enabledTemplates);
	}
}
