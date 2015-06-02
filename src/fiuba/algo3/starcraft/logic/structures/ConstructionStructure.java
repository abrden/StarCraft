package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.player.Construction;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;

public class ConstructionStructure extends Structure {
	
	private Collection<UnitTemplate> templates;
	
	public ConstructionStructure(String name, Life life, Collection<UnitTemplate> templates) {
		super(name, life);
		this.templates = templates;
	}

	private UnitTemplate getTemplateWithName(String name) throws TemplateNotFound {
		for (UnitTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		throw new TemplateNotFound();
	}
	
	private void populationSpaceCheck(UnitTemplate template, int populationSpace) throws QuotaExceeded {
		if ((populationSpace == 0) || (populationSpace < template.getPopulationQuota()))
			throw new QuotaExceeded();
	}
	
	public Construction create(String name, Resources resources, int populationSpace) throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		UnitTemplate template = this.getTemplateWithName(name);
		populationSpaceCheck(template, populationSpace);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
		
		return new Construction(template.create(), template.getConstructionTime());
	}
	
	public StructureID getId() {
		return StructureID.ConstructionStructure;
	}

}
