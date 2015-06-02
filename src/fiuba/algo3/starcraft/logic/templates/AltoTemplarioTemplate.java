package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class AltoTemplarioTemplate extends MagicalTemplate {

	private static AltoTemplarioTemplate instance = new AltoTemplarioTemplate();
	
	private AltoTemplarioTemplate() {
		name = "AltoTemplario";
		value = new Value(50, 150);
		constructionTime = 7;
		health = 40;
		shield = 40;
		vision = 7;
		initialEnergy = 50;
		maximumEnergy = 200;
		energyGainPerTurn = 15;
		transportationQuota = 2;
		populationQuota = 2;
		//Faltan poderes y habilidades
	}
	
	public TemplateID getId() {
		return TemplateID.AltoTemplarioTemplate;
	}

	public MagicalUnit create() {
		return new MagicalUnit(new Life(health, shield), vision,
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, populationQuota);
	}

	public static AltoTemplarioTemplate getInstance() {
		return instance;
	}

}
