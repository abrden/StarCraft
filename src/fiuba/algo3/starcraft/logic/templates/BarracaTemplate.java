package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.structures.ConstructionStructure;

public class BarracaTemplate extends ConstructionTemplate {
	
	private static BarracaTemplate instance = new BarracaTemplate();

	private BarracaTemplate() {
		value = new Value(150,0);
		constructionTime = 12;
		health = 1000;
		enabledTemplates.add(MarineTemplate.getInstance());
	}
	
	public static BarracaTemplate getInstance() {
		return instance;
	}

	public ConstructionStructure create() {
		return new ConstructionStructure(new Life(health), enabledTemplates);
	}
}
