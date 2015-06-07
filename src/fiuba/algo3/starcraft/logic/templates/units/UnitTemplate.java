package fiuba.algo3.starcraft.logic.templates.units;

import fiuba.algo3.starcraft.logic.map.Point;
import fiuba.algo3.starcraft.logic.templates.Template;
import fiuba.algo3.starcraft.logic.templates.qualities.Damage;
import fiuba.algo3.starcraft.logic.units.Unit;


public abstract class UnitTemplate extends Template {

	protected int vision;
	protected int populationQuota; //suministro
	protected int transportationQuota; //transporte
	protected Damage damage;
	protected int damageRange; //TODO: VER COMO HACEMOS CON EL GOLLIAT QUE ES EL UNICO QUE TIENE RANGOS DIFERENTES EN SPACE Y LAND
	protected int stepsPerTurn;
	
	public int getPopulationQuota() {
		return populationQuota;
	}

	public abstract Unit create(Point position);
	
}
