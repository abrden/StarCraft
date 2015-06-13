package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.MarineTemplate;

public class BarracaTemplate extends ConstructionTemplate {

	private static final String NAME = "Barraca";
	private static final Value VALUE = new Value(150,0);
	private static final int CONSTRUCTION_TIME = 12;
	private static final int HEALTH = 1000;
	
	public BarracaTemplate() {
		enabledTemplates.add(new MarineTemplate());
	}
	
	public ConstructionStructure create(Point position) {
		return new ConstructionStructure(NAME, new Life(HEALTH), position, enabledTemplates);
	}
	
	public String getName() {
		return NAME;
	}

	public Value getValue() {
		return VALUE;
	}

	public int getConstructionTime() {
		return CONSTRUCTION_TIME;
	}
	
}
