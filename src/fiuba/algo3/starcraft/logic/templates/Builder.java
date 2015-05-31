package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.StructureID;

public abstract class Builder {
	
	protected static LinkedList<StructureTemplate> templates;
	
	public StructureTemplate getTemplate(StructureID id) {
		for (StructureTemplate template : templates) {
			if (template.getStructureId() == id)
				return template;
		}
		return null;
	}
}
