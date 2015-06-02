package fiuba.algo3.starcraft.logic.templates;

import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class NaveCienciaTemplate extends MagicalTemplate {
	
	private static NaveCienciaTemplate instance = new NaveCienciaTemplate();

	private NaveCienciaTemplate() {
		name = "NaveCiencia";
		value = new Value(100, 225);
		constructionTime = 10;
		health = 200;
		vision = 10;
		initialEnergy = 50;
		maximumEnergy = 200;
		energyGainPerTurn = 10;
		transportationQuota = 0;
		populationQuota = 2;
		//Faltan poderes y habilidades
	}
	
	public TemplateID getId() {
		return TemplateID.NaveCienciaTemplate;
	}

	public MagicalUnit create() {
		return new MagicalUnit(new Life(health), vision,
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, populationQuota);
	}
	
	public static NaveCienciaTemplate getInstance() {
		return instance;
	}

}
