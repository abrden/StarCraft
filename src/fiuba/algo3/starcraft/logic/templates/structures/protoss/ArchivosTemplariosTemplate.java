package fiuba.algo3.starcraft.logic.templates.structures.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.structures.ConstructionTemplate;
import fiuba.algo3.starcraft.logic.templates.units.protoss.AltoTemplarioTemplate;

public class ArchivosTemplariosTemplate extends ConstructionTemplate {

	private static final String NAME = "Archivos Templarios";
	private static final Value VALUE = new Value(150,200);
	private static final int CONSTRUCTION_TIME = 9;
	private static final int HEALTH = 500;
	private static final int SHIELD = 500;
	
    public ArchivosTemplariosTemplate() {
		enabledTemplates.add(new AltoTemplarioTemplate());
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