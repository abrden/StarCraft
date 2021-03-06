package fiuba.algo3.starcraft.logic.templates.structures;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.templates.units.UnitTemplate;

public abstract class ConstructionTemplate extends StructureTemplate {
	
	protected Collection<UnitTemplate> enabledTemplates = new LinkedList<UnitTemplate>();

	protected void addEnabledTemplate(UnitTemplate template) {
		enabledTemplates.add(template);
	}
}
