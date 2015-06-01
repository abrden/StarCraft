package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.templates.Life;
import fiuba.algo3.starcraft.logic.templates.UnitTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionStructure extends Structure {
	
	private Collection<UnitTemplate> templates;
	
	public ConstructionStructure(Life life, Collection<UnitTemplate> templates) {
		super(life);
		this.templates = templates;
	}

	public Unit buildWith(Resources resources) {
		//TODO: Completar metodo
		return null;
	}
	
	public StructureID getId() {
		return StructureID.ConstructionStructure;
	}
}
