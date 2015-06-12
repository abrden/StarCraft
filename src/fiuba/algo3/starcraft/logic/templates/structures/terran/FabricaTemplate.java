package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.GolliatTemplate;

public class FabricaTemplate extends ConstructionTemplate {

	private static final String NAME = "Fabrica";
	private static final Value VALUE = new Value(200,100);
	private static final int CONSTRUCTION_TIME = 12;
	private static final int HEALTH = 1250;
	
    public FabricaTemplate() {
		enabledTemplates.add(new GolliatTemplate());
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
