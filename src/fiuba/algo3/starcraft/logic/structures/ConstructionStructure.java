package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.templates.Life;
import fiuba.algo3.starcraft.logic.templates.TemplateID;
import fiuba.algo3.starcraft.logic.templates.UnitTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionStructure extends Structure {
	
	private Collection<UnitTemplate> templates;
	
	public ConstructionStructure(Life life, Collection<UnitTemplate> templates) {
		super(life);
		this.templates = templates;
	}

	private UnitTemplate getTemplateWithId(TemplateID id) {
		for (UnitTemplate template : templates) {
			if (template.getId() == id)
				return template;
		}
		return null;
	}
	
	private void populationSpaceCheck(UnitTemplate template, int populationSpace) throws QuotaExceeded {
		if ((populationSpace == 0) || (populationSpace < template.getPopulationQuota()))
			throw new QuotaExceeded();
	}
	
	public Unit createUnit(TemplateID id, Resources resources, int populationSpace) throws QuotaExceeded, InsufficientResources {
		UnitTemplate template = this.getTemplateWithId(id);
		populationSpaceCheck(template, populationSpace);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
		return template.create();
	}
	
	public StructureID getId() {
		return StructureID.ConstructionStructure;
	}

}
