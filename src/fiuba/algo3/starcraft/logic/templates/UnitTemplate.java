package fiuba.algo3.starcraft.logic.templates;

public abstract class UnitTemplate extends Template {

	protected int vision;
	protected int populationQuota; //suministro
	protected int transportationQuota; //transporte
	protected Damage damage;
	protected int damageRange; //TODO: VER COMO HACEMOS CON EL GOLLIAT QUE ES EL UNICO QUE TIENE RANGOS DIFERENTES EN SPACE Y LAND
	
}
