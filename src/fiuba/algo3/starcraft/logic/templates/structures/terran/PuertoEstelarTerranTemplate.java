package fiuba.algo3.starcraft.logic.templates.structures.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.EspectroTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveCienciaTemplate;
import fiuba.algo3.starcraft.logic.templates.units.terran.NaveTransporteTerranTemplate;

public class PuertoEstelarTerranTemplate extends ConstructionTemplate {

	private static final String NAME = "Puerto Estelar";
	private static final Value VALUE = new Value(150,100);
	private static final int CONSTRUCTION_TIME = 10;
	private static final int HEALTH = 1300;
	
    public PuertoEstelarTerranTemplate() {
    	addEnabledTemplate(new EspectroTemplate());
    	addEnabledTemplate(new NaveTransporteTerranTemplate());
    	addEnabledTemplate(new NaveCienciaTemplate());
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