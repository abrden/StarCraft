package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;
import java.util.Map;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.templates.StructureTemplate;

public abstract class Builder {

	protected Collection<StructureTemplate> templates;
	protected Map<String,String> dependsOn;
	
	public Structure create(String name, Resources resources, Collection<Structure> built) throws MissingStructureRequired, InsufficientResources {
		if (this.structureRequiredExists(name, built)) {
			StructureTemplate template = this.getTemplateWithName(name);
			resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
			return template.create();
		} else throw new MissingStructureRequired();
	}
	
	private StructureTemplate getTemplateWithName(String name) {
		for (StructureTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		return null;
	}

	private boolean structureRequiredExists(String name, Collection<Structure> built) {
		if (!dependsOn.containsKey(name)) return true;
		else {
			String structureRequired = dependsOn.get(name);
			for (Structure structure : built) {
				if (structure.getName().equals(structureRequired))
					return this.structureRequiredExists(structureRequired, built);
			}
			return false;
		}
	}

}
