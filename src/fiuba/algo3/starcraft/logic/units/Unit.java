package fiuba.algo3.starcraft.logic.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.Life;

public abstract class Unit {
	
	private int vision;
	private int populationQuota; //suministro
	private Life life;
	private Point position;
}
