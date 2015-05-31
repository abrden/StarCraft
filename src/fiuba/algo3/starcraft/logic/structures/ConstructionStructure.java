package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.templates.Life;
import fiuba.algo3.starcraft.logic.templates.Template;

public class ConstructionStructure extends Structure {
	
	private Collection<Template> templates;
	
	ConstructionStructure(Life life) {
		super(life);
	}
	
	public StructureID getId() {
		return StructureID.ConstructionStructure;
	}
}
