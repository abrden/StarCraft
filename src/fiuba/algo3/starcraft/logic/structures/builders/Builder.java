package fiuba.algo3.starcraft.logic.structures.builders;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.Construction;
import fiuba.algo3.starcraft.logic.structures.Structure;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.MissingStructureRequired;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.structures.StructureTemplate;

public abstract class Builder {

	protected Collection<StructureTemplate> templates = new LinkedList<StructureTemplate>();
	protected Map<String,String> dependsOn = new HashMap<String,String>();
	
	public Construction<Structure> create(String name, Point position, Resources resources, Iterable<Structure> built) throws MissingStructureRequired, InsufficientResources, TemplateNotFound {
		
		this.structureRequiredExists(name, built);
		
		StructureTemplate template = this.getTemplateWithName(name);
		
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
			
		return new Construction<Structure>(template.create(position), template.getConstructionTime());
	}
	
	private StructureTemplate getTemplateWithName(String name) throws TemplateNotFound {
		for (StructureTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		throw new TemplateNotFound();
	}

	private boolean structureRequiredExists(String name, Iterable<Structure> built) throws MissingStructureRequired {
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
