package fiuba.algo3.starcraft.logic.templates.units.terran;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.qualities.EMP;
import fiuba.algo3.starcraft.logic.templates.qualities.Life;
import fiuba.algo3.starcraft.logic.templates.qualities.Radiacion;
import fiuba.algo3.starcraft.logic.templates.qualities.Value;
import fiuba.algo3.starcraft.logic.templates.units.MagicalTemplate;
import fiuba.algo3.starcraft.logic.units.MagicalUnit;

public class NaveCienciaTemplate extends MagicalTemplate {
	
	private static NaveCienciaTemplate instance = new NaveCienciaTemplate();
	
	private NaveCienciaTemplate() {
		name = "Nave Ciencia";
		value = new Value(100, 225);
		constructionTime = 10;
		health = 200;
		vision = 10;
		initialEnergy = 50;
		maximumEnergy = 200;
		energyGainPerTurn = 10;
		transportationQuota = 0;
		populationQuota = 2;
		stepsPerTurn = 10;
		powers.add(new EMP());
		powers.add(new Radiacion());
	}

	public MagicalUnit create(Point position) {
		return new MagicalUnit(name, new Life(health), position,
				vision, stepsPerTurn, powers, 
				initialEnergy, maximumEnergy, energyGainPerTurn, 
				transportationQuota, populationQuota);
	}
	
	public static NaveCienciaTemplate getInstance() {
		return instance;
	}

}
