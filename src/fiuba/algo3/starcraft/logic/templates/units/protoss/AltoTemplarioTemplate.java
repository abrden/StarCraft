package fiuba.algo3.starcraft.logic.templates.units.protoss;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.Alucinacion;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.TormentaPsionica;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MagicalTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class AltoTemplarioTemplate extends MagicalTemplate {

	private static AltoTemplarioTemplate instance = new AltoTemplarioTemplate();
	
	private AltoTemplarioTemplate() {
		name = "Alto Templario";
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
		stepsPerTurn = 7;
		powers.add(new TormentaPsionica());
		powers.add(new Alucinacion());
	}

	public MagicalUnit create(Point position) {
		return new MagicalUnit(name, new Life(health, shield), position,
				vision, stepsPerTurn, powers,
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, populationQuota);
	}

	public static AltoTemplarioTemplate getInstance() {
		return instance;
	}

}
