package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.NaveTransporteProtossTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.ScoutTemplate;

public class PuertoEstelarProtossTemplate extends ConstructionTemplate {

	private static final String NAME = "Puerto Estelar";
	private static final Value VALUE = new Value(150,150);
	private static final int CONSTRUCTION_TIME = 10;
	private static final int HEALTH = 600;
	private static final int SHIELD = 600;
	
    public PuertoEstelarProtossTemplate() {
    	addEnabledTemplate(new ScoutTemplate());
    	addEnabledTemplate(new NaveTransporteProtossTemplate());
    }
	
	public ConstructionStructure create(Point position) {
		return new ConstructionStructure(NAME, new Life(HEALTH, SHIELD), position, enabledTemplates);
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

