package fiuba.algo3.starcraft.logic.structures;

import java.util.Collection;

import fiuba.algo3.starcraft.logic.player.Player;
import fiuba.algo3.starcraft.logic.player.Resources;
import fiuba.algo3.starcraft.logic.structures.exceptions.InsufficientResources;
import fiuba.algo3.starcraft.logic.structures.exceptions.QuotaExceeded;
import fiuba.algo3.starcraft.logic.structures.exceptions.TemplateNotFound;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;
import fiuba.algo3.starcraft.logic.units.Unit;

public class ConstructionStructure extends Structure {
	
	private final Collection<UnitTemplate> templates;
	private static final int POPULATION_MAXIMUM = 200;
	
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
	
	private void populationSpaceCheck(UnitTemplate template, int currentPopulation, int populationQuota) throws QuotaExceeded {
		int populationSpace = populationQuota - currentPopulation;
		int unitSpace = template.getPopulationQuota();
		if ((populationSpace == 0) || (populationSpace < unitSpace) || ((populationSpace + unitSpace) > POPULATION_MAXIMUM))
			throw new QuotaExceeded();
	}
	
	public Construction<Unit> create(String name, Resources resources, int currentPopulation, int populationQuota) throws QuotaExceeded, InsufficientResources, TemplateNotFound {
		UnitTemplate template = this.getTemplateWithName(name);
		populationSpaceCheck(template, currentPopulation, populationQuota);
		resources.remove(template.getValue().getMineralValue(), template.getValue().getGasValue());
		
		return new Construction<Unit>(template.create(), template.getConstructionTime());
	}

	public void update(Player player) {
		life.regenerateShield();
	}

}
