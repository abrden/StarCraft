package fiuba.algo3.starcraft.logic.templates;

import java.util.LinkedList;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class BarracaTemplate extends ConstructionTemplate {
	
	private static BarracaTemplate instance = new BarracaTemplate();

	private BarracaTemplate() {
		name = "Barraca";
		value = new Value(150,0);
		constructionTime = 12;
		health = 1000;
		enabledTemplates = new LinkedList<UnitTemplate>();
		enabledTemplates.add(MarineTemplate.getInstance());
	}
	
	public static BarracaTemplate getInstance() {
		return instance;
	}

	public ConstructionStructure create() {
		return new ConstructionStructure(name, new Life(health), enabledTemplates);
	}
}
