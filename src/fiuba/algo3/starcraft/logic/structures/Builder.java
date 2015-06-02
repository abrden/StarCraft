package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;
import java.util.Map;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.templates.StructureTemplate;

public abstract class Builder {

	protected Collection<StructureTemplate> templates;
	protected Map<String,String> dependsOn;
	
	public Construction create(String name, Resources resources, Collection<Structure> built) throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		this.structureRequiredExists(name, built);
		StructureTemplate template = this.getTemplateWithName(name);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
			
		return new Construction(template.create(), template.getConstructionTime());
	}
	
	private StructureTemplate getTemplateWithName(String name) throws TemplateNotFound {
		for (StructureTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		throw new TemplateNotFound();
	}

	private boolean structureRequiredExists(String name, Collection<Structure> built) throws MissingStructureRequired {
		if (!dependsOn.containsKey(name)) return true;
		else {
			String structureRequired = dependsOn.get(name);
			for (Structure structure : built) {
				if (structure.getName().equals(structureRequired))
					return this.structureRequiredExists(structureRequired, built);
			}
			throw new MissingStructureRequired();
		}
	}

}
