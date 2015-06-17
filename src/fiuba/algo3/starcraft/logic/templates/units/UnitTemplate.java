package fiuba.algo3.starcraft.logic.templates.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.Template;
import fiuba.algo3.starcraft.logic.units.Unit;


public abstract class UnitTemplate extends Template {
	
	public abstract int getPopulationQuota();

	public abstract Unit create(Point position);
	
}
