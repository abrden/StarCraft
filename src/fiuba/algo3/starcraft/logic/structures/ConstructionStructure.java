package fiuba.algo3.starcraft.logic.structures;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionStructure extends Structure {
	
	private final Iterable<UnitTemplate> templates;
	
	public ConstructionStructure(String name, Life life, Point position, Iterable<UnitTemplate> templates) {
		super(name, life, position);
		this.templates = templates;
	}

	private UnitTemplate getTemplateWithName(String name) throws TemplateNotFound {
		for (UnitTemplate template : templates) {
			if (template.getName() == name)
				return template;
		}
		throw new TemplateNotFound();
	}
	
	private void populationSpaceCheck(UnitTemplate template, int currentPopulation, int populationQuota) throws QuotaExceeded {
		int populationSpace = populationQuota - currentPopulation;
		int unitSpace = template.getPopulationQuota();
		
		if ((populationSpace == 0) || (populationSpace < unitSpace))
			throw new QuotaExceeded();
	}
	
	public Construction<Unit> create(String name, Point position, Resources resources, int currentPopulation, int populationQuota) throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		UnitTemplate template = this.getTemplateWithName(name);
		populationSpaceCheck(template, currentPopulation, populationQuota);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
		
		return new Construction<Unit>(template.create(position), template.getConstructionTime());
	}

	public void update() {
		life.regenerateShield();
	}

}
