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

	private UnitTemplate getTemplateWithName(String name) {
		for (UnitTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		return null;
	}
	
	private void populationSpaceCheck(UnitTemplate template, int populationSpace) throws QuotaExceeded {
		if ((populationSpace == 0) || (populationSpace < template.getPopulationQuota()))
			throw new QuotaExceeded();
	}
	
	public Unit createUnit(String name, Resources resources, int populationSpace) throws QuotaExceeded, InsufficientResources {
		UnitTemplate template = this.getTemplateWithName(name);
		populationSpaceCheck(template, populationSpace);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
		return template.create();
	}
	
	public StructureID getId() {
		return StructureID.ConstructionStructure;
	}

}
